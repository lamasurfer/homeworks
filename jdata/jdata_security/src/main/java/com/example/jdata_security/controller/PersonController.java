package com.example.jdata_security.controller;

import com.example.jdata_security.model.persons.Person;
import com.example.jdata_security.model.persons.PersonId;
import com.example.jdata_security.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.security.Principal;

@RestController
@RequestMapping("/persons")
@Validated
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/basic")
    public ResponseEntity<Object> getBasicPersons(Principal principal) {
        System.out.println(principal);
        return personService.getBasicPersons();
    }

    @GetMapping("/all")
    @Secured("ROLE_READ")
    public ResponseEntity<Object> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/by-city")
    @Secured("ROLE_READ")
    public ResponseEntity<Object> getPersonsByCity(@RequestParam("city")
                                                   @NotBlank(message = "{city.is.blank}") String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    @Secured("ROLE_READ")
    public ResponseEntity<Object> getPersonsAgeLessThan(@RequestParam("age")
                                                        @PositiveOrZero(message = "{age.is.invalid}")
                                                        @Max(value = 120, message = "{age.is.too.high}") int age) {
        return personService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/by-fullname")
    @Secured("ROLE_READ")
    public ResponseEntity<Object> getPersonsByFullName(@RequestParam("name")
                                                       @NotBlank(message = "{name.is.blank}") String name,
                                                       @RequestParam("surname")
                                                       @NotBlank(message = "{surname.is.blank}") String surname) {
        return personService.getPersonByFullName(name, surname);
    }

    @PostMapping("/save")
    @RolesAllowed("ROLE_WRITE")
    public ResponseEntity<Object> savePerson(@Valid @RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("/delete-by-id")
    @PreAuthorize("hasRole('ROLE_DELETE')")
    public ResponseEntity<Object> deletePersonById(@Valid @RequestBody PersonId personId) {
        return personService.deletePersonById(personId);
    }
}
