package app.eczapp.webApi.controllers;

import app.eczapp.business.abstracts.ProductService;
import app.eczapp.business.requests.CreateProductRequest;
import app.eczapp.business.requests.UpdateProductRequest;
import app.eczapp.business.responses.GetAllProductsResponse;
import app.eczapp.business.responses.GetByIdProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<GetAllProductsResponse> getAll(){

        return productService.getAll();
    }

    @GetMapping("/{productId}")//id süslü parantezin içinde değişken oldu.
    public GetByIdProductResponse getById(@PathVariable int productId){
        return productService.getById(productId);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateProductRequest createProductRequest) {
        this.productService.add(createProductRequest);

    }

    @PutMapping//Güncellemelerde putmapping kullanılır
    public void update(@RequestBody UpdateProductRequest updateProductRequest){
        this.productService.update((updateProductRequest));
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable int productId){
        this.productService.delete(productId);
    }

}
