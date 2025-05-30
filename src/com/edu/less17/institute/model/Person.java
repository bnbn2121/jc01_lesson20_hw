package com.edu.less17.institute.model;

import java.util.Objects;

public abstract class Person {
	private String name;

	public Person() {
		this.name = "Неизвестная личность";
	}

	public Person(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void doSomething();
	
	public abstract String getStringData();
	
	public abstract Person readDataFromString(String str);

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [" + (name != null ? "name=" + name : "") + "]";
	}

}
