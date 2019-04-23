package org.woadec.customizeds;

public class Status {
	
	private boolean success=true;
	private Class clasName;
	private String method;
	private String message;

	public Status(Class clasName, String method, String message) {
		super();
		this.clasName = clasName;
		this.method = method;
		this.message = message;
		if(message!="")this.success=false;
		
	}

	
	public void setStatus(Class clasName, String method, String message) {
		this.clasName = clasName;
		this.method = method;
		this.message = message;
		if(message!="")this.success=false;
		
	}

	public boolean isSuccess() {
		return success;
	}


	public Class getClasName() {
		return clasName;
	}


	public String getMethod() {
		return method;
	}


	public String getMessage() {
		if(message=="") return "Well Done";
		return message;
	}


	@Override
	public String toString() {
		return "Status [success=" + success + ", clasName=" + clasName + ", method=" + method + ", message=" + message
				+ "]";
	}
	
	
	
	
	

}
