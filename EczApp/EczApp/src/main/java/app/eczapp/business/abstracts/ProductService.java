package app.eczapp.business.abstracts;

import java.util.List;

import app.eczapp.business.requests.CreateProductRequest;
import app.eczapp.business.requests.UpdateProductRequest;
import app.eczapp.business.responses.GetAllProductsResponse;
import app.eczapp.business.responses.GetByIdProductResponse;


public interface ProductService {//Response

	List<GetAllProductsResponse> getAll();
	GetByIdProductResponse getById(int id);
	void add(CreateProductRequest createProductRequest);

	void update(UpdateProductRequest updateProductRequest);
	void delete(int id);
}
