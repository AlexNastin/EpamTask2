package by.epam.task2.composite;

import java.util.List;

public interface ComponentText {

	public void add(ComponentText component);

	public boolean remove(ComponentText component);

	public boolean removeAll(List<ComponentText> list);

	public ComponentText getChild(int i);
	
	public List<?> getList();
	
	public ComponentText getFirstElement();
}
