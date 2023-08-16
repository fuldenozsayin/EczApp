package app.eczapp.business.abstracts;

import app.eczapp.business.requests.CreateCategoryRequest;
import app.eczapp.business.requests.UpdateCategoryRequest;
import app.eczapp.business.responses.GetAllCategoriesResponse;
import app.eczapp.business.responses.GetByIdCategoryResponse;
import java.util.List;


public interface CategoryService {//Response

	List<GetAllCategoriesResponse> getAll();
	GetByIdCategoryResponse getById(int id);
	void add(CreateCategoryRequest createCategoryRequest);

	void update(UpdateCategoryRequest updateCategoryRequest);
	void delete(int id);
}
