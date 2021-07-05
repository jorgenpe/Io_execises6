package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.Ingredient;
import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeCategory;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeDAOTest {


    @Autowired
    private RecipeDAO testObject;

    @Autowired
    private TestEntityManager em;

    public List<Ingredient> ingredientData(){


        return  Arrays.asList(

                new Ingredient(0,"TestI1"),
                new Ingredient(0,"TestI2"),
                new Ingredient(0,"TestI3"),
                new Ingredient(0,"TestI4")
        );
    }



    public List<RecipeIngredient> recipeIngredientsData(){

        return Arrays.asList(
                new RecipeIngredient(null, null,0,null, null),
                new RecipeIngredient(null, null,0,null, null ),
                new RecipeIngredient(null, null,0,null, null ),
                new RecipeIngredient(null, null,0,null, null)
        );
    }




    public List<RecipeCategory> recipeCategoriesData(){

        return Arrays.asList(

                new RecipeCategory(0, "Meat", null),
                new RecipeCategory(0, "Weekend", null),
                new RecipeCategory(0, "Spicy", null),
                new RecipeCategory(0, "Special", null),
                new RecipeCategory(0, "Salty", null),
                new RecipeCategory(0, "Grilled", null),
                new RecipeCategory(0, "Steamed", null)
        );
    }



    public List<Recipe> recipeData(){



        return Arrays.asList(


                new Recipe(0, "name1",null, null, null ),
                new Recipe(0, "name2", null, null, null ),
                new Recipe(0, "name3", null, null, null ),
                new Recipe(0, "name4", null, null, null )
        );
    }

    private List<Recipe> recipesInContext;
    private List<Recipe> recipes;
    private List<RecipeCategory> recipeCategoriesInContext;
    private List<RecipeIngredient> recipeIngredientsInContext;
    private List<Ingredient> ingredientInContext;
    @BeforeEach
    void setUp() {

        ingredientInContext = new ArrayList<>();
        for(Ingredient ingredient: ingredientData()){
            ingredientInContext.add(em.persist(ingredient));
        }

        recipeIngredientsInContext = new ArrayList<>();
        for(RecipeIngredient ingredient: recipeIngredientsData()){
            recipeIngredientsInContext.add(em.persist(ingredient));
        }

        recipeCategoriesInContext = new ArrayList<>();
        for(RecipeCategory category: recipeCategoriesData()){
            recipeCategoriesInContext.add(em.persist(category));
        }

        recipes = recipeData();

        // Set RecipeIngredient list
        recipes.get(0).setRecipeIngredient(Arrays.asList(recipeIngredientsData().get(0),recipeIngredientsData().get(1),recipeIngredientsData().get(2)));
        recipes.get(1).setRecipeIngredient(Arrays.asList(recipeIngredientsData().get(0),recipeIngredientsData().get(1),recipeIngredientsData().get(2),recipeIngredientsData().get(3)));
        recipes.get(2).setRecipeIngredient(Arrays.asList(recipeIngredientsData().get(0),recipeIngredientsData().get(2)));


        // Set ingredient at index 0
        recipes.get(0).getRecipeIngredients().get(0).setIngredient(ingredientData().get(0));
        recipes.get(0).getRecipeIngredients().get(1).setIngredient(ingredientData().get(1));
        recipes.get(0).getRecipeIngredients().get(2).setIngredient(ingredientData().get(2));

        // Set ingredient at index 1
        recipes.get(1).getRecipeIngredients().get(0).setIngredient(ingredientData().get(0));
        recipes.get(1).getRecipeIngredients().get(1).setIngredient(ingredientData().get(1));
        recipes.get(1).getRecipeIngredients().get(2).setIngredient(ingredientData().get(2));
        recipes.get(1).getRecipeIngredients().get(3).setIngredient(ingredientData().get(3));

        // Set ingredient at index 2
        recipes.get(2).getRecipeIngredients().get(0).setIngredient(ingredientData().get(0));
        recipes.get(2).getRecipeIngredients().get(1).setIngredient(ingredientData().get(2));

        //Set recipe in RecipeIngredient index 0
        recipes.get(0).getRecipeIngredients().get(0).setRecipe(recipes.get(0));
        recipes.get(0).getRecipeIngredients().get(1).setRecipe(recipes.get(0));
        recipes.get(0).getRecipeIngredients().get(2).setRecipe(recipes.get(0));

        //Set recipe in RecipeIngredient index 1
        recipes.get(1).getRecipeIngredients().get(0).setRecipe(recipes.get(1));
        recipes.get(1).getRecipeIngredients().get(1).setRecipe(recipes.get(1));
        recipes.get(1).getRecipeIngredients().get(2).setRecipe(recipes.get(1));
        recipes.get(1).getRecipeIngredients().get(3).setRecipe(recipes.get(1));

        //Set recipe in RecipeIngredient index 2
        recipes.get(2).getRecipeIngredients().get(0).setRecipe(recipes.get(2));
        recipes.get(2).getRecipeIngredients().get(1).setRecipe(recipes.get(2));

        // Set Categories
        recipes.get(0).setCategories((Arrays.asList(recipeCategoriesData().get(2), recipeCategoriesData().get(5))));
        recipes.get(1).setCategories(Arrays.asList(recipeCategoriesData().get(0), recipeCategoriesData().get(1),recipeCategoriesData().get(3),recipeCategoriesData().get(6)));
        recipes.get(2).setCategories(Arrays.asList(recipeCategoriesData().get(0), recipeCategoriesData().get(3),recipeCategoriesData().get(6)));



        recipesInContext = testObject.saveAll(recipes);


        em.flush();
    }

    @Test
    void findRecipeByRecipeNameContainsIgnoreCase() {

        List<Recipe> result = testObject.findByRecipeNameContainsIgnoreCase("Name");


        System.out.println("\n Test \n");
        for(Recipe m : result)
        {
            System.out.println(m.toString());
        }
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(4, result.size());

    }

    @Test
    void findRecipesByRecipeIngredientIngredientIngredientNameIgnoreCase() {

        List<Recipe> result = testObject.findRecipesByRecipeIngredientsIngredientIngredientName("TestI2");

        System.out.println("\n Test2 \n");
        for(Recipe m : result)
        {
            System.out.println(m.toString());
        }

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }

    @Test
    void findRecipesByCategoriesCategoryIgnoreCase() {

        List<Recipe> result = testObject.findRecipesByCategoriesCategoryIgnoreCase("Meat");

        System.out.println("\n Test3 \n");
        for(Recipe m : result)
        {
            System.out.println(m.toString());
        }
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }

    @Test
    void findByCategoriesCategoryInIgnoreCase() {

        List<String> temp = Arrays.asList("Meat","Spicy");
        List<Recipe> result = testObject.findByCategoriesCategoryInIgnoreCase(temp);

        System.out.println("\n Test4 \n");
        for(Recipe m : result)
        {
            System.out.println(m.toString());
        }
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }
}