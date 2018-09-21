package com.pk.view;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	// excel.xml 요청을 처리하는 메소드
	@RequestMapping(value="excel.xls", method=RequestMethod.GET)
	public String excel(Model model) {
		
		// 1.7 버전 이상에서만 아래 형태로 사용 가능
		// 그 이하 버전에서는 반드시 <> 안에 자료형을 기입해야 한다.
		List<String> list = new ArrayList<>();
	    list.add("길앞잡이");
	    list.add("그리마");
	    list.add("장수풍뎅이");
	    list.add("지네");
	    list.add("투구게");
	    list.add("톡토기");
	    list.add("벼룩");
	    
	    model.addAttribute("list", list);
	
	    
		return "bug";
	}
		
		// data.pdf 요청을 처리하는 메소드
		@RequestMapping(value="data.pdf", method=RequestMethod.GET)
		public String pdf(Model model) {
			List<String> list = new ArrayList<>();
			list.add("만티고라대길앞잡이");
		    list.add("오키나와왕돈벌");
		    list.add("코카서스장수풍뎅이");
		    list.add("청지네");
		    list.add("왕투구게");
		    list.add("왕톡토기");
		    list.add("왕벼룩");
		    
		    // bug02 라는 이름으로 list 를 저장
		    model.addAttribute("bug02", list);
			
		    // 출력하는 뷰 이름을 bug02 로 설정
			return "bug02";
			
		}		
			
		@RequestMapping(value="jsonview.json", method=RequestMethod.GET)
		public String jsonview(Model model)	{
			
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String>
			map = new HashMap<String, String>();
			map.put("name", "존 존스");
			map.put("reach", "216");
			list.add(map);
			
			map = new HashMap<String, String>();
			map.put("name", "엘렉센더 구스타프손");
			map.put("reach", "206");
			list.add(map);
			
			map = new HashMap<String, String>();
			map.put("name", "오빈스 생 프룩스");
			map.put("reach", "203");
			list.add(map);
			
			model.addAttribute("list", list);
			
			return "jsonview";
		}
			
			
			
}
	
	

