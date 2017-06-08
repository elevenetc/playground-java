package su.levenetc.playground.java.datastructures.multibranch;

/**
 * Created by eugene.levenetc on 08/06/2017.
 */
public interface Flow {
    Flow then(Flow next);

    Flow thenOneOf(Flow... flows);
}
