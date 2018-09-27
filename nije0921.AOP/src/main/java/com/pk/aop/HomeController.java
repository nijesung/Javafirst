package com.pk.aop;


import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.aop.util.Command;


@Controller
public class HomeController {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println("home");
		return "home";
	}
	
	@RequestMapping(value="interceptor", method=RequestMethod.GET)
	public String interceptor() {
		
		
		int sum = 0;
		for(int i=1; i<=100000000; i=i+1){
			sum = sum + i;
		}
		
		
		return "";
	}

	@RequestMapping(value="fileupload", method=RequestMethod.GET)
	public String fileupload(Model model) {
		return "fileupload";
	}
	
	@RequestMapping(value="fileupload", method=RequestMethod.POST)
	public String fileupload(Command command, Model model) {
		System.out.println("이름: " + command.getName());
		/*
		if(command.getReport().isEmpty()) {
			System.out.println("첨부 파일이 없다.");
		}else {
			// 업로드 할 디렉토리 이름 설정
			String uploadPath="Users/a503-11/Documents";
			
			// 파일 경로 만들기
			String filepath = uploadPath + UUID.randomUUID() + command.getReport().getOriginalFile
			
		}
		*/
		
		return "fileupload";
	}
	
}
