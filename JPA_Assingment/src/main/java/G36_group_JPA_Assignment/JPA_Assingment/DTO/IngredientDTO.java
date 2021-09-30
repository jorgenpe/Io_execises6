package G36_group_JPA_Assignment.JPA_Assingment.DTO;

import java.io.Serializable;

public class IngredientDTO implements Serializable {

    private int id;
    private String Ingredient;

    public IngredientDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredient() {
        return Ingredient;
    }

    public void setIngredient(String ingredient) {
        Ingredient = ingredient;
    }
}
