package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeCategoryDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeIngredientDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeDTO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeIngredientDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Model.*;
import G36_group_JPA_Assignment.JPA_Assingment.exception.AppResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService{


    private final RecipeDAO recipeDAO;
    private final RecipeIngredientDAO recipeIngredientDAO;
    private final RecipeCategoryDAO recipeCategoryDAO;
    private final DTOConverterService converterService;


    public RecipeIngredientServiceImpl(RecipeDAO recipeDAO, RecipeIngredientDAO recipeIngredientDAO, RecipeCategoryDAO recipeCategoryDAO, DTOConverterService converterService) {
        this.recipeDAO = recipeDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.converterService = converterService;

    }



    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredientDTO create(RecipeIngredientDTO recipeIngredientDTO){

        RecipeIngredient recipeIngredient = new RecipeIngredient(
                );

            recipeIngredient.setAmount(recipeIngredientDTO.getAmount());
            recipeIngredient.setMeasurement(recipeIngredientDTO.getMeasurement());

        if(recipeIngredientDTO.getIngredient() != null){
            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName(recipeIngredientDTO.getIngredient().getIngredient());
            recipeIngredient.setIngredient(ingredient);
        }

        RecipeIngredient persisted = recipeIngredientDAO.save(recipeIngredient);



        return converterService.toFullDTO(persisted,null);
    }


    @Transactional(readOnly = true)
    public RecipeIngredient internalFindById(String id){
        return recipeIngredientDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find ingredient with id "+ id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeIngredientDTO> findAll(){
        return recipeIngredientDAO.findAll().stream()
                .map(converterService::toSmallDTO)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public RecipeIngredientDTO findById(String id){
        RecipeIngredient recipeIngredient = internalFindById(id);
        Recipe recipe = recipeDAO.findByRecipeIngredientId(id);


        return converterService.toFullDTO(recipeIngredient, recipe );
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredientDTO update(String id, RecipeIngredientDTO recipeIngredientDTO){

        RecipeIngredient recipeIngredient = internalFindById(id);
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(recipeIngredientDTO.getIngredient().getIngredient());
        ingredient.setIngredientId(recipeIngredientDTO.getIngredient().getId());
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setMeasurement(recipeIngredientDTO.getMeasurement());
        recipeIngredient.setAmount(recipeIngredientDTO.getAmount());



        recipeIngredient = recipeIngredientDAO.save(recipeIngredient);

        return converterService.toFullDTO(recipeIngredient, recipeDAO.findByRecipeIngredientId(id));

    }
}
