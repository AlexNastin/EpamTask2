package by.epam.task2.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements ComponentText {

	private List<ComponentText> componentList;

	public CompositeText() {
		super();
		this.componentList = new ArrayList<ComponentText>();
	}

	public CompositeText(List<ComponentText> componentList) {
		super();
		this.componentList = componentList;
	}

	@Override
	public void add(ComponentText component) {
		componentList.add(component);
	}

	@Override
	public ComponentText getChild(int i) {
		return componentList.get(i);
	}

	@Override
	public boolean remove(ComponentText component) {
		return componentList.remove(component);
	}

	@Override
	public boolean removeAll(List<ComponentText> list) {
		return componentList.removeAll(list);

	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < componentList.size(); i++) {
			stringBuilder.append(componentList.get(i).toString());
		}
		return stringBuilder.toString();
	}

	@Override
	public List<?> getList() {
		return componentList;
	}

	@Override
	public ComponentText getFirstElement() {
		ComponentText component = null;
		try {
			component = componentList.get(0);
		} catch (IndexOutOfBoundsException e) {
			remove(component);
		}
		return component;
	}

}
