package guru.spring5recipe.service;

import guru.spring5recipe.domain.Recipe;
import guru.spring5recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    RecipeServiceImpl recipeServiceImpl;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        List<Recipe> recipesData = new ArrayList<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        assertEquals(1L, recipeServiceImpl.getRecipes().size());
        verify(recipeRepository, times(1)).findAll();
    }
}