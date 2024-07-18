package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.BoardVO;

public class BoardDAO {

	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static BoardDAO single = null;

	public static BoardDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new BoardDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public BoardDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	public List<BoardVO> selectList(HashMap<String, Integer> map){
		SqlSession sqlSession = factory.openSession();
		List<BoardVO> list = sqlSession.selectList("board.board_list", map);
		sqlSession.close();
		return list;
	}
	
	public int insert(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("board.board_insert",vo);
		
		sqlSession.close();
		return res;
	}
	
	public BoardVO selectOne(int idx) {
		SqlSession sqlSession = factory.openSession();
		BoardVO vo = sqlSession.selectOne("board.board_one",idx);
		sqlSession.close();
		return vo;
	}
	
	public int update_readhit(int idx) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.board_readhit",idx);
		sqlSession.close();
		return res;
	}
	
	public int update_step(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.board_update_step",vo);
		sqlSession.close();
		return res;
	}
	
	public int reply(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("board.board_reply",vo);
		sqlSession.close();
		return res;
	}
	
	public int del_update(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.del_update",vo);
		sqlSession.close();
		return res;
	}
	
	public int getRowTotal() {
		SqlSession sqlSession = factory.openSession();
		int count = sqlSession.selectOne("board.board_count");
		sqlSession.close();
		return count;
	}
	
}











