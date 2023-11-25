import com.example.karizma_backend.entities.Ingredients;
import com.example.karizma_backend.entities.Ingredientss;
import com.example.karizma_backend.service.impl.IngredientService;
import com.example.karizma_backend.service.impl.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ingredientss")
public class IngredientsController {

    @Autowired
    private IngredientService IngredientsService;

    @GetMapping
    public List<Ingredients> getAllIngredients() {
        return IngredientsService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredients getIngredientsById(@PathVariable Long id) {
        return IngredientsService.getIngredientsById(id);
    }

    @PostMapping
    public Ingredients createIngredients(@RequestBody Ingredients Ingredients) {
        return IngredientsService.createIngredients(Ingredients);
    }

    @PutMapping("/{id}")
    public Ingredients updateIngredients(@PathVariable Long id, @RequestBody Ingredients Ingredients) {
        return IngredientsService.updateIngredients(id, Ingredients);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredients(@PathVariable Long id) {
        IngredientsService.deleteIngredients(id);
    }
}
