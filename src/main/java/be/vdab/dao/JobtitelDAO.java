package be.vdab.dao;

import be.vdab.entities.Jobtitel;

public interface JobtitelDAO {
	void create(Jobtitel jobtitel);
	Jobtitel read(long id);
	void update(Jobtitel jobtitel);
	void delete(long id);
	Iterable<Jobtitel> findAll();
	long findAantalJobtitels();
}
