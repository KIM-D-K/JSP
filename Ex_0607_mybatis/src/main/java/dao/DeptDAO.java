package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {
	
	SqlSessionFactory factory;

	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	//전체 리스트 조회
	public List<DeptVO> selectList(){
		//factory는 어떤 db로 연결하고 어떤 mapper에 접근해야 하는지까지만 알고 있다.
		//이러한 정보를 가지고 실제로 쿼리문을 통해 요청하는 것은 SqlSession객체가 된다.
		SqlSession sqlSession = factory.openSession();
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		sqlSession.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
