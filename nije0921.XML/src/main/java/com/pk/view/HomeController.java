package com.pk.view;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.pk.view.domain.DataReport;
import com.pk.view.domain.DataStructure;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value="data.xml", method=RequestMethod.GET)
	public String data(Model model) {
		
		DataStructure ds01 = new DataStructure();
		ds01.setName("list");
		ds01.setContent("데이터를 순서대로 저장");
		
		DataStructure ds02 = new DataStructure();
		ds02.setName("set");
		ds02.setContent("데이터를 중복없이 해싱을 이용하여 저장");
		
		DataStructure ds03 = new DataStructure();
		ds03.setName("map");
		ds03.setContent("키와 값을 쌍으로 저장");
		
		List<DataStructure> list = new ArrayList<DataStructure>();
		list.add(ds01);
		list.add(ds02);
		list.add(ds03);
		
		DataReport dr = new DataReport();
		dr.setList(list);
		
		// 위의 데이터를 모델에 저장
		model.addAttribute("dataReport", dr);
		
		return "dataxml";
	}
	
}
