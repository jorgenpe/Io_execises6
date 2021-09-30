package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeCategoryDTO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeCategoryService {
    @Transactional(rollbackFor = RuntimeException.class)
    RecipeCategoryDTO create(RecipeCategoryDTO categoryDTO);

    @Transactional(readOnly = true)
    List<RecipeCategoryDTO> findAll();

    RecipeCategoryDTO findById(Integer id);

    RecipeCategoryDTO update(Integer id, RecipeCategoryDTO categoryDTO);
}
