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
@EqualsAndHashCode(exclude = "categoryId")
@Entity

public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;
    @ManyToMany(

            cascade = {CascadeType.DETACH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH

            },
            fetch = FetchType.LAZY,
            mappedBy = "categories"
    )
    private List<Recipe> recipes;


    public void setRecipes(List<Recipe> recipes) {
        if(this.recipes == null){
            this.recipes = new ArrayList<>();
        }
        this.recipes = recipes;
    }
}
