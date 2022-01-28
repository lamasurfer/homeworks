package com.example.jdata_hibernate.controller;

import com.example.jdata_hibernate.model.Person;
import com.example.jdata_hibernate.model.PersonId;
import com.example.jdata_hibernate.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Controller
@RequestMapping("/persons")
@Validated
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping("/save")
    public ResponseEntity<Object> savePerson(@Valid @RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PostMapping("/by-id")
    public ResponseEntity<Object> getPersonById(@Valid @RequestBody PersonId personId) {
        return personService.getPersonById(personId);
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<Object> deletePersonById(@Valid @RequestBody PersonId personId) {
        return personService.deletePersonById(personId);
    }

    @GetMapping("/by-city")
    public ResponseEntity<Object> getPersonsByCity(@RequestParam("city")
                                                   @NotBlank(message = "{city.is.blank}") String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public ResponseEntity<Object> getPersonsAgeLessThan(@RequestParam("age")
                                                        @PositiveOrZero(message = "{age.is.invalid}")
                                                        @Max(value = 120, message = "{age.is.too.high}") int age) {
        return personService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/by-fullname")
    public ResponseEntity<Object> getPersonsByFullName(@RequestParam("name")
                                                       @NotBlank(message = "{name.is.blank}") String name,
                                                       @RequestParam("surname")
                                                       @NotBlank(message = "{surname.is.blank}") String surname) {
        return personService.getPersonByFullName(name, surname);
    }
}
