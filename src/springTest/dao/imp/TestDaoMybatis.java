package springTest.dao.imp;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class TestDaoMybatis extends SqlSessionDaoSupport{

	public List<String> list(){
		return this.getSqlSession().selectList("springTest.dao.mapper.listAll");
	}
	

}
