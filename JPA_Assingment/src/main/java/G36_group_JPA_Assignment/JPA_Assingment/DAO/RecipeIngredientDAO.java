package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeIngredientDAO extends JpaRepository<RecipeIngredient, String> {
    @Query("SELECT rI FROM RecipeIngredient rI WHERE  rI.recipe.recipeId = : id")
    List<RecipeIngredient> findByRecipeId(@Param("id") String id);
}
