package app.eczapp.entities.concretes;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "pharmacies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String ad;

    @Column(name = "address")
    private String adres;

    @Column(name = "user_name")
    private int user_name;

    @Column(name = "password")
    private String password;
}
