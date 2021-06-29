package G36_group_JPA_Assignment.DAO;

import G36_group_JPA_Assignment.Model.Recipe;
import G36_group_JPA_Assignment.Model.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe, String> {

    List<Recipe> findByRecipeNameContains(String value);
    List<Recipe> findAllByRecipeIngredientContains(String value);
    List<Recipe> findByCategoriesContains(String value);
    List<Recipe> findRecipesByCategories(List<RecipeCategory> value);

}
