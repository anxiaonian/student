package com.entity;

public class Admin {
String password;
String username;
String phoneNumber;

public Admin(String password, String username, String phoneNumber) {
			this.password=password;
			this.username=username;
			this.phoneNumber=phoneNumber;
}
  public Admin() {}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}


}
