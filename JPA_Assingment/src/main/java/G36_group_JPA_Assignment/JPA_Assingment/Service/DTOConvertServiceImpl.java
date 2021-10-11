package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeIngredientDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.*;
import G36_group_JPA_Assignment.JPA_Assingment.Model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class DTOConvertServiceImpl implements DTOConverterService{



    @Override
    public IngredientDTO toDTO(Ingredient ingredient) {

        IngredientDTO ingredientDTO = null;
        if(ingredient != null){
            ingredientDTO = new IngredientDTO();
            ingredientDTO.setId(ingredient.getIngredientId());
            ingredientDTO.setIngredient(ingredient.getIngredientName());

        }
        return ingredientDTO;
    }

    @Override
    public RecipeInstructionDTO toDTO(RecipeInstruction recipeInstruction){

        RecipeInstructionDTO recipeInstructionDTO = null;
        if( recipeInstruction != null) {
            recipeInstructionDTO = new RecipeInstructionDTO();
            recipeInstructionDTO.setId(recipeInstruction.getInstructionId());
            recipeInstructionDTO.setInstructions(recipeInstruction.getInstruction());
        }

        return recipeInstructionDTO;
    }

    @Override
    public RecipeIngredientDTO toSmallDTO(RecipeIngredient recipeIngredient){

        RecipeIngredientDTO recipeIngredientDTO = null;
        if(recipeIngredient != null){
            recipeIngredientDTO = new RecipeIngredientDTO();
            recipeIngredientDTO.setId(recipeIngredient.getRecipeIngredientId());
            recipeIngredientDTO.setIngredient(recipeIngredientDTO.getIngredient());
            recipeIngredientDTO.setAmount(recipeIngredient.getAmount());
            recipeIngredientDTO.setMeasurement(recipeIngredient.getMeasurement());
            recipeIngredientDTO.setRecipe(recipeIngredient.getRecipe());
        }

        return recipeIngredientDTO;
    }

    @Override
    public RecipeDTO toSmallDTO(Recipe recipe){

        RecipeDTO recipeDTO = null;
        if(recipe != null){
            recipeDTO = new RecipeDTO();
            recipeDTO.setRecipeName(recipe.getRecipeName());
            recipeDTO.setInstruction(recipeDTO.getInstruction());
        }
        return recipeDTO;

    }

    @Override
    public RecipeIngredientDTO toFullDTO(RecipeIngredient recipeIngredient,  Recipe recipe){

        RecipeIngredientDTO recipeIngredientDTO = null;
        if(recipeIngredient != null){

            recipeIngredientDTO = toSmallDTO(recipeIngredient);
            recipeIngredientDTO.setRecipe(recipe);
        }
        return recipeIngredientDTO;
    }

    @Override
    public RecipeDTO toHalfFullCategoryDTO(Recipe recipe, List<RecipeCategory> recipeCategories){

        RecipeDTO recipeDTO = null;
        if(recipe != null){

            recipeDTO = toSmallDTO(recipe);
            recipeDTO.setCategories(toSmallCategoryDTOS(recipeCategories));
        }
        return recipeDTO;
    }

    @Override
    public RecipeDTO toHalfFullDTO(Recipe recipe,  List<RecipeIngredient> recipeIngredients){

        RecipeDTO recipeDTO = null;
        if(recipe != null){

            recipeDTO = toSmallDTO(recipe);
            recipeDTO.setRecipeIngredients(toSmallRecipeIngredientDTOS(recipeIngredients));
        }
        return recipeDTO;
    }

    @Override
    public RecipeDTO toFullDTO(Recipe recipe, List<RecipeCategory> recipeCategories, List<RecipeIngredient> recipeIngredients){

        RecipeDTO recipeDTO = null;
        if(recipe != null){

            recipeDTO = toSmallDTO(recipe);
            recipeDTO.setCategories(toSmallCategoryDTOS(recipeCategories));
            recipeDTO.setRecipeIngredients(toSmallRecipeIngredientDTOS(recipeIngredients));
        }
        return recipeDTO;
    }

    @Override
    public RecipeCategoryDTO toSmallDTO(RecipeCategory recipeCategory){

        RecipeCategoryDTO recipeCategoryDTO = null;

        if(recipeCategory != null){

            recipeCategoryDTO = new RecipeCategoryDTO();
            recipeCategoryDTO.setCategory(recipeCategory.getCategory());

        }

        return recipeCategoryDTO;
    }

    @Override
    public RecipeCategoryDTO toFullDTO(RecipeCategory recipeCategory, List<Recipe> recipes){

        RecipeCategoryDTO recipeCategoryDTO = null;

        if(recipeCategory != null){

            recipeCategoryDTO = toSmallDTO(recipeCategory);
            recipeCategoryDTO.setRecipes(toSmallRecipeDTOS(recipes));

        }

        return recipeCategoryDTO;
    }





    public List<RecipeCategoryDTO> toSmallCategoryDTOS(List<RecipeCategory> recipeCategories){
        List<RecipeCategoryDTO> recipeCategoryDTO = new ArrayList<>();
        if (recipeCategories != null){
            for(RecipeCategory recipeCategory : recipeCategories){
                recipeCategoryDTO.add(toSmallDTO(recipeCategory));
            }
        }
        return recipeCategoryDTO;
    }

    public List<RecipeIngredientDTO> toSmallRecipeIngredientDTOS(List<RecipeIngredient> recipeIngredients){
        List<RecipeIngredientDTO> recipeIngredientDTO = new ArrayList();
        if (recipeIngredients != null){
            for(RecipeIngredient recipeIngredient : recipeIngredients){
                recipeIngredientDTO.add(toSmallDTO(recipeIngredient));
            }
        }
        return recipeIngredientDTO;
    }


    public List<RecipeDTO> toSmallRecipeDTOS(List<Recipe> recipes){
        List<RecipeDTO> recipeDTO = new ArrayList<>();
        if (recipes != null){
            for(Recipe recipe : recipes){
                recipeDTO.add(toSmallDTO(recipe));
            }
        }
        return recipeDTO;
    }
}
