
package com.example.demo.Controlador;

import com.example.demo.Modelo.Category;
import com.example.demo.Servicio.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omarg
 */

@RestController
@RequestMapping("/api/Category")

public class CategoryController {
@Autowired // mepermite traer metodos desde otros paquetees 
private CategoryService categoryService;

@GetMapping("/all")//leee la tabla completa
public List<Category> getAll(){
    return categoryService.getAll();
} 

@GetMapping("/{id}")// nos resive un id y devulve los s datos d ese id
public Optional<Category> getCategory(@PathVariable("id") int id){
    return categoryService.getCategory(id);
}

@PostMapping("/save")
@ResponseStatus(HttpStatus.CREATED)
        public Category save (@RequestBody Category category){
            return categoryService.save(category);
        }
}
