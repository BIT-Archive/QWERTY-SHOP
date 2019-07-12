package com.cafe24.gg.DTO;

import com.cafe24.gg.Vo.Product;

public class JSONResult {

	private String result;  //success or fail
	private String message; //if fail, set
	private Object data;    //if success, set

	public static JSONResult success(Object data) {
		return new JSONResult("success", null, data);
	}

	public static JSONResult fail(String message) {
		return new JSONResult("fail", new Object() {}.getClass().getEnclosingMethod().getName()+"실패", null);
	}

	public static JSONResult result(boolean result, Object object){
		
		return result == true ? success(object) : fail(new Object() {}.getClass().getEnclosingMethod().getName()+"실패");
	}
	
	private JSONResult(String result, String message, Object data) {
		this.result = result;
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