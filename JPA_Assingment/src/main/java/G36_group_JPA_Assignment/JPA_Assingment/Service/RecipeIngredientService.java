package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeDTO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeIngredientDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeIngredientService {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeIngredientDTO create(RecipeIngredientDTO recipeIngredientDTO);

    @Transactional(readOnly = true)
    List<RecipeIngredientDTO> findAll();

    RecipeIngredientDTO findById(String id);

    RecipeIngredientDTO update(String id, RecipeIngredientDTO recipeIngredientDTO);
}
