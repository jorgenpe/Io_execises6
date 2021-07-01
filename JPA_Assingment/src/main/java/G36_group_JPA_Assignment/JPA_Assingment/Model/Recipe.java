package G36_group_JPA_Assignment.JPA_Assingment.Model;


import lombok.*;

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

    @OneToMany( cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY,
            mappedBy = "recipe",
            orphanRemoval = true)
    private List<RecipeIngredient> recipeIngredient;

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
        this.recipeIngredient = listRecipeIngredient;
        this.instruction = instruction;
        this.categories = categories;


    }

    public void setRecipeIngredient(List<RecipeIngredient> recipeIngredient) {

        if(this.recipeIngredient == null){
            this.recipeIngredient = new ArrayList<>();
        }
        this.recipeIngredient = recipeIngredient;
    }

    public void setCategories(List<RecipeCategory> categories) {

        if(this.categories == null){
            this.categories = new ArrayList<>();
        }
        this.categories = categories;
    }
}
