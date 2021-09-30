package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;

import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeCategory;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RecipeDAO extends JpaRepository<Recipe, String> {
    @Query("SELECT r FROM Recipe.categories r WHERE  r.categoryId = : id")
    List<Recipe> findByRecipeCategoryId(@Param("id") Integer id);

    @Query("SELECT r FROM Recipe.recipeIngredients r WHERE  r.recipeIngredientId = : id")
    Recipe findByRecipeIngredientId(@Param("id") String id);


    List<Recipe> findByRecipeNameContainsIgnoreCase(String value);

    List<Recipe> findRecipesByRecipeIngredientsIngredientIngredientName(String value);

    List<Recipe> findRecipesByCategoriesCategoryIgnoreCase(String value);

    List<Recipe> findByCategoriesCategoryInIgnoreCase(List<String> value);

}
