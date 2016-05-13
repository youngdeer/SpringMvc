package deerSYS.common.service;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public interface ICommonService {

	public void save(String tableName,HashMap tableContent);
	
	public void update(String tableName,HashMap tableContent);
}
