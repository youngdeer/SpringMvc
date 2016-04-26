package deerSYS.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("unchecked")
public class CommonDao extends JdbcTemplate{

	public void save(String tableName,HashMap tableContent){
		StringBuffer sql = new StringBuffer("insert into "+tableName+" ("+tableName+"Id,");
		Iterator iter1 = tableContent.entrySet().iterator();
		while(iter1.hasNext()){
			Entry entry = (Entry) iter1.next();
			String key = (String) entry.getKey();
			if(iter1.hasNext()){
				sql.append(""+key+",");
			}else{
				sql.append(""+key+"");
			}
		}
		sql.append(")");
		sql.append(" values( uuid(),");
		Iterator iter2 = tableContent.entrySet().iterator();
		while(iter2.hasNext()){
			Entry entry = (Entry) iter2.next();
			Object value = (Object) entry.getValue();
			if(iter2.hasNext()){
				sql.append("'"+value+"',");
			}else{
				sql.append("'"+value+"'");
			}
		}
		sql.append(")");
		System.out.println(sql);
		this.update(sql.toString());
	}
}
