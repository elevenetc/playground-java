package su.levenetc.playground.java.rxjava;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.View;

import static su.levenetc.playground.java.rxjava.PausableObservable.Item.TYPE.IMMEDIATE;
import static su.levenetc.playground.java.rxjava.PausableObservable.Item.TYPE.RESPONSE_REQUIRED;
import static su.levenetc.playground.java.rxjava.PausableObservable.Item.TYPE.WITH_PAUSE;

public class PausableObservable extends View {

    Observable<Item> observable = Observable.create(
            new Sub(
                    Item.immediate("Hello"),
                    Item.paused("How are you?", 1000),
                    Item.responseRequired("How many items do you need?"),
                    Item.immediate("Clear, thanks.")
            )
    );

    private Disposable sub;

    @Override
    public void onResume() {
        super.onResume();
        sub = observable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread())
                .subscribe(this::handleItem);
    }

    @Override
    public void onPause() {
        super.onPause();
        sub.dispose();
    }

    private void handleItem(Item value) {
        Out.pln("handle", value.data);
    }

    static class Sub implements ObservableOnSubscribe<Item> {

        Item[] items;
        int index;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        private ObservableEmitter<Item> emitter;

        public Sub(Item... items) {
            this.items = items;
        }

        @Override
        public void subscribe(ObservableEmitter<Item> emitter) {
            this.emitter = emitter;
            handleNext();
        }

        public void postResponse() {
            //check if previous element required response
            if (index - 1 >= 0 && items[index - 1].type == RESPONSE_REQUIRED) {
                handleNext();
            }
        }

        private void handleNext() {
            if (isCompleted()) {
                emitter.onComplete();
            } else {

                Item i = items[index];

                if (i.type == WITH_PAUSE) {

                    if (isReadyForEmission()) {
                        emitNext();
                        executor.schedule(this::handleNext, i.duration, TimeUnit.MILLISECONDS);
                    }

                } else if (i.type == IMMEDIATE) {
                    if (isReadyForEmission()) {
                        emitNext();
                        handleNext();
                    }
                } else if (i.type == RESPONSE_REQUIRED) {
                    if (isReadyForEmission()) {
                        emitNext();
                    }
                }
            }
        }

        private boolean isCompleted() {
            return index > items.length - 1;
        }

        private boolean isReadyForEmission() {
            return emitter != null && !emitter.isDisposed() && !isCompleted();
        }

        private void emitNext() {
            emitter.onNext(items[index]);
            index++;
        }
    }

    static class Item {

        long duration;
        Object data;
        TYPE type;

        public Item(long duration, Object data, TYPE type) {
            this.duration = duration;
            this.data = data;
            this.type = type;
        }

        static Item paused(Object data, long duration) {
            return new Item(duration, data, WITH_PAUSE);
        }

        static Item responseRequired(Object data) {
            return new Item(0, data, RESPONSE_REQUIRED);
        }

        static Item immediate(Object data) {
            return new Item(0, data, IMMEDIATE);
        }

        enum TYPE {
            IMMEDIATE, WITH_PAUSE, RESPONSE_REQUIRED
        }
    }
}
