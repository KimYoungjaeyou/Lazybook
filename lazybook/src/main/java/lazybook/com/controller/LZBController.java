package lazybook.com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
