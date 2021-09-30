package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DAO.IngredientDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeCategoryDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeIngredientDAO;
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
public class RecipeServiceImpl implements RecipeService{

    private final RecipeDAO recipeDAO;
    private final RecipeIngredientDAO recipeIngredientDAO;
    private final RecipeCategoryDAO recipeCategoryDAO;
    private final DTOConverterService converterService;


    public RecipeServiceImpl(RecipeDAO recipeDAO, RecipeIngredientDAO recipeIngredientDAO, RecipeCategoryDAO recipeCategoryDAO, DTOConverterService converterService) {
        this.recipeDAO = recipeDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.converterService = converterService;

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeDTO create(RecipeDTO recipeDTO){

        Recipe recipe = new Recipe(

                recipeDTO.getRecipeName()
                );

        if(recipeDTO.getInstruction() != null){
            RecipeInstruction recipeInstruction = new RecipeInstruction();
            recipeInstruction.setInstruction(recipeDTO.getInstruction().getInstruction());
            recipe.setInstruction(recipeInstruction);
        }

        Recipe persisted = recipeDAO.save(recipe);



        return converterService.toFullDTO(persisted,null,null);
    }


    @Transactional(readOnly = true)
    public Recipe internalFindById(String id){
        return recipeDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find recipe with id "+ id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeDTO> findAll(){
        return recipeDAO.findAll().stream()
                .map(converterService::toSmallDTO)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public RecipeDTO findById(String id){
        Recipe recipe = internalFindById(id);
        List<RecipeIngredient> ingredients = recipeIngredientDAO.findByRecipeId(id);
        List<RecipeCategory> category = recipeCategoryDAO.findByRecipeId(id);

        return converterService.toFullDTO(recipe, category,ingredients );
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeDTO update(String id, RecipeDTO recipeDTO){

        Recipe recipe = internalFindById(id);

        recipe.setRecipeName(recipeDTO.getRecipeName());
        recipe.setInstruction(recipeDTO.getInstruction());

        recipe = recipeDAO.save(recipe);

        return converterService.toFullDTO(recipe, recipeCategoryDAO.findByRecipeId(id), recipeIngredientDAO.findByRecipeId(id));

    }


}
