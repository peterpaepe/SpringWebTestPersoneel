package be.vdab.services;

import be.vdab.entities.Jobtitel;

public interface JobtitelService {
	void create(Jobtitel jobtitel);
	Jobtitel read(long id);
	void update(Jobtitel jobtitel);
	void delete(long id);
	Iterable<Jobtitel> findAll();
	long findAantalJobtitels();
}
