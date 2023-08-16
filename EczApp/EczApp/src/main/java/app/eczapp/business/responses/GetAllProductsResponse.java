package app.eczapp.business.responses;

import app.eczapp.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductsResponse { //Tüm ürünleri listelemek isteğine karşı verdiğimiz yanıt
	private int id;
	private String barcode;
	private String name;
	private double price;
}