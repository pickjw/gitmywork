package com.board.controller;

import java.util.*;//HashMap,List,Map~

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//메서드 호출 및 페이징 처리
import com.board.dao.BoardDao; //list()
import com.board.domain.BoardCommand;//DTO
import com.board.util.PagingUtil; //페이징처리

@Controller
public class ListController {

	//로그객체를 만들어서 디버깅하자(콘솔에 출력)->메서드 호출->매개변수전달유무
	//형식) Logger 로그객체명=Logger.getLogger(디버깅할 클래스명);
	//private Logger log=Logger.getLogger(ListController.class);
	private Logger log=Logger.getLogger(this.getClass());//현재 클래스 넣어준다
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/board/list.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1") int currentPage,
	    @RequestParam(value="keyField",defaultValue="") String keyField,
	    @RequestParam(value="keyWord",defaultValue="") String keyWord
	   ) {
		/* 
		 * if(request.getParameter("pageNum")==null)
		 *   pageNum="1"
		 * int currentPage=Integer.parseInt(pageNum);
		 *  if(request.getParameter("keyField")==null)
		 *   String keyField="";
		 */
		 if(log.isDebugEnabled()) {//현재 로그객체가 디버깅 상태입니까?
			 System.out.println("process()호출됨!");
			 //debug(정보출력) 에러,치명적인 오류체크->fatal(),error()
			 log.debug("currentPage=>"+currentPage);
			 log.debug("keyField=>"+keyField);
			 log.debug("keyWord=>"+keyWord);
		 }
		 //검색분야,검색어를 담는 객체 Map생성
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("keyField", keyField);//#{keyField} ,${keyField} 검색분야
		 map.put("keyWord", keyWord);
	}
}




