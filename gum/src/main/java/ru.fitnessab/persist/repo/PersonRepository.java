package ru.fitnessab.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fitnessab.persist.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
