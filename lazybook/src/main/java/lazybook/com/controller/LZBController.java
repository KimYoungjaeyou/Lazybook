package lazybook.com.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lazybook.com.common.CommandMap;
import lazybook.com.service.BoardService;

@Controller
public class LZBController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/lazybook/openBoardList.do")
    public ModelAndView openSampleBoardList(Map<String,Object> commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/board/boardList");
    	
    	List<Map<String,Object>> list = boardService.selectBoardList(commandMap);
    	mv.addObject("list", list);
    	
    	return mv;
    }
	
	@RequestMapping(value="/lazybook/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("");
	     
	    if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
	    return mv;
	}
	
	@RequestMapping(value="/lazybook/openBoardWrite.do")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/board/boardWrite");
	     
	    return mv;
	}
	
	@RequestMapping(value="/lazybook/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/lazybook/openBoardList.do");
	     
	    boardService.insertBoard(commandMap.getMap());
	     
	    return mv;
	}
	
	@RequestMapping(value="/lazybook/openBoardDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/board/boardDetail");
	     
	    Map<String,Object> map = boardService.selectBoardDetail(commandMap.getMap());
	    mv.addObject("map", map);
	     
	    return mv;
	}



}
