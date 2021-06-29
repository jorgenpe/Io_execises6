package G36_group_JPA_Assignment.DAO;

import G36_group_JPA_Assignment.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<Ingredient,Integer> {

    Ingredient findByIngredientNameIgnoreCase(String value);
    Ingredient findByIngredientNameIsLikeIgnoreCase(String value);


}
