package lazybook.detail.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lazybook.com.dao.AbstractDAO;

@Repository("BoardDAO")
public class BoardDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("lazybook.selectBoardList", map);
	}

}
