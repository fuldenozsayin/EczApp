package app.eczapp.business.rules;


import app.eczapp.core.utilities.exception.BusinessException;
import app.eczapp.dataAccess.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
@AllArgsConstructor
//IOC ye yerlesmesi icin (new lememek icin) bu annotation eklenir
public class ProductBusinessRules {

    private ProductRepository productRepository;

    public void checkIfProductNameExists(String name) {
        if (this.productRepository.existsByName(name)){
            throw new BusinessException("Product name already exists!"); //Java Exception Types --> business rules ile ilgili kendi hata kodlarimizi(Runtime) yazmamis gerekli
        }
    }

}
