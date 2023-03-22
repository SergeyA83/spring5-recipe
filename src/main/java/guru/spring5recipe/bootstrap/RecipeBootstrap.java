package guru.spring5recipe.bootstrap;

import guru.spring5recipe.domain.Difficulty;
import guru.spring5recipe.domain.Ingredient;
import guru.spring5recipe.domain.Notes;
import guru.spring5recipe.domain.Recipe;
import guru.spring5recipe.repositories.CategoryRepository;
import guru.spring5recipe.repositories.RecipeRepository;
import guru.spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class RecipeBootstrap implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.recipeRepository.saveAll(getRecipes());
    }

    public List<Recipe> getRecipes() throws Exception {
        var recipes = new ArrayList<Recipe>();

        //Singapore Noodles with Shrimp
        var noodlesRecipe = new Recipe();
        noodlesRecipe.setDescription("This dish—a popular Chinese take-out menu item in the U.S.—is a stir-fry made with rice noodles, lots of crisp vegetables, shrimp, strips of ham, and scrambled eggs. Curry powder is a seasoning, but lots of flavor also comes from a simple sauce of soy, rice vinegar, and Asian sesame oil.\n" +
                                     "\n" +
                                    "Whoever invented the dish is brilliant. You get crunch, heat, salt, sweet, smoke, and aromatics all at once. All the ingredients are added to the pan in stages, and from start to finish, it takes just over ten minutes.");
        noodlesRecipe.setPrepTime(10);
        noodlesRecipe.getCategories().add(categoryRepository.findByDescription("Asian").orElseThrow(() -> new Exception("Not found category")));
        noodlesRecipe.setCookTime(30);
        noodlesRecipe.setDifficulty(Difficulty.EASY);
        noodlesRecipe.setDirections("Make the sauce:\n" +
                                    "In a bowl, combine the sesame oil, soy sauce, and rice vinegar.\n" +
                                    "\n" +
                                    "Cook the rice noodles:\n" +
                                    "Bring a large saucepan of water to a boil, add the noodles, and use tongs to turn them so they are submerged. Cook for 2 minutes, or until they are tender but still have some bite (they will cook a little more once you add them to the skillet).\n" +
                                    "\n" +
                                    "Drain, rinse with cold water, and use scissors to snip the noodles several times to break them up into shorter lengths.\n" +
                                    "\n" +
                                    "Singapore Rice Noodles Recipe cook the noodles\n" +
                                    "Scramble the eggs:\n" +
                                    "In a small bowl whisk together the eggs. Heat the skillet or Dutch oven over medium heat. Add 1 tablespoon of the peanut or canola oil. Add the eggs and scramble them for 2 minutes, or until they form large, soft curds. Transfer them from the pan to a plate or bowl.\n" +
                                    "\n" +
                                    "scramble the eggs for making Singapore Style Noodles with Shrimp\n" +
                                    "Cook the vegetables:\n" +
                                    "Add 1 tablespoon of the remaining oil to the pan. When it is hot, add the ginger, garlic, carrots, jalapeño, onion, and salt. Cook, stirring constantly, for 2 minutes or until the vegetables start to soften.\n" +
                                    "\n" +
                                    "cook the vegetables for the Singapore Street Noodles with Shrimp\n" +
                                    "Add the remaining ingredients:\n" +
                                    "Sprinkle the vegetable mixture with the remaining 1 tablespoon peanut or canola oil. When the oil is hot, add the ham, cabbage, scallions, red pepper, and curry powder to the pan. Cook, stirring constantly, for 1 minute.\n" +
                                    "\n" +
                                    "Add the shrimp and cook, stirring, for 3 more minutes or until the shrimp are bright pink and cooked through.\n" +
                                    "\n" +
                                    "combine together the noodles, eggs, and vegetables for Singapore Street Noodles\n" +
                                    "add the shrimp to the pan for making Singapore Style Noodles\n" +
                                    "Add the noodles in batches:\n" +
                                    "Add the eggs, the sauce mixture, and half the noodles to the pan. Toss for 1 minute.\n" +
                                    "\n" +
                                    "Add the remaining noodles and continue tossing for 1 minute more until they are thoroughly combined and the mixture is heated through.");
        noodlesRecipe.addIngredient(new Ingredient("sesame oil", BigDecimal.valueOf(2), this.unitOfMeasureRepository.findByDescription("teaspoon").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        noodlesRecipe.addIngredient(new Ingredient("soy sauce", BigDecimal.valueOf(2), this.unitOfMeasureRepository.findByDescription("tablespoon").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        noodlesRecipe.addIngredient(new Ingredient("seasoned rice vinegar", BigDecimal.valueOf(2), this.unitOfMeasureRepository.findByDescription("tablespoon").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        noodlesRecipe.addIngredient(new Ingredient("Asian rice sticks", BigDecimal.valueOf(6), this.unitOfMeasureRepository.findByDescription("ounce").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        noodlesRecipe.addIngredient(new Ingredient("salt", BigDecimal.valueOf(0.5), this.unitOfMeasureRepository.findByDescription("teaspoon").orElseThrow(()->new Exception("Not found unitOfMeasure"))));

        noodlesRecipe.setServings(4);
        noodlesRecipe.setNotes(new Notes(noodlesRecipe,"For the sweet onion, look for Vidalia, OSO Sweet, or Walla Walla. The super-sweet varieties are more suited to this stir-fry because at the end of cooking, the onion still has a slight crunch."));
        recipes.add(noodlesRecipe);

        //Pollo Guisado
        var pollRecipe = new Recipe();
        pollRecipe.setDescription("Garlicky and aromatic, pollo guisado is a quintessential comfort food. This marinated chicken stew, popular in Latin American countries, is simmered with potatoes and carrots in a tomato-based sauce and served over rice.");
        pollRecipe.setPrepTime(30);
        pollRecipe.setCategories(Set.of(categoryRepository.findByDescription("American").orElseThrow(()->new Exception("Not found category"))));
        pollRecipe.setCookTime(60);
        pollRecipe.setDifficulty(Difficulty.MEDIUM);
        pollRecipe.setDirections("Marinate the chicken: \n" +
                "Begin by mashing together the garlic, salt, oregano, and peppercorns in a mortar and pestle (pilon) or blending it until smooth in a small food processor. Stir in the lime juice to create a thick paste. \n" +
                "\n" +
                "Add this mixture to a large mixing bowl, followed by the pieces of chicken. Rub the marinade into the chicken, ensuring it’s covered completely. Cover the bowl and refrigerate the chicken for 1 to 12 hours. The longer the chicken marinates, the more flavorful the guisado will be.\n" +
                "\n" +
                "Garlic Paste in a Spoon Removed from a Mortar and Pestle Next to a Plate of Chicken Pieces for Pollo Guisado Recipe\n" +
                "Chicken Pieces Marinating in the Garlic-Lemon Paste for Pollo Guisado Recipe\n" +
                "Simmer the chicken:\n" +
                "In a 6-quart Dutch oven or caldero, heat the oil over medium-high heat. Add the brown sugar to the oil in the pot and stir it to dissolve it. After 1 1/2 minutes, the sugar will turn a light brown and begin to bubble up. Quickly add the marinated chicken to the pot, tossing it to coat it in the sugar. Next, add the chicken stock, onions, bay leaves, sazón, and adobo. Bring the liquid in the pot up to a boil, stirring once after the liquid starts to boil. \n" +
                "\n" +
                "Cover the pot and reduce the heat to medium-low. Allow the chicken to simmer for 20 minutes.\n" +
                "Brown Sugar Stirred Using a Wooden Spoon as It Melts in a Caldero for Pollo Guisado Recipe\n" +
                "Chicken Added to Caldero for Pollo Guisado\n" +
                "Seasoning, Onions, and Chicken Broth Added to Caldero for Pollo Guisado Recipe\n" +
                "Add the potatoes, carrots, recaito, tomato sauce, olives, and capers: \n" +
                "Stir to incorporate these ingredients and allow the liquid in the pot to come back up to a simmer. Cover the pot and allow the guisado to simmer until the potatoes and carrots are slightly tender, about 20 minutes.\n" +
                "\n" +
                "Vegetables, Recaito, Olives, Capers, and Can Tomato Sauce Stirred Into Caldero With Other Ingredients for Pollo Guisado Recipe\n" +
                "Reduce the sauce slightly: \n" +
                "Uncover the pot and stir the guisado. Increase the heat to medium-high and allow the liquid to come to a rapid boil. Boil the liquid, stirring the guisado frequently to keep the chicken from sticking to the bottom of the pot, to reduce the sauce slightly, about 10 minutes.");
        pollRecipe.addIngredient(new Ingredient("garlic, peeled", BigDecimal.valueOf(4), this.unitOfMeasureRepository.findByDescription("clove").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        pollRecipe.addIngredient(new Ingredient("kosher salt", BigDecimal.valueOf(1), this.unitOfMeasureRepository.findByDescription("tablespoon").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        pollRecipe.addIngredient(new Ingredient("dried oregano", BigDecimal.valueOf(0.5), this.unitOfMeasureRepository.findByDescription("teaspoon").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        pollRecipe.addIngredient(new Ingredient("black peppercorns", BigDecimal.valueOf(2), this.unitOfMeasureRepository.findByDescription("teaspoon").orElseThrow(()->new Exception("Not found unitOfMeasure"))));
        pollRecipe.setServings(4);
        pollRecipe.setNotes(new Notes(pollRecipe,"To freeze pollo guisado, cool it to room temperature and transfer it to a zip-top freezer bag. I usually double-bag the pollo guisado to prevent major spills. F reeze the guisado laying flat. After it's frozen solid, stand the bag up in your freezer. This takes up less freezer space and also makes thawing faster."));
        recipes.add(pollRecipe);

        return recipes;
    }
}
