package by.example.simpleportlet.dao.jpa;

import by.example.simpleportlet.dao.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}