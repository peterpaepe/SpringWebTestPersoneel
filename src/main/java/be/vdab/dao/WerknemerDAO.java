package be.vdab.dao;

import be.vdab.entities.Werknemer;

public interface WerknemerDAO {
	void create(Werknemer werknemer);
	Werknemer read(long id);
	void delete(long id);
	void update(Werknemer werknemer);
	Iterable<Werknemer>findAll();
	long findAantalWerknemers();
}
