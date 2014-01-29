package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

public interface JobtitelDAO extends JpaRepository<Jobtitel, Long>{
	//void create(Jobtitel jobtitel);
	//Jobtitel read(long id);
	//void delete(long id);
	//Iterable<Jobtitel> findAll();
	//void update(Werknemer werknemer);
	//long findAantalJobtitels();
}
