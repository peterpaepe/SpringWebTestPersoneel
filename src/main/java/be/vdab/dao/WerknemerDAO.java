package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Werknemer;

public interface WerknemerDAO extends JpaRepository<Werknemer, Long>{
//	void create(Werknemer werknemer);
//	Werknemer read(long id);
//	void delete(long id);
//	void update(Werknemer werknemer);
//	Iterable<Werknemer>findAll();
//	long findAantalWerknemers();
	Werknemer findPresident();
}
