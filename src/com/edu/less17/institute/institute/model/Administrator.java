package com.edu.less17.institute.model;

public class Administrator extends Staff {
	
	
	public Administrator() {
	}

	public Administrator(String name) {
		super(name);
	}

	@Override
	public void doSomething() {
		administrate();
	}

	public void administrate() {
		System.out.println("я управляю(" +getClass().getSimpleName()+ " " + getName()+")");
	}
	
	@Override
	public String getStringData() {
		return String.format("%15s | %s", getClass().getSimpleName(), getName());
	}
	
	@Override
	public Administrator readDataFromString(String str) {
		String[] data = str.split("\\|");
		setName(data[1].trim());
		return this;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrator []";
	}
	
}
