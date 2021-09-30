package G36_group_JPA_Assignment.JPA_Assingment.Controller;


import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {


    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping("/api/v1/recipe")
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO recipeDTO){
        return ResponseEntity.status(201).body(recipeService.create(recipeDTO));
    }

    @GetMapping("/api/v1/recipes")
    public ResponseEntity<List<RecipeDTO>> search(){
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @PutMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO> update(@PathVariable(name = "id") String id, @RequestBody RecipeDTO recipeDTO){
        return ResponseEntity.ok(recipeService.update(id, recipeDTO));
    }

}
