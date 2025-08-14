package hamit.demir.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "musteriler",schema = "alakart")
public class MusteriEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "ad")
    private String ad;
    @Column(name = "soyad")
    private String soyad;

    @Column(name = "telefon")
    private String telefon;

    @Email(message = "Geçerli bir e-posta adresi giriniz") // E-posta formatını zorunlu kılar
    @NotBlank(message = "E-posta alanı boş olamaz")
    @Column(name = "musteri_adi", nullable = false, unique = true)
    private String email;

/*    @NotBlank(message = "Şifre boş olamaz")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    @Column(name = "sifre", nullable = false)
    private String sifre;*/
    @Column(name = "adres",columnDefinition = "TEXT")
    private String adres;

    private LocalDateTime olusturmaTarih;

    private LocalDateTime guncelleTarih;

}