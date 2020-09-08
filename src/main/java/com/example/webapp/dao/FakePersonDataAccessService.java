package com.example.webapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	@Override
	public List<Person> selectAll() {
		return db;
	}
	
	@Override
	public Optional<Person> selectPersonByID(UUID id) {
		return db.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
	
	@Override
	public int deletePersonByID(UUID id) {
		Optional<Person> personMaybe = selectPersonByID(id);
		if(!personMaybe.isPresent()) {
			return 0;
		}
		db.remove(personMaybe.get());
		return 1;
	}
	
	@Override
	public int updatePersonByID(UUID id, Person update) {
		return selectPersonByID(id)
				.map(person -> {
					int indexOfPerson = db.indexOf(person);
					if( indexOfPerson >= 0) {
						db.set(indexOfPerson, new Person(id, update.getName()));
						return 1;
						}
					return 0;
				})
				.orElse(0);
	}
}
