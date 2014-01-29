package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.WerknemerDAO;
import be.vdab.entities.Werknemer;

@Service// met deze annotation maak je een Spring bean van deze class
@Transactional(readOnly = true)//@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)//De JPA standaard ondersteunt het instellen van transaction isolation levels niet.
class WerknemerServiceImpl implements WerknemerService {
	private final WerknemerDAO werknemerDAO;

	protected WerknemerServiceImpl() {
		this.werknemerDAO = null;
	}

	@Autowired
	public WerknemerServiceImpl(WerknemerDAO werknemerDAO) {
		this.werknemerDAO = werknemerDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Werknemer werknemer) {
		werknemer.setId(werknemerDAO.save(werknemer).getId());//werknemerDAO.create(werknemer);
	}

	@Override
	public Werknemer read(long id) {
		return werknemerDAO.findOne(id);//return werknemerDAO.read(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Werknemer werknemer) {
		werknemerDAO.save(werknemer);//werknemerDAO.update(werknemer);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		werknemerDAO.delete(id);
	}

	@Override
	public Iterable<Werknemer> findAll() {
		return werknemerDAO.findAll(new Sort("familienaam", "voornaam"));//Er is een constructor van Sort die een variabel aantal eigenschappen (hier van de Werknemer class) aanvaardt en sorteert op die eigenschappen
	}	
	
	
//	@Override
//	public long findAantalWerknemers() {
//		return werknemerDAO.findAantalWerknemers();
//	}

}
