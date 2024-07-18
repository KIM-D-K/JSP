package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVO;

public class SawonDAO {

	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static SawonDAO single = null;

	public static SawonDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new SawonDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public SawonDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//전체조회
	public List<SawonVO> selectList(){
		 SqlSession sqlSession = factory.openSession();
		 List<SawonVO> list = sqlSession.selectList("sawon.sawon_list");
		 sqlSession.close();
		 return list;
	}
	
	//부서번호별 사원 조회
	public List<SawonVO> selectList(int deptno){
		SqlSession sqlSession = factory.openSession();
		 List<SawonVO> list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);
		 sqlSession.close();
		 return list;
	}
	
	
	
	
	
	
}
