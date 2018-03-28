package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//메인 페이지 시작-> /index.do->index->definition의 name값->화면에 불러오기
@Controller
public class Menu1Controller {

	@RequestMapping("/menu1.do")
	public String process() {
		return "menu1";//<definition name="menu1" value="~
	}
}
