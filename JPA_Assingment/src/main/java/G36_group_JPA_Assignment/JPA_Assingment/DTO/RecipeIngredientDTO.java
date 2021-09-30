package G36_group_JPA_Assignment.JPA_Assingment.DTO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.Ingredient;
import G36_group_JPA_Assignment.JPA_Assingment.Model.Measurement;
import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;

import java.io.Serializable;

public class RecipeIngredientDTO implements Serializable {


    private String id;
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    private Recipe recipe;

    public RecipeIngredientDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
