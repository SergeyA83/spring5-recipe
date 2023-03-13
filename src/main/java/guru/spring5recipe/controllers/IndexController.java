package guru.spring5recipe.controllers;

import guru.spring5recipe.Service.RecipeService;
import guru.spring5recipe.domain.Category;
import guru.spring5recipe.domain.UnitOfMeasure;
import guru.spring5recipe.repositories.CategoryRepository;
import guru.spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}
