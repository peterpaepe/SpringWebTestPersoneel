package be.vdab.services;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	void create(Werknemer werknemer);
	Werknemer read(long id);
	void update(Werknemer werknemer);
	void delete(long id);
	Iterable<Werknemer> findAll();
//	long findAantalWerknemers();
	Werknemer findPresident();
}
