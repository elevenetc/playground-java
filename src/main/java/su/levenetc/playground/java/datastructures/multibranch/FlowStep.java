package su.levenetc.playground.java.datastructures.multibranch;

import su.levenetc.playground.java.utils.Out;

import static java.lang.String.format;

/**
 * Created by eugene.levenetc on 08/06/2017.
 */
public class FlowStep<Input> {

    MultiFlowGraph flowBuilder;
    protected String name;

    public FlowStep(MultiFlowGraph flowBuilder) {
        this.flowBuilder = flowBuilder;
    }

    public FlowStep withoutBack() {
        return this;
    }


    public void goTo(Class<? extends FlowStep<Void>> target) {

    }

    public <Param> void goTo(Class<? extends FlowStep<Param>> target, Param nextParam) {
        flowBuilder.goTo(this, target);
    }

    protected void nextStep() {
        Out.pln(this, "nextStep");
        flowBuilder.goToNext(this);
    }

    public FlowStep then(FlowStep next) {
        flowBuilder.then(this, next);
        return next;
    }

    public FlowStep thenOneOf(FlowStep... nextSteps) {
        flowBuilder.thenOneOf(this, nextSteps);
        return this;
    }

    public FlowStep once() {
        return this;
    }

    public FlowStep ifNeeded() {
        return this;
    }

    public FlowStep withBack() {
        //allow back to previous
        return this;
    }

    public FlowStep onSuccess(FlowStep flowStep) {
        return this;
    }

    public FlowStep withBackTo(FlowStep flowStep) {
        return this;
    }

    public FlowStep withErrorBackTo(FlowStep step) {
        //add error even which allows to just back to particular step
        return this;
    }


    public void onStart() {
        //Logger.log(this, "onStart");
        doWork();
    }

    public void doWork() {
        Out.pln(this, "doWork");
    }

    public void onPause() {

    }

    public void onSuccess() {

    }

    public void onBackPressed() {

    }

    public void onRetry() {

    }

    @Override
    public String toString() {
        return format("{%s}", name);
    }
}

