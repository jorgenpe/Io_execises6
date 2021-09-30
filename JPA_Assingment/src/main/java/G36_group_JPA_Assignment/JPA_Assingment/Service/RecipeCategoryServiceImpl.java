package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeCategoryDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeIngredientDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeCategoryDTO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeCategory;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeInstruction;
import G36_group_JPA_Assignment.JPA_Assingment.exception.AppResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeCategoryServiceImpl implements RecipeCategoryService{
    private final RecipeDAO recipeDAO;
    private final RecipeIngredientDAO recipeIngredientDAO;
    private final RecipeCategoryDAO recipeCategoryDAO;
    private final DTOConverterService converterService;


    public RecipeCategoryServiceImpl(RecipeDAO recipeDAO, RecipeIngredientDAO recipeIngredientDAO, RecipeCategoryDAO recipeCategoryDAO, DTOConverterService converterService) {
        this.recipeDAO = recipeDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.converterService = converterService;

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategoryDTO create(RecipeCategoryDTO recipeCategoryDTO){

        RecipeCategory recipeCategory = new RecipeCategory();
        recipeCategory.setCategory(recipeCategoryDTO.getCategory());


        RecipeCategory persisted = recipeCategoryDAO.save(recipeCategory);



        return converterService.toFullDTO(persisted,null);
    }


    @Transactional(readOnly = true)
    public RecipeCategory internalFindById(Integer id){
        return recipeCategoryDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find category with id "+ id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeCategoryDTO> findAll(){
        return recipeCategoryDAO.findAll().stream()
                .map(converterService::toSmallDTO)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public RecipeCategoryDTO findById(Integer id){
        RecipeCategory category = internalFindById(id);
        List<Recipe> recipes= recipeDAO.findByRecipeCategoryId(id);


        return converterService.toFullDTO(category, recipes );
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategoryDTO update(Integer id, RecipeCategoryDTO categoryDTO){

        RecipeCategory category = internalFindById(id);

        category.setCategory(categoryDTO.getCategory());


        category = recipeCategoryDAO.save(category);

        return converterService.toFullDTO(category, recipeDAO.findByRecipeCategoryId(id));

    }
}
