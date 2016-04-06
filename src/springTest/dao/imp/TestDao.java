package springTest.dao.imp;

import org.springframework.jdbc.core.JdbcTemplate;

import springTest.dao.ITestDao;

public class TestDao extends JdbcTemplate implements ITestDao{

	@Override
	public int count() {
		return this.queryForInt("select count(1) from test");
	}

	@Override
	public void save() {
		this.update("insert into test values(4,'ddd')");
	}

}
