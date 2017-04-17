package com.user.registration.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Users  {


	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "user_name")
	@NotEmpty
	private String userName;

	@Column(name = "email_address")
	@NotEmpty
	private String emailAddress;

	@JsonFormat(pattern="MM-dd-yyyy")
	@Column(name = "registered_date", nullable = false)
	private Date registeredDate=new Date();

	public Users() {
		super();
	}

	public Users(Long id) {
		super();
		this.id=id;
	}

	public Users(String userName, String emailAddress) {
		super();
		this.userName = userName;
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {

		this.registeredDate=registeredDate;
	}

}
