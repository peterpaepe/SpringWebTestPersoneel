package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.JobtitelDAO;
import be.vdab.entities.Jobtitel;
import be.vdab.exceptions.JobtitelHeeftNogWerknemersException;

@Service// met deze annotation maak je een Spring bean van deze class
@Transactional(readOnly = true)//@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class JobtitelServiceImpl implements JobtitelService {
	private final JobtitelDAO jobtitelDAO;
	
	protected JobtitelServiceImpl() {
		this.jobtitelDAO = null;
	}

	@Autowired
	public JobtitelServiceImpl(JobtitelDAO jobtitelDAO) {
		this.jobtitelDAO = jobtitelDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Jobtitel jobtitel) {//TODO verwijder deze method
		jobtitel.setId(jobtitelDAO.save(jobtitel).getId());//jobtitelDAO.create(jobtitel);
	}

	@Override
	public Jobtitel read(long id) {
		return jobtitelDAO.findOne(id);//return jobtitelDAO.read(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Jobtitel jobtitel) {//TODO verwijder deze method
		jobtitelDAO.save(jobtitel);//jobtitelDAO.update(jobtitel);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {//TODO verwijder deze method
		Jobtitel jobtitel = jobtitelDAO.findOne(id);//Jobtitel jobtitel = jobtitelDAO.read(id);
		if( !jobtitel.getWerknemers().isEmpty()){
			throw new JobtitelHeeftNogWerknemersException();
		}
		jobtitelDAO.delete(id);
	}

	@Override
	public Iterable<Jobtitel> findAll() {
		return jobtitelDAO.findAll(new Sort("naam"));
	}

//	@Override
//	public long findAantalJobtitels() {
//		return jobtitelDAO.findAantalJobtitels();
//	}

}
