package app.eczapp.webApi.controllers;

import app.eczapp.business.abstracts.CategoryService;
import app.eczapp.business.requests.CreateCategoryRequest;
import app.eczapp.business.requests.UpdateCategoryRequest;
import app.eczapp.business.responses.GetAllCategoriesResponse;
import app.eczapp.business.responses.GetByIdCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")

public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<GetAllCategoriesResponse> getAll(){

        return categoryService.getAll();
    }

    @GetMapping("/{categoryId}")//id süslü parantezin içinde değişken oldu.
    public GetByIdCategoryResponse getById(@PathVariable int categoryId){
        return categoryService.getById(categoryId);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        this.categoryService.add(createCategoryRequest);

    }

    @PutMapping//Güncellemelerde putmapping kullanılır
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        this.categoryService.update((updateCategoryRequest));
    }

    @DeleteMapping("/{categoryId}")
    public void delete(@PathVariable int categorytId){
        this.categoryService.delete(categorytId);
    }

}
