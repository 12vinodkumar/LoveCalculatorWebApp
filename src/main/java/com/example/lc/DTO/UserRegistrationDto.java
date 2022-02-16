package com.example.lc.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.lc.validator.Age;
import com.example.lc.validator.Phone;
import com.example.lc.validator.Phone;

public class UserRegistrationDto {
	@NotEmpty
	private String personName;
	private String userRegName;
	private char[] password;
	
	private String country;
	private String[] hobbies;
	private String gender;
	@Age
	private int age;
	@Phone(message="phone number must contain 10 digits !!!")
	private long phoneNumber;
	
	private String email;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserRegName() {
		return userRegName;
	}

	public void setUserRegName(String userRegName) {
		this.userRegName = userRegName;
	}
}
