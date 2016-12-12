package com.mycompany.boot.rest;

public enum SERVICE_STATUS {

	STARTED("STARTED"), NONE("NONE"), RUNNING("RUNNING"), SUSPEND("SUSPEND"), STOPPED("STOPPED"), UNKNOWN("UNKNOWN");

	String status;

	SERVICE_STATUS(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}