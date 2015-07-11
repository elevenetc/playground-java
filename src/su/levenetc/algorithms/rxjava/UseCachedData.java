package su.levenetc.algorithms.rxjava;


import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import su.levenetc.algorithms.utils.Out;

/**
 * Created by elevenetc on 11/07/15.
 * http://blog.danlew.net/2015/06/22/loading-data-from-multiple-sources-with-rxjava/
 */
public class UseCachedData {


	private static Observable<Data> network = Observable.create(new Observable.OnSubscribe<Data>() {
		@Override public void call(Subscriber<? super Data> subscriber) {
			Data data = new Data();
			data.from = "network";
			Out.pln("network request finished");
			subscriber.onNext(data);
			subscriber.onCompleted();
		}
	}).doOnNext(cacheOnDisk).doOnNext(cacheOnMemory);
	private static Data memoryCache;
	private static Action1<Data> cacheOnMemory = new Action1<Data>() {
		@Override public void call(Data data) {
			Out.pln("cached on memory");
			memoryCache = data;
		}
	};
	private static Observable<Data> memory = Observable.create(new Observable.OnSubscribe<Data>() {
		@Override public void call(Subscriber<? super Data> subscriber) {
			if (memoryCache != null) {
				memoryCache.from = "memory";
				subscriber.onNext(memoryCache);
			}
			subscriber.onCompleted();
		}
	});
	private static Data diskCache;
	private static Action1<Data> cacheOnDisk = new Action1<Data>() {
		@Override public void call(Data data) {
			Out.pln("cached on disk");
			diskCache = data;
		}
	};
	private static Observable<Data> disk = Observable.create(new Observable.OnSubscribe<Data>() {
		@Override public void call(Subscriber<? super Data> subscriber) {
			if (diskCache != null) {
				diskCache.from = "disk";
				subscriber.onNext(diskCache);
			}
			subscriber.onCompleted();
		}
	}).doOnNext(cacheOnMemory);

	public static void run() {
		loadData();
		loadData();
		Out.pln(" - clear memory");
		memoryCache = null;
		loadData();
		Out.pln(" - clear disk and memory");
		diskCache = null;
		memoryCache = null;
		loadData();
	}

	private static void loadData() {
		Out.pln("loading...");
		Observable
				.concat(memory, disk, network)
				.first()
				.subscribe(UseCachedData::handleData);
	}

	private static void handleData(Data data) {
		Out.pln("loaded from: " + data.from);
	}

	private static class Data {
		private String from;
	}

}
