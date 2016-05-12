package deerSYS.business.simpleApply.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

@SuppressWarnings("unchecked")
public class SimpleApplyDao extends SqlSessionDaoSupport{

	
	public List<HashMap> simpleApplyList(HashMap searchMap){
		return this.getSqlSession().selectList("deerSYS.business.simpleApply.dao.mapper.SimpleApplyDaoMapper.simpleApplyList", searchMap);
	}
}
