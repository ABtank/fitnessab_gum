package ru.fitnessab.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fitnessab.persist.entity.Waist;

@Repository
public interface WaistRepository extends JpaRepository<Waist, Integer> {
}
