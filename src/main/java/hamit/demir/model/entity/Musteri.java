package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "musteriler")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ad")
    private String ad;
    @Column(name = "soyad")
    private String soyad;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "email")
    private String email;

    private LocalDateTime olusturmaTarih;

    private LocalDateTime güncelleTarih;

}