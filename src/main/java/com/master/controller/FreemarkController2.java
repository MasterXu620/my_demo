package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.master.FreemarkerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class FreemarkController {
	
	@ResponseBody
	@RequestMapping("/")
	public String index(Model model) {
		Map<Object, Object> map = new LinkedHashMap<>();
		for (int i = 0; i < 5; i++) {
			map.put("key" + i, "value" + i);
		}
		model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
		model.addAttribute("map", map);
		model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
		model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
		model.addAttribute("num", 123.012);
		model.addAttribute("null", null);
		model.addAttribute("dateObj", new Date());
		model.addAttribute("bol", true);
		return "index";
	}

	@ResponseBody
	@RequestMapping("/createHtml")
	public String createHtml(Model model) {
		Map<Object, Object> map = new LinkedHashMap<>();
		for (int i = 0; i < 5; i++) {
			map.put("key" + i, "value" + i);
		}
		model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
		model.addAttribute("map", map);
		model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
		model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
		model.addAttribute("num", 123.012);
		model.addAttribute("null", null);
		model.addAttribute("dateObj", new Date());
		model.addAttribute("bol", true);
		return FreemarkerUtil.parseTpl("index", model.asMap());
	}
	
	@ResponseBody
	@RequestMapping("/gameList")
	public String gameList(Model model) {
		JSONArray ja = new JSONArray();
		List<Map<String,Object>> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			Map<String, Object> jb = new HashMap<>();
			jb.put("name","传奇00"+i);
			jb.put("qufu", i);
			jb.put("date", new Date());
			int type = new Random().nextInt(3)+1;
			jb.put("type", type==1?"全新版本":type==2?"品牌耐玩":"福利送送送");
			jb.put("qq", "53556890");
			jb.put("random", assemble());
			list.add(jb);
		}
		model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
		model.addAttribute("games", list);
		return FreemarkerUtil.parseTpl("game_list", model.asMap());
	}
	
	public static String assemble() {
		String result = "";
		String[] strs = {"A","B","C","D","E","F","E","H","G","I","K","L","R","Z"};
		for(int i=0;i<1;i++) {
			Random r = new Random();
			int index = r.nextInt(strs.length);
			result += strs[index];
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(assemble());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
