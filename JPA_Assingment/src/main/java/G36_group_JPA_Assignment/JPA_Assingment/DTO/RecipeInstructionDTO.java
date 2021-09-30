package G36_group_JPA_Assignment.JPA_Assingment.DTO;

import java.io.Serializable;

public class RecipeInstructionDTO implements Serializable {

    private String id;
    private String instructions;

    public RecipeInstructionDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
