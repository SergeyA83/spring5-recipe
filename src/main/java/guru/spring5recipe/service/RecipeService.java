package guru.spring5recipe.service;

import guru.spring5recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
