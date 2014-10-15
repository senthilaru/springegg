package com.spsa.springegg.domain;

public class SPMetrics {
	private String clientIp;
	private String browser;
	private String inputParams;
	private String errMsg;
	private boolean success;
	private String className;
	private String operationName;
	private long responseTime;
	
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getInputParams() {
		return inputParams;
	}
	public void setInputParams(String inputParams) {
		this.inputParams = inputParams;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SPMetrics [clientIp=").append(clientIp).append(", browser=").append(browser).append(", inputParams=").append(inputParams)
				.append(", errMsg=").append(errMsg).append(", success=").append(success).append(", className=").append(className)
				.append(", operationName=").append(operationName).append(", responseTime=").append(responseTime).append("]");
		return builder.toString();
	}
	
	
}
