package lazybook.com.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

	void insertBoard(Map<String, Object> map);

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;
}
