package lazybook.com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import lazybook.detail.dao.BoardDAO;


@Service("boardService")
public class BoardServiceImpl implements BoardService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardDAO")
	private BoardDAO BoardDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return BoardDAO.selectBoardList(map);
		
	}

	@Override
	public void insertBoard(Map<String, Object> map) {
		BoardDAO.insertBoard(map);
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
	    Map<String, Object> resultMap = BoardDAO.selectBoardDetail(map);
	    return resultMap;
	}


}