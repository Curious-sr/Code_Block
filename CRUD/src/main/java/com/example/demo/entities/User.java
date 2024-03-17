package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String Name;
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + ", City=" + City + ", Status=" + Status + "]";
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String name, String city, String status) {
		super();
		this.id = id;
		Name = name;
		City = city;
		Status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	private String City;
	
	
	private String Status;
}



