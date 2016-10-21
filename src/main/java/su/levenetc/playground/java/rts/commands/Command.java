package su.levenetc.playground.java.rts.commands;


import io.reactivex.Single;

/**
 * Created by eleven on 15/10/2016.
 */
public interface Command {
	Single execute();
}