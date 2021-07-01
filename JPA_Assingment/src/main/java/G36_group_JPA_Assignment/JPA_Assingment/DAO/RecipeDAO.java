package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RecipeDAO extends JpaRepository<Recipe, String> {

    List<Recipe> findByRecipeNameContainsIgnoreCase(String value);

    List<Recipe> findRecipesByRecipeIngredientIngredientIngredientNameIgnoreCase(String value);

    List<Recipe> findRecipesByCategoriesCategoryIgnoreCase(String value);

    List<Recipe> findByCategoriesCategoryInIgnoreCase(List<String> value);

}
