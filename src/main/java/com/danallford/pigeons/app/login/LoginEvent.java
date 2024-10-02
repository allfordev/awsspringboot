package com.danallford.pigeons.app.login;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class LoginEvent {

	public enum EventType {
		LOGGED_IN,
		LOGGED_OUT,
		FAILED_LOGIN
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private EventType eventType;

	private String username;

	private Date eventTime;

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String name) {

		this.username = name;
	}

	public void setEventTime(Date eventTime) {

		this.eventTime = eventTime;
	}

	public Date getEventTime() {

		return eventTime;
	}

	public void setEventType(EventType eventType) {

		this.eventType = eventType;
	}

	public EventType getEventType() {

		return eventType;
	}
}
