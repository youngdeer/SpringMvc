package springTest.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JbdcTemplateTest {

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
	}
	
}
