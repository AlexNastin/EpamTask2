package by.epam.task2.composite;

import java.util.List;

public class SymbolLeaf implements ComponentText {
	private char symbol;

	public SymbolLeaf(char symbol) {
		super();
		this.symbol = symbol;
	}

	public SymbolLeaf(String symbol) {
		super();
		this.symbol = symbol.charAt(0);
	}

	public SymbolLeaf() {
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public void add(ComponentText component) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(ComponentText component) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(List<ComponentText> list) {
		throw new UnsupportedOperationException();

	}

	@Override
	public ComponentText getChild(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + symbol;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SymbolLeaf other = (SymbolLeaf) obj;
		if (symbol != other.symbol) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(symbol);
		return stringBuilder.toString();
	}

	@Override
	public List<?> getList() {
		throw new UnsupportedOperationException();
	}


	@Override
	public ComponentText getFirstElement() {
		throw new UnsupportedOperationException();
	}

}
