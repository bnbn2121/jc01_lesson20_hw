package com.edu.less17.institute.model;

import java.util.Objects;

public class Teacher extends Staff {
	private String specialization;
	
	public Teacher() {
		super();
		specialization = "нет данных";
	}

	public Teacher(String name, String specialization) {
		super(name);
		this.specialization = specialization;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public void doSomething() {
		teach();
	}
	
	public void teach() {
		System.out.println("я преподаю(" +getClass().getSimpleName()+ " " + getName()+")");
	}
	
	@Override
	public String getStringData() {
		return String.format("%15s | %s | %s", getClass().getSimpleName(), getName(), specialization);
	}
	
	@Override
	public Teacher readDataFromString(String str) {
		String[] data = str.split("\\|");
		setName(data[1].trim());
		setSpecialization(data[2].trim());
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(specialization);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(specialization, other.specialization);
	}

	@Override
	public String toString() {
		return "Teacher [" + (specialization != null ? "specialization=" + specialization : "") + "]";
	}
	
	
}
