package app.eczapp.business.concretes;


import app.eczapp.business.abstracts.CategoryService;
import app.eczapp.business.requests.CreateCategoryRequest;
import app.eczapp.business.requests.UpdateCategoryRequest;
import app.eczapp.business.responses.GetAllCategoriesResponse;
import app.eczapp.business.responses.GetByIdCategoryResponse;
import app.eczapp.business.rules.CategoryBusinessRules;
import app.eczapp.core.utilities.mappers.ModelMapperService;
import app.eczapp.dataAccess.abstracts.CategoryRepository;
import app.eczapp.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Setter
public class CategoryManager implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final ModelMapperService modelMapperService;
	private CategoryBusinessRules categoryBusinessRules;

	@Override
	public List<GetAllCategoriesResponse> getAll() {

		List<Category> categories = categoryRepository.findAll();
		return categories.stream()
				.map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoriesResponse.class)).toList();
	}

	@Override
	public GetByIdCategoryResponse getById(int id) {

		Category category = this.categoryRepository.findById(String.valueOf(id)).orElseThrow(); // Bulamazsan hata firlat
		return this.modelMapperService.forResponse().map(category, GetByIdCategoryResponse.class);
	}

	@Override
	public void add(CreateCategoryRequest createCategoryRequest) {
		this.categoryBusinessRules.checkIfCategoryNameExists(createCategoryRequest.getName());

		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class); //Gelen kaynagi (source=request) --> Brand'e cevir
		this.categoryRepository.save(category);
	}

	@Override
	public void update(UpdateCategoryRequest updateCategoryRequest) {
//this.brandBusinessRules.checkIfBrandNameExists(updateBrandRequest.getName());

		Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
		category.setId(0);
		this.categoryRepository.save(category); //Buradaki save'in add den farki id de oldugu icin insert degil update islemi yapar UpdateBrandRequest sayesinde
	}

	@Override
	public void delete(int id) {
		this.categoryRepository.deleteById(String.valueOf(id));
	}
}
