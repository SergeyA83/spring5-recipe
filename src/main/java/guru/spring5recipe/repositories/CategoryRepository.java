package guru.spring5recipe.repositories;

import guru.spring5recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
     Optional<Category> findByDescription(String description);
}
