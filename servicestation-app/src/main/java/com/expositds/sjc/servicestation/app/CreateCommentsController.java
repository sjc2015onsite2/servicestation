package com.expositds.sjc.servicestation.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * CreateMarkController
 * Отвечает за отображение страницы с формой оценки (www.site-agregator.com/createmark)
 * Обрабатывает оценку
 * 
 * @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Оставить%20отзыв%20о%20СТО">Пользователь сайта / Оставить комментарий о СТО</a>
 * <p><a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Оставить%20отзыв%20о%20механике">Пользователь сайта / Оставить комментарий о механике</a>
 * 
 * @author Sergey Rybakov, Oleg Ryzhko
 * */


@Controller
public class CreateCommentsController {


	
	@RequestMapping(value = "/createstationcomment", method = { RequestMethod.GET })
	public String getStationCommentForm() {
		return "createStationComment";
	}
	
	@RequestMapping(value = "/createmechaniccomment", method = { RequestMethod.GET })
	public String getMechanicCommentForm() {
		return "createMechanicComment";
	}
	
	/* TODO: Получение данных от формы*/
	
	@RequestMapping(value = "/createstationcomment", method = { RequestMethod.POST })
	public String createstationcomment() {
		return "createStationComment";
	}
	
	@RequestMapping(value = "/createmechaniccomment", method = { RequestMethod.POST })
	public String createmechaniccomment() {
		return "createMechanicComment";
	}
}