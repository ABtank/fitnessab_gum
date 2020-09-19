package ru.fitnessab.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fitnessab.persist.entity.Weigth;

@Repository
public interface WeigthRepository extends JpaRepository<Weigth, Integer> {
}
