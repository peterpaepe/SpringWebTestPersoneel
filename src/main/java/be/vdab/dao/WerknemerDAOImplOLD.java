package be.vdab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Werknemer;
import be.vdab.valueobjects.Email;

@Repository//met deze annotation maak je een Spring bean van deze class
class WerknemerDAOImplOLD {//class WerknemerDAOImplOLD implements WerknemerDAO {
//	private final JdbcTemplate jdbcTemplate;//TODO???
//	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final WerknemerRowMapper werknemerRowMapper = new WerknemerRowMapper();
	private static final String BEGIN_SQL = "SELECT id, voornaam, familienaam FROM werknemers ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "ORDER BY voornaam, familienaam";
	private static final String SQL_READ = BEGIN_SQL + "WHERE id = ?";

	private EntityManager entityManager;

	@PersistenceContext
	void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
//	@Autowired
//	WerknemerDAOImpl(JdbcTemplate jdbcTemplate,
//			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//	}
	
//	@Override
	public void create(Werknemer werknemer) {//TODO verwijderMethodCreate
		entityManager.persist(werknemer);
	}

//	@Override
	public Werknemer read(long id) {
//		try {
//			return jdbcTemplate.queryForObject(SQL_READ, werknemerRowMapper, id);
//		} catch (IncorrectResultSizeDataAccessException ex){
//			return null;
//		}
		return entityManager.find(Werknemer.class, id);
	}

//	@Override
	public void delete(long id) {//TODO verwijderMethod_delete
		entityManager.remove(read(id));
	}

//	@Override
	public void update(Werknemer werknemer) {//TODO verwijderMethod_update
		entityManager.merge(werknemer);
	}

//	@Override
	public Iterable<Werknemer> findAll() {
		return entityManager.createNamedQuery("Werknemer.findAll", Werknemer.class).getResultList();//return jdbcTemplate.query(SQL_FIND_ALL, werknemerRowMapper);
	}

//	@Override
//	public long findAantalWerknemers() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
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