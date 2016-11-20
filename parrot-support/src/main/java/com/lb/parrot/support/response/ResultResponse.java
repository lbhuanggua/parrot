package com.lb.parrot.support.response;

public class ResultResponse implements WeChatResponse {

	private static final long serialVersionUID = -747754231226019495L;
	/**
	 * 结果状态
	 */
	private boolean status;
	/**
	 * 返回结果
	 */
	private String result;

	public ResultResponse() {
		super();
	}

	public ResultResponse(boolean status, String result) {
		super();
		this.status = status;
		this.result = result;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResultResponse [status=" + status + ", result=" + result + "]";
	}

}
