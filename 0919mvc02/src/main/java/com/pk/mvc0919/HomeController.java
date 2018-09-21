package com.pk.mvc0919;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pk.mvc0919.vo.Article;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	// private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 시작 요청이 왔을 때 처리하는 메소드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// logger.info("Welcome home! The client locale is {}.", locale);
		
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		*/
		
		return "home";
	}
	
	// input 요청이 왔을 때 처리
	@RequestMapping(value="input", method=RequestMethod.GET)
	public String input(Model model) {
		// 여기서 리턴한 뷰 이름을 가지고 servlet-context.xml
		// 파일의 ViewResolver 와 결합해서 실제 출력할 파일이 결정
		return "article";
	}
	
	/*
	// java web 프로그래밍에서 제공하는 request 객체를 이용하여 파라미터 읽기
	@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(HttpServletRequest request, Model model) {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("제목: " + subject);
		System.out.println("내용: " + content);
		return "";
	}
	*/
	
	/*
	// @RequestParam 을 이용한 파라미터 처리
	@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(
		@RequestParam("subject") String subject,
		@RequestParam("content") String content,
		Model model) {
		System.out.println("제목: " + subject);
		System.out.println("제목: " + content);
		
		return "";
	}
	*/
	
	// Command 객체를 이용한 파라미터 처리
	@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(Article article,
			Model model, HttpSession session, RedirectAttributes attr) {
		// System.out.println(article);
		
		// request 에 저장된다.
		model.addAttribute("client", "web browse");
		session.setAttribute("server", "Java - Spring");
		
		// 세션에 저장되는데 한 번 사용하면 삭제된다.
		// 리다이렉트 할 때만 전달된다.
		attr.addFlashAttribute("db", "NOSql");
		
		// result 로 포워딩
		// return "result";
		// result 로 리다이렉트 - model 의 데이터는 전송되지 않는다.
		return "redirect:result";
	}
		
		// result 요청이 왔을 때 처리하는 메소드
		@RequestMapping(value="result", method=RequestMethod.GET)
		public String result(Model model) {
			return "result";
		}
		
		
		
	}
			
	

