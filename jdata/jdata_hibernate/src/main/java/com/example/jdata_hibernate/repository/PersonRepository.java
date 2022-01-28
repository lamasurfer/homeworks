package com.example.jdata_hibernate.repository;

import com.example.jdata_hibernate.model.Person;
import com.example.jdata_hibernate.model.PersonId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    @Query("SELECT person FROM Person person WHERE person.cityOfLiving = :city")
    List<Person> findAllByCityOfLiving(@Param("city") String city);

    @Query("SELECT person FROM Person person WHERE person.age <= :age")
    List<Person> findAllByAgeLessThanOrderByAgeAsc(@Param("age") int age, Sort sort);

    @Query("SELECT person FROM Person person WHERE person.name = :name AND person.surname = :surname")
    Optional<Person> findPersonByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
