package com.DASANI.JAFU.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "user")
public class User 
{
	public User() {
		super();
	}

	public User(String username, String password, String phoneNum) {
		super();
		this.username = username;
		this.password = password;
		this.phoneNum = phoneNum;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userID")
    private Long userID;
	
	@Expose
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Expose
	@Column(name="phoneNum")
	private String phoneNum;

	@Expose
	@Column(name="token")
	private String token = "-";

	@Expose
	@Column(name="userType")
	private String userType = "Buyer";

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString(){
	    return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
	}
}