package com.example.webapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

import com.example.webapp.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

	private static List<Person> db = new ArrayList<>();
	@Override
	public int insertPerson(UUID id, Person person) {
		db.add(new Person(id, person.getName()));

		return 1;
	}

	
}
