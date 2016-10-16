package su.levenetc.playground.java.rts.units;

import su.levenetc.playground.java.rts.components.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created by eleven on 15/10/2016.
 */
public class BasicUnit implements Unit {

	private List<Component> components;
	private HashMap<Class, Component> map;
	private int id;

	public BasicUnit(int id) {
		this.id = id;
	}

	@Override public int getId() {
		return id;
	}

	@Override public void setComponents(List<Component> components) {
		this.components = components;
		this.map = new HashMap<>();
		for (Component component : components)
			map.put(component.getClass(), component);
	}

	@Override public Component getComponent(Class clazz) {
		return map.get(clazz);
	}
}
