package guru.spring5recipe.Service;

import guru.spring5recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
