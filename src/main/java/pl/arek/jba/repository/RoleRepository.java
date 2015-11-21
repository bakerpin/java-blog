package pl.arek.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.arek.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
