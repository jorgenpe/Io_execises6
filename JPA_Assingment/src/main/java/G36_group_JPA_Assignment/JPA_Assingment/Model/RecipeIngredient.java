package G36_group_JPA_Assignment.JPA_Assingment.Model;

import lombok.*;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "recipeIngredientId")
@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator =  "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")


    private String recipeIngredientId;
    @ManyToOne(cascade = {
            CascadeType.ALL},
            fetch = FetchType.LAZY
    )



    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;


   @ManyToOne(targetEntity = Recipe.class,
            cascade = CascadeType.ALL
            , fetch = FetchType.EAGER
    )
    @JoinColumn(name = "recipe_id")

    private Recipe recipe;



}


