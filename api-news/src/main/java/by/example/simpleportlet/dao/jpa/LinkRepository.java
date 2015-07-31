package by.example.simpleportlet.dao.jpa;

import by.example.simpleportlet.dao.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {

    List<Link> findByCategoryId(Long id);

}
