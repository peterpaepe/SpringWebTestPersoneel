package be.vdab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Jobtitel;

@Repository//met deze annotation maak je een Spring bean van deze class
class JobtitelDAOImpl implements JobtitelDAO {
	private final JdbcTemplate jdbcTemplate;//TODO???
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final JobtitelRowMapper jobtitelRowMapper = new JobtitelRowMapper();
	private static final String BEGIN_SQL = "SELECT id, naam FROM jobtitels ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "ORDER BY naam";
	private static final String SQL_READ = BEGIN_SQL + "WHERE id = ?";
			
	@Autowired
	JobtitelDAOImpl(JdbcTemplate jdbcTemplate,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public void create(Jobtitel jobtitel) {
		// TODO Auto-generated method stub
	}

	@Override
	public Jobtitel read(long id) {
		try {
			return jdbcTemplate.queryForObject(SQL_READ, jobtitelRowMapper, id);
		} catch (IncorrectResultSizeDataAccessException ex){
			return null;
		}
	}

	@Override
	public void update(Jobtitel jobtitel) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Jobtitel> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, jobtitelRowMapper);
	}

	@Override
	public long findAantalJobtitels() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static class JobtitelRowMapper implements RowMapper<Jobtitel> {
		@Override
		public Jobtitel mapRow(ResultSet resultSet, int rowNum)	throws SQLException {
			return new Jobtitel(resultSet.getLong("id"), resultSet.getString("naam"));
		}
	}

}