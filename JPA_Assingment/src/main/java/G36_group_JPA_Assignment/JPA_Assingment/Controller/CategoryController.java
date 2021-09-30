package G36_group_JPA_Assignment.JPA_Assingment.Controller;

import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeCategoryDTO;
import G36_group_JPA_Assignment.JPA_Assingment.DTO.RecipeDTO;
import G36_group_JPA_Assignment.JPA_Assingment.Model.Recipe;
import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeCategory;
import G36_group_JPA_Assignment.JPA_Assingment.Service.RecipeCategoryService;
import G36_group_JPA_Assignment.JPA_Assingment.Service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {


    private final RecipeCategoryService categoryService;

    public CategoryController(RecipeCategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/api/v1/category")
    public ResponseEntity<RecipeCategoryDTO> createRecipe(@RequestBody RecipeCategoryDTO recipeCategoryDTO){
        return ResponseEntity.status(201).body(categoryService.create(recipeCategoryDTO));
    }

    @GetMapping("/api/v1/categories")
    public ResponseEntity<List<RecipeCategoryDTO>> search(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/api/v1/categories/{id}")
    public ResponseEntity<RecipeCategoryDTO> findById(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/api/v1/categories/{id}")
    public ResponseEntity<RecipeCategoryDTO> update(@PathVariable(name = "id") Integer id, @RequestBody RecipeCategoryDTO recipeCategoryDTO){
        return ResponseEntity.ok(categoryService.update(id, recipeCategoryDTO));
    }

}