package br.com.opeads.error.model;

import java.util.Date;

public class Error {

	private String title;
	
	private String description;
	
	private Date error;
	
	private Long status;
	
	private String message;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getError() {
		return error;
	}

	public void setError(Date error) {
		this.error = error;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
