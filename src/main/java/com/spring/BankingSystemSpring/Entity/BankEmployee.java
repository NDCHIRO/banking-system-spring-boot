package com.spring.BankingSystemSpring.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Bank_Employee")

public class BankEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String position;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}


}
