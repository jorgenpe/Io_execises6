package G36_group_JPA_Assignment.DAO;

import G36_group_JPA_Assignment.Model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientDAO extends JpaRepository<RecipeIngredient, String> {
}
