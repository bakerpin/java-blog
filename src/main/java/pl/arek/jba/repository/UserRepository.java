package pl.arek.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.arek.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
