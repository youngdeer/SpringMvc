package springTest.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JbdcTemplateTest {

	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		String url = "jdbc:mysql://localhost:3306/springtest";
		String username = "root";
		String password = "root";
		
		DriverManagerDataSource datasource = new DriverManagerDataSource(url,username,password);
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		
		String sql = "select * from test";
		
		jdbcTemplate.query(sql, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet resultset) throws SQLException {
				String msg = resultset.getString("msg");
				System.out.println("msg: "+msg);
			}
			
		});
		
		List resultList = jdbcTemplate.query(sql, new RowMapper<Map>(){

			@Override
			public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map map = new HashMap();
				map.put(rs.getInt("id"), rs.getString("msg"));
				return map;
			}
			
		});
		System.out.println(resultList);
		
		//JdbcTemplate preparedStatement
		int count = jdbcTemplate.execute(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				return conn.prepareStatement("select count(*) from test");
			}
			
		}, new PreparedStatementCallback<Integer>(){

			@Override
			public Integer doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
				pstmt.execute();
				ResultSet rs = pstmt.getResultSet();
				rs.next();
				return rs.getInt(1);
			}
			
		});
		System.out.println("table test cloumn num: "+count);
		
		int resultFalg = jdbcTemplate.update("delete from test where id=?", new Object[] {5});
		System.out.println("delete status: "+resultFalg);
		
		resultFalg = jdbcTemplate.update("insert into test values(?,?)", new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setObject(1, 5);
				pstmt.setObject(2, "eee");
			}
			
		});
		System.out.println("updata status: "+resultFalg);
		
		
		
	}
	
}
