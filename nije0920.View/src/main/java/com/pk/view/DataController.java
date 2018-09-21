package com.pk.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pk.view.service.MemberService;

//CSV 를 만들어 리턴하는 메소드
@RestController
public class DataController {
	@Autowired
	public MemberService memberService;
	
	@RequestMapping(value="idcheck", method=RequestMethod.GET)
	public Map<String, String> idcheck(
		@RequestParam("id") String id){
			String result = memberService.idcheck(id);
			Map<String, String> map = new HashMap<String, String>();
		// 아이디가 존재하지 않을 때
		if(result == null) {
			map.put("result", "true");
		}else {
			map.put("result", "false");
		}
		return map;
		
		}


// CSV 를 만들어 리턴하는 메소드
	/*
@RestController
public class DataController {
	@RequestMapping(value="data.csv", method=RequestMethod.GET)
	public String dataCsv() {
		return "csv, xml, json";
	}
	*/
	
	
	
	
	// JSON 을 만들어서 리턴하는 메소드
	@RequestMapping(value="data.json", method=RequestMethod.GET)
	public List<Map<String, Object>> datajson(){
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object>
		
		map = new HashMap<>();
		map.put("name", "정찬성");
		map.put("reach", "185");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "최두호");
		map.put("reach", "177");
		list.add(map);
		
		return list;
	}
	
	
	
	
	
}
