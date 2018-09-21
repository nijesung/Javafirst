package com.pk.ufc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.domain.ufc;
import com.pk.ufc.service.UfcService;


@Controller
public class HomeController {
	
	@Autowired
	private UfcService ufcService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<ufc> list = ufcService.listufc();
		model.addAttribute("list", list);
		return "home";
	}
	
}

