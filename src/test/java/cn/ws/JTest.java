package cn.ws;

import org.junit.Test;

import cn.hutool.json.JSONObject;

public class JTest {

	@Test
	public void j() {
		JSONObject json = new JSONObject(new Object(), false);
		json.put("aaaa", "");
		json.put("bbbb", null);
		json.put("cccc", "cccc");
		System.out.println(json.toString());
	}
}
