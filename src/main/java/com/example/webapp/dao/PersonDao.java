package com.example.webapp.dao;

import com.example.webapp.model.*;

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

}
