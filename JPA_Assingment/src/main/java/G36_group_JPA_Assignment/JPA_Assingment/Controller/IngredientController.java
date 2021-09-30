package G36_group_JPA_Assignment.JPA_Assingment.Controller;

import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeCategoryDTO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeIngredientDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeIngredient;
import G36_group_JPA_Assignment.JPA_Assingment.Service.RecipeCategoryService;
import G36_group_JPA_Assignment.JPA_Assingment.Service.RecipeIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class IngredientController {

    private final RecipeIngredientService ingredientService;

    public IngredientController(RecipeIngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @PostMapping("/api/v1/ingredient")
    public ResponseEntity<RecipeIngredientDTO> createRecipe(@RequestBody RecipeIngredientDTO recipeIngredientDTO){
        return ResponseEntity.status(201).body(ingredientService.create(recipeIngredientDTO));
    }

    @GetMapping("/api/v1/ingredients")
    public ResponseEntity<List<RecipeIngredientDTO>> search(){
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @GetMapping("/api/v1/ingredients/{id}")
    public ResponseEntity<RecipeIngredientDTO> findById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(ingredientService.findById(id));
    }

    @PutMapping("/api/v1/ingredients/{id}")
    public ResponseEntity<RecipeIngredientDTO> update(@PathVariable(name = "id") String id, @RequestBody RecipeIngredientDTO recipeIngredientDTO){
        return ResponseEntity.ok(ingredientService.update(id, recipeIngredientDTO));
    }
}
