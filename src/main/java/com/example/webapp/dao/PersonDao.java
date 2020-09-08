package com.example.webapp.dao;

import com.example.webapp.model.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Richard Atwell
 *
 */
public interface PersonDao {
	
	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

	 List<Person> selectAll();
	 
	 int deletePersonByID(UUID id);
	 
	 int updatePersonByID(UUID id, Person person);
	 
	 Optional<Person> selectPersonByID(UUID id);

}
