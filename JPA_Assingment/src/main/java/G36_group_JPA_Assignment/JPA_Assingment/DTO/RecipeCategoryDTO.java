package G36_group_JPA_Assignment.JPA_Assingment.DTO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;

import java.io.Serializable;
import java.util.List;

public class RecipeCategoryDTO implements Serializable {

    private int id;
    private String category;
    private List<RecipeDTO> recipes;

    public RecipeCategoryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }
}
