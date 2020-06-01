
package com.wiz.demo.sc.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

	public static Object ok(String status, String message) {
		Map<String, String> obj = new HashMap<String, String>();
		obj.put("status", status);
		obj.put("message", message);
		return obj;
	}

	public static Object ok(String status, String message, Object data) {
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("status", status);
		obj.put("message", message);
		obj.put("data", data);
		return obj;
	}

	public static Object fail(String status, String message) {
		Map<String, String> obj = new HashMap<String, String>();
		obj.put("status", status);
		obj.put("message", message);
		return obj;
	}
}