package com.cafe24.gg.DTO;

import com.cafe24.gg.Vo.Product;

public class JSONResult {
	private String result;  //success, fail
	private String message; //if fail, set
	private Object data;    //if success, set

	public static JSONResult success(Object data) {
		return new JSONResult("success", null, data);
	}

	public static JSONResult fail(String message) {
		return new JSONResult("fail", message, null);
	}
	
	public JSONResult(String result, String message, Object data) {
		// 여기 왜 private로 ?
		this.result = result;
		this.message = message;
		this.data = data;
	}
	
	public JSONResult(boolean judge, String message, Object data) {
		this.result = String.valueOf(judge);
		this.message = message;
		this.data = data;
	}

	public String getResult() {
		return result;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
}