package be.vdab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Werknemer;
import be.vdab.valueobjects.Email;

@Repository//met deze annotation maak je een Spring bean van deze class
class WerknemerDAOImpl implements WerknemerDAO {
	private final JdbcTemplate jdbcTemplate;//TODO???
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final WerknemerRowMapper werknemerRowMapper = new WerknemerRowMapper();
	private static final String BEGIN_SQL = "SELECT id, voornaam, familienaam FROM werknemers ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "ORDER BY voornaam, familienaam"; 
			
	@Autowired
	WerknemerDAOImpl(JdbcTemplate jdbcTemplate,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public void create(Werknemer werknemer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Werknemer read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Werknemer werknemer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Werknemer> findAll() {		
		return jdbcTemplate.query(SQL_FIND_ALL, werknemerRowMapper);
	}

	@Override
	public long findAantalWerknemers() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static class WerknemerRowMapper implements RowMapper<Werknemer> {
		@Override
		public Werknemer mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			return new Werknemer( resultSet.getLong("id"),
					resultSet.getString("familienaam"),
					resultSet.getString("voornaam"),
					new Email(resultSet.getString("email")),
					resultSet.getBigDecimal("salaris"));
		}
	}	

}
