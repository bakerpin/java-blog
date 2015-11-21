package pl.arek.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.arek.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
