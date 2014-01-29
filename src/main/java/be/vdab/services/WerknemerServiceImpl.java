package be.vdab.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.WerknemerDAO;
import be.vdab.entities.Werknemer;

@Service// met deze annotation maak je een Spring bean van deze class
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class WerknemerServiceImpl implements WerknemerService {
	private final WerknemerDAO werknemerDAO;

	protected WerknemerServiceImpl() {
		this.werknemerDAO = null;
	}

	public WerknemerServiceImpl(WerknemerDAO werknemerDAO) {
		this.werknemerDAO = werknemerDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Werknemer werknemer) {
		werknemerDAO.create(werknemer);
	}

	@Override
	public Werknemer read(long id) {
		return werknemerDAO.read(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Werknemer werknemer) {
		werknemerDAO.update(werknemer);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		werknemerDAO.delete(id);
	}

	@Override
	public Iterable<Werknemer> findAll() {
		return werknemerDAO.findAll();
	}

	@Override
	public long findAantalWerknemers() {
		return werknemerDAO.findAantalWerknemers();
	}

}
