package G36_group_JPA_Assignment.JPA_Assingment.Model;


import lombok.*;
import net.minidev.json.annotate.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "recipeId")
@Entity

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;


    @OneToMany(targetEntity = RecipeIngredient.class, cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            mappedBy = "recipe",
            orphanRemoval = true
    )
    @JsonIgnore
    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    //@JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(

            cascade = {CascadeType.DETACH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH

            },
            fetch = FetchType.LAZY


    )
    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn( name = "recipe_id") ,
            inverseJoinColumns = @JoinColumn(name = "category_id")

    )
    private List<RecipeCategory> categories;


    public Recipe(String recipeName,List<RecipeIngredient> listRecipeIngredient, RecipeInstruction instruction,List<RecipeCategory> categories){

        this.recipeName = recipeName;
        this.recipeIngredients = listRecipeIngredient;
        this.instruction = instruction;
        this.categories = categories;


    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe(String recipeName, RecipeInstruction instruction) {
        this.recipeName = recipeName;
        this.instruction = instruction;
    }

    public void setRecipeIngredient(List<RecipeIngredient> recipeIngredient) {

        if(this.recipeIngredients == null){
            this.recipeIngredients = new ArrayList<>();
        }
        this.recipeIngredients = recipeIngredient;
    }

    public void setCategories(List<RecipeCategory> categories) {

        if(this.categories == null){
            this.categories = new ArrayList<>();
        }
        this.categories = categories;
    }


}
