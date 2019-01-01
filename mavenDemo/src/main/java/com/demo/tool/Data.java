package com.demo.tool;

import java.util.HashMap;
import java.util.Map;

public class Data {
	
	/**
	 * 100 代表成功
	 * 200 代表失败
	 */
	private int code;
	
	private String msg;
	
	
	private Map<String, Object> extend = new HashMap<String, Object>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	public static Data success(){
		Data result = new Data();
		result.setCode(100);
		result.setMsg("操作成功");
		return result;
	}
	
	public Data add(String key, Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	public static Data fail(){
		Data result = new Data();
		result.setCode(200);
		result.setMsg("操作失败");
		return result;
	}
}
