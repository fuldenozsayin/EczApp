package app.eczapp.entities.concretes;

import ch.qos.logback.core.model.INamedModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "barcode", unique = true)
    private String barcode;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

  /*  @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;*/
}
