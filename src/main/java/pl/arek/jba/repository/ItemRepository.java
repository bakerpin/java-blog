package pl.arek.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.arek.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
