package be.vdab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Jobtitel;

@Repository//met deze annotation maak je een Spring bean van deze class
class JobtitelDAOImplOLD {//class JobtitelDAOImplOLD implements JobtitelDAO {
//	private final JdbcTemplate jdbcTemplate;//TODO???
//	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final JobtitelRowMapper jobtitelRowMapper = new JobtitelRowMapper();
	private static final String BEGIN_SQL = "SELECT id, naam FROM jobtitels ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "ORDER BY naam";
	private static final String SQL_READ = BEGIN_SQL + "WHERE id = ?";

	private EntityManager entityManager;

	@PersistenceContext//(1)@PersistenceContext werkt zoals @Autowired. Je moet @PersistenceContext gebruiken in plaats van @Autowired als je een EntityManager injecteert.
	void setEntityManager(EntityManager entityManager) {//(2)Je kan een EntityManager enkel injecteren met setter injection, niet met constructor injection. Wanneer je een transactie start (in de service layer), maakt Spring een EntityManager aan als ThreadLocal variabele en start daarop de transactie. Spring injecteert deze EntityManager variabele in de setter.
		this.entityManager = entityManager;
	}
	
//	@Autowired
//	JobtitelDAOImpl(JdbcTemplate jdbcTemplate,
//			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//	}
	
	//@Override
	public void create(Jobtitel jobtitel) {//TODO verwijderMethodcreate
		entityManager.persist(jobtitel);
	}

	//@Override
	public Jobtitel read(long id) {
		return entityManager.find(Jobtitel.class, id);
//		try {
//			return jdbcTemplate.queryForObject(SQL_READ, jobtitelRowMapper, id);
//		} catch (IncorrectResultSizeDataAccessException ex) {
//			return null;
//		}
	}

	//@Override
	public void update(Jobtitel jobtitel) {//TODO verwijderMethodUpdate
		entityManager.merge(jobtitel);//(3)Je hebt het Jobtitel object in de parameter jobtitel niet gelezen met JPA, maar aangemaakt als een nieuw object in het interne geheugen. Als je dit object meegeeft met de method merge, stuurt JPA een SQL update statement naar de database om het record dat bij de jobtitel hoort te wijzigen.
	}

	//@Override
	public void delete(long id) {//TODO verwijderMethodDelete
		entityManager.remove(read(id));
	}

	//@Override
	public Iterable<Jobtitel> findAll() {
//		return jdbcTemplate.query(SQL_FIND_ALL, jobtitelRowMapper);
		return entityManager.createNamedQuery("Jobtitel.findAll", Jobtitel.class).getResultList();
	}

//	@Override
//	public long findAantalJobtitels() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	private static class JobtitelRowMapper implements RowMapper<Jobtitel> {
		@Override
		public Jobtitel mapRow(ResultSet resultSet, int rowNum)	throws SQLException {
			return new Jobtitel(resultSet.getLong("id"), resultSet.getString("naam"));
		}
	}

}