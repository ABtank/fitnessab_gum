package ru.fitnessab.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fitnessab.persist.entity.Growth;

@Repository
public interface GrowthRepository extends JpaRepository<Growth, Integer> {

}
