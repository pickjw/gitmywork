package dr.mini.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
  
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		System.out.println("TestController 호출됨!");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hello");//  /hello.jsp
		mav.addObject("greeting",getGreeting());//"안녕하세요~~"
		return mav;
	}
	//시간에 따라서 인사말을 변경시키고 싶다.
	private String getGreeting() {
		System.out.println("getGreeting()호출됨!");
		int hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		System.out.println("hour=>"+hour);
		if(hour >=6 && hour<=10) {
			return "좋은 아침입니다.";
		}else if(hour>=12 && hour <=16) {
			return "점심 식사는 하셨나요?";
		}else if(hour >=18 && hour <=22) {
			return "좋은 밤 되세요";
		}
		return "안녕하세요~~";
	}
}





