package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeService {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeDTO create(RecipeDTO recipeDTO);

    @Transactional(readOnly = true)
    List<RecipeDTO> findAll();

    RecipeDTO findById(String id);

    RecipeDTO update(String id, RecipeDTO recipeDTO);

}
