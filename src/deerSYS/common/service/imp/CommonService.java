package deerSYS.common.service.imp;

import java.util.HashMap;

import deerSYS.common.CommonDao;
import deerSYS.common.service.ICommonService;

@SuppressWarnings("unchecked")
public class CommonService implements ICommonService{
	
	private CommonDao commonDao;
	
	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public void save(String tableName,HashMap tableContent){
		commonDao.save(tableName, tableContent);
//		测试事务
//		int j = 1/0;
	}
}
