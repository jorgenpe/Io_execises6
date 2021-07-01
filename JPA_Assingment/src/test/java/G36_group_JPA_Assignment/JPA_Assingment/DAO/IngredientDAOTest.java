package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.Ingredient;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class IngredientDAOTest {

    @Autowired
    private IngredientDAO testObject;

    @Autowired
    private TestEntityManager em;

    public List<Ingredient> ingredientData(){


        return  Arrays.asList(

                new Ingredient(0,"TestI1"),
                new Ingredient (0,"TestI2"),
                new Ingredient (0,"TestI3"),
                new Ingredient (0,"TestI4")
        );
    }


    private List<Ingredient> ingredientInContext;
    @BeforeEach
    void setUp() {

        ingredientInContext = new ArrayList<>();
        for(Ingredient ingredient: ingredientData()){
            ingredientInContext.add(em.persist(ingredient));
        }
        em.flush();
    }

    @Test
    void findByIngredientNameIgnoreCase() {

        Ingredient result = testObject.findByIngredientNameIgnoreCase("TestI2");

        assertNotNull(result);
        assertEquals("TestI2", result.getIngredientName());
    }

    @Test
    void findByIngredientNameIsLikeIgnoreCase() {

        List<Ingredient> result = testObject.findByIngredientNameContainingIgnoreCase("Test");

        assertNotNull(result);


        assertFalse( result.isEmpty());
        assertEquals(4, result.size());


    }
}