package app.eczapp.business.requests;

import app.eczapp.entities.concretes.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //data alıyorsam request //kullanıcya br şe yveriyorsam response
// @Data: @Data genellikle Java'daki Lombok kütüphanesi tarafından sağlanan bir açıklama tipidir.
// Lombok, Java sınıflarını daha az kodla oluşturmayı sağlayan bir kütüphanedir. @Data açıklaması, bir sınıfın tüm
// temel işlevlerini otomatik olarak eklemek için gerekli getter ve setter metodları, equals(), hashCode() ve toString() gibi yöntemleri otomatik olarak oluşturur.
// Bu sayede sınıfı daha temiz ve daha az tekrar eden kodla tanımlamak mümkün olur.

@NoArgsConstructor//@NoArgsConstructor: Bu, Lombok tarafından sağlanan bir diğer açıklama tipidir.
// Bu açıklama, sınıfa parametresiz bir yapılandırıcı (constructor) ekler.
// Yani, sınıfın hiçbir parametre almadan bir nesnesini oluşturmak için kullanılabilir.
// Bu sayede sınıfın nesnesini oluşturmak için tekrar tekrar parametresiz yapılandırıcı yazma ihtiyacını ortadan kaldırır ve kodu daha temiz hale getirir.

@AllArgsConstructor//@AllArgsConstructor: Bu da Lombok tarafından sağlanan bir açıklama tipidir.
// Bu açıklama, sınıfa tüm alanları içeren parametreli bir yapılandırıcı ekler. Yani, sınıfın tüm alanlarını parametre olarak
// alarak bir nesne oluşturmak için kullanılabilir.
// Bu, tüm alanların değerlerini tek bir yapılandırıcı çağrısıyla atamak için kullanışlıdır.

public class CreateProductRequest { //Bu elimde şöyle bir ürün var onu ekler misin? Kaydedir misin diye kullanıcının verdiği data
	@NotNull//zorunlu doldurması
	@Size(min = 3, max = 90)
	private String name;

	@NotNull//zorunlu doldurması
	@NotBlank//boşluk geçmesini engeller
	@Size(min=10,max = 10)
	private String barcode;

	@NotNull//zorunlu doldurması
	@NotBlank//boşluk geçmesini engeller
	private double price;

	
}
