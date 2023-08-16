package app.eczapp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCategoriesResponse { //Tüm ürünleri listelemek isteğine karşı verdiğimiz yanıt
	private int id;
	private String name;
}