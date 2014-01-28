package be.vdab.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.JobtitelDAO;
import be.vdab.entities.Jobtitel;

@Service// met deze annotation maak je een Spring bean van deze class
@Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
class JobtitelServiceImpl implements JobtitelService {
	private final JobtitelDAO jobtitelDAO;
	
	protected JobtitelServiceImpl() {
		this.jobtitelDAO = null;
	}

	public JobtitelServiceImpl(JobtitelDAO jobtitelDAO) {
		this.jobtitelDAO = jobtitelDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Jobtitel jobtitel) {
		jobtitelDAO.create(jobtitel);
	}

	@Override
	public Jobtitel read(long id) {
		return jobtitelDAO.read(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Jobtitel jobtitel) {
		jobtitelDAO.update(jobtitel);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		jobtitelDAO.delete(id);
	}

	@Override
	public Iterable<Jobtitel> findAll() {
		return jobtitelDAO.findAll();
	}

	@Override
	public long findAantalJobtitels() {
		return jobtitelDAO.findAantalJobtitels();
	}

}
