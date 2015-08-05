package com.crys.response;

public class Response<T> extends BaseResponse {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
