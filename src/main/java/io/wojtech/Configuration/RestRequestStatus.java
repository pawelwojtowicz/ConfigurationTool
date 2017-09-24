package io.wojtech.Configuration;

public class RestRequestStatus {
	
	boolean operationStatus;
	
	String comment;
	
	public RestRequestStatus() {
		super();
		this.operationStatus = false;
		this.comment = "";
	}

	public boolean isOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(boolean operationStatus) {
		this.operationStatus = operationStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
