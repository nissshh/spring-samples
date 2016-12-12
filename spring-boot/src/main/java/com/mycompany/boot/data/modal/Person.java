/**
 * 
 */
package com.mycompany.boot.data.modal;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NishantS
 *
 */
@Document(collection="person")
public class Person {
	@Id
	private String id;
	@JsonProperty
	private boolean isActive;
	@JsonProperty
	private double balance;
	@JsonProperty
	private Integer age;
	@JsonProperty
	private String name;
	@JsonProperty
	private String gender;
	@JsonProperty
	private String company;
	@JsonProperty
	private String email;
	@JsonProperty
	private String phone;
	@JsonProperty
	private String address;
	@JsonProperty
	private String about;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Person(String name) {
		super();
		this.name = name;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", isActive=" + isActive + ", balance=" + balance + ", age=" + age + ", name="
				+ name + ", gender=" + gender + ", company=" + company + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", about=" + about + "]";
	}
	
	
}
