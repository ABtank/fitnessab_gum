package ru.fitnessab.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fitnessab.persist.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User,Integer> {

    List<User> findByLogin(String login);

    List<User> findByLoginLike(String loginPattern);
}
