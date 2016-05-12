package springTest.dao.imp;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

@SuppressWarnings("unchecked")
public class TestDaoMybatis extends SqlSessionDaoSupport{

	
	public List<HashMap> list(){
		return this.getSqlSession().selectList("springTest.dao.mapper.listAll");
	}
	
	public int deleteById(String id){
		int i = this.getSqlSession().delete("springTest.dao.mapper.deleteById", id);
		return i;
	}
	
	public int insert(HashMap map){
		return this.getSqlSession().insert("springTest.dao.mapper.insert", map);
	}
	

}
