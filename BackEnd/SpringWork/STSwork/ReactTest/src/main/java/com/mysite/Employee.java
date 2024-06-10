package com.mysite;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String name;
	private String email;
	
	public Employee() {}

	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
}
