package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientDAO extends JpaRepository<Ingredient,Integer> {

    Ingredient findByIngredientNameIgnoreCase(String value);
    List<Ingredient> findByIngredientNameContainingIgnoreCase(String value);





}
