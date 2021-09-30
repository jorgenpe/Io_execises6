package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeCategory;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeCategoryDAO extends JpaRepository<RecipeCategory, Integer> {
    @Query("SELECT rC FROM RecipeCategory.recipes rC WHERE  rC.recipeId = : id")
    List<RecipeCategory> findByRecipeId(@Param("id") String id);
}
