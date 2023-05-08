package guru.spring5recipe.repositories;

import guru.spring5recipe.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryTestIT {
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescriptionTeaSpoon() {
        Optional<UnitOfMeasure> optionalUnit = unitOfMeasureRepository.findByDescription("teaspoon");
        assertEquals("teaspoon", optionalUnit.get().getDescription());
    }

    @Test
    void findByDescriptionTableSpoon() {
        Optional<UnitOfMeasure> optionalUnit = unitOfMeasureRepository.findByDescription("tablespoon");
        assertEquals("tablespoon", optionalUnit.get().getDescription());
    }
}