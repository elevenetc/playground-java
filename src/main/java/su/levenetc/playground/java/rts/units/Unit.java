package su.levenetc.playground.java.rts.units;

import su.levenetc.playground.java.rts.components.Component;

import java.util.List;

/**
 * Created by eleven on 15/10/2016.
 */
public interface Unit {

	int getId();

	void setComponents(List<Component> components);

	<T extends Component> T getComponent(Class<T> clazz);

}
