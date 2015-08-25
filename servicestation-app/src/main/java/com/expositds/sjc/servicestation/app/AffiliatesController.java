package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.service.Accountant;

/**
 * <b>CustomerOrdersController</b>
 * 
 * @author Sergey Rybakov
 * */


@Controller
@RequestMapping("/accountant")
public class AffiliatesController {
	
	@Autowired 
	private Accountant accountantService;
	
		@RequestMapping(value = "/affiliates", method = RequestMethod.GET)
		public ModelAndView myorders() {
			
			
			
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("affiliates");
			return mav;
		}
}