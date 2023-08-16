package app.eczapp.business.rules;

import app.eczapp.core.utilities.exception.BusinessException;
import app.eczapp.dataAccess.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryBusinessRules {

    private CategoryRepository categoryRepository;

    public void checkIfCategoryNameExists(String name) {
        if (this.categoryRepository.existsByName(name)) {
            throw new BusinessException("Category name already exists!");
        }
    }
}
