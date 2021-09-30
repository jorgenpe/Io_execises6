package G36_group_JPA_Assignment.JPA_Assingment.Service;

import G36_group_JPA_Assignment.JPA_Assingment.DAO.RecipeIngredientDAO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.*;
import G36_group_JPA_Assignment.JPA_Assingment.Model.*;

import java.util.List;

public interface DTOConverterService {

    IngredientDTO toDTO(Ingredient ingredient);
    RecipeInstructionDTO toDTO(RecipeInstruction recipeInstruction);
    RecipeIngredientDTO toSmallDTO(RecipeIngredient recipeIngredient);
    RecipeIngredientDTO toFullDTO(RecipeIngredient recipeIngredient, Recipe recipe);
    RecipeDTO toSmallDTO(Recipe recipe);
    RecipeDTO toHalfFullCategoryDTO(Recipe recipe, List<RecipeCategory> recipeCategories);
    RecipeDTO toHalfFullDTO(Recipe recipe, List<RecipeIngredient> recipeIngredients);
    RecipeDTO toFullDTO(Recipe recipe, List<RecipeCategory> recipeCategories, List<RecipeIngredient> recipeIngredients);
    RecipeCategoryDTO toSmallDTO(RecipeCategory recipeCategory);
    RecipeCategoryDTO toFullDTO(RecipeCategory recipeCategory, List<Recipe> recipes);


}
