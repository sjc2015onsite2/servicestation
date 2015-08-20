package com.expositds.sjc.servicestation.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
*<b>NotificationsLogController</b>
* Displays mechanic`s notifications to client.
* 
* @author Sergey Rybakov, Oleg Ryzhko
* 
* @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Механик/Журнал%20уведомлений">Mechanic / Notifications</a>
* */


@Controller
public class NotificationsLogController {
	
	@RequestMapping(value = "/mechanic/notificationslog", method = RequestMethod.GET)
	public ModelAndView showNotificationsLog() {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notifications.log");
		
	return mav; 
	}
	
}