package G36_group_JPA_Assignment.JPA_Assingment.DTO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeCategory;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeInstruction;

import java.io.Serializable;
import java.util.List;

public class RecipeDTO implements Serializable {

    private int id;
    private String recipeName;
    private List<RecipeIngredientDTO> recipeIngredients;
    private RecipeInstruction instruction;
    private List<RecipeCategoryDTO> categories;

    public RecipeDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredientDTO> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientDTO> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategoryDTO> categories) {
        this.categories = categories;
    }
}
