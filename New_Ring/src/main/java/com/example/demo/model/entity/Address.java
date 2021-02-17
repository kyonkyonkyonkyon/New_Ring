package com.example.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String post_Number;

	private String address1;

	private String address2;

	protected Address() {

	}

	public Address(String post_Number, String address1, String address2) {

		this.post_Number = post_Number;
		this.address1 = address1;
		this.address2 = address2;

	}

}