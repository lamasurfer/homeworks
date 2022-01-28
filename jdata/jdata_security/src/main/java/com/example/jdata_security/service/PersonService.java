package com.example.jdata_security.service;

import com.example.jdata_security.model.persons.Person;
import com.example.jdata_security.model.persons.PersonId;
import com.example.jdata_security.repository.PersonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity<Object> getBasicPersons() {
        List<String> basics = personRepository.findAll()
                .stream()
                .map(person -> person.getName() + " " + person.getSurname())
                .collect(Collectors.toList());
        return ResponseEntity.ok(basics);
    }

    public ResponseEntity<Object> getAllPersons() {
        final List<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    public ResponseEntity<Object> deletePersonById(PersonId personId) {
        personRepository.deleteById(personId);
        return ResponseEntity.ok(personId);
    }

    public ResponseEntity<Object> savePerson(Person person) {
        final Person addedPerson = personRepository.save(person);
        return ResponseEntity.ok(addedPerson);
    }

    public ResponseEntity<Object> getPersonsByCity(String city) {
        final List<Person> persons = personRepository.findAllByCityOfLiving(city);
        return ResponseEntity.ok(persons);
    }

    public ResponseEntity<Object> getPersonsByAgeLessThan(int age) {
        final List<Person> persons = personRepository.findAllByAgeLessThanOrderByAgeAsc(age, Sort.by("age"));
        return ResponseEntity.ok(persons);
    }

    public ResponseEntity<Object> getPersonByFullName(String name, String surname) {
        final Person person = personRepository.findPersonByNameAndSurname(name, surname).orElseThrow();
        return ResponseEntity.ok(person);
    }
}
