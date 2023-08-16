package app.eczapp.business.concretes;


import app.eczapp.business.abstracts.ProductService;
import app.eczapp.business.requests.CreateProductRequest;
import app.eczapp.business.requests.UpdateProductRequest;
import app.eczapp.business.responses.GetAllProductsResponse;
import app.eczapp.business.responses.GetByIdProductResponse;
import app.eczapp.business.rules.ProductBusinessRules;
import app.eczapp.core.utilities.mappers.ModelMapperService;
import app.eczapp.dataAccess.abstracts.ProductRepository;
import app.eczapp.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Getter
@Setter
public class ProductManager implements ProductService {

	private final ProductRepository productRepository;
	private final ModelMapperService modelMapperService;
	private ProductBusinessRules productBusinessRules;

	@Override
	public List<GetAllProductsResponse> getAll() {

		List<Product> products = productRepository.findAll();
		return products.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, GetAllProductsResponse.class)).toList();
	}

	@Override
	public GetByIdProductResponse getById(int id) {

		Product product = this.productRepository.findById(String.valueOf(id)).orElseThrow(); // Bulamazsan hata firlat
		return this.modelMapperService.forResponse().map(product, GetByIdProductResponse.class);
	}

	@Override
	public void add(CreateProductRequest createProductRequest) {
		this.productBusinessRules.checkIfProductNameExists(createProductRequest.getName());
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class); //Gelen kaynagi (source=request) --> Brand'e cevir
		this.productRepository.save(product);
	}
	@Override
	public void update(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		product.setId(0);
		this.productRepository.save(product); //Buradaki save'in add den farki id de oldugu icin insert degil update islemi yapar UpdateBrandRequest sayesinde
	}
	@Override
	public void delete(int id) {
		this.productRepository.deleteById(String.valueOf(id));
	}
}