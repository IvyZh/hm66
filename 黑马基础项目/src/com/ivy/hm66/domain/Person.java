package com.ivy.hm66.domain;

public class Person {

	String name;
	int salary;
	String phone;

	public Person(String name, int salary, String phone) {
		super();
		this.name = name;
		this.salary = salary;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "name=" + name + ", salary=" + salary + ", phone=" + phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
