package deerSYS.business.userInfo.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserInfoDao extends SqlSessionDaoSupport{

	public List<HashMap> userInfoList(HashMap searchMap){
		return this.getSqlSession().selectList("deerSYS.business.userInfo.dao.mapper.UserInfoDaoMapper.userInfoList", searchMap);
	}
	
	public HashMap countUserInfoList(HashMap searchMap){
		return this.getSqlSession().selectOne("deerSYS.business.userInfo.dao.mapper.UserInfoDaoMapper.countUserInfoList", searchMap);
	}
}
