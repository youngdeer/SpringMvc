package deerSYS.system.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

@SuppressWarnings("unchecked")
public class SystemDao extends SqlSessionDaoSupport{
	
	public int insertUserAccount(HashMap map){
		return this.getSqlSession().insert("deerSYS.system.dao.mapper.SystemDaoMapper.insertUserAccount", map);
	}
	
	public List<HashMap> userAccountList(HashMap searchMap){
		return this.getSqlSession().selectList("deerSYS.system.dao.mapper.SystemDaoMapper.userAccountList", searchMap);
	}
	
	public List<HashMap> roleList(){
		return this.getSqlSession().selectList("deerSYS.system.dao.mapper.SystemDaoMapper.roleList");
	}
}
