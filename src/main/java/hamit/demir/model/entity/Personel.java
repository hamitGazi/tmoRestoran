package hamit.demir.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="personeller",indexes = {@Index(name="idx_personel_kullaniciAdi",columnList = "kullaniciAdi")})
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Personelin adı-soyadı.
     */
    @Column(name = "ad", nullable = false)
    private String ad;

    @Column(name = "soyad", nullable = false)
    private String soyad;

    /**
     * Giriş için kullanıcı adı.
     */
    @Email(message = "Geçerli bir e-posta adresi giriniz") // E-posta formatını zorunlu kılar
    @NotBlank(message = "E-posta alanı boş olamaz")
    @Column(name = "kullaniciAdi", nullable = false, unique = true)
    private String email;

    /**
     * Şifre (hash'lenmiş olarak tutulmalı).
     */
    @NotBlank(message = "Şifre boş olamaz")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    @Column(name = "sifre", nullable = false)
    private String sifre;

    /**
     * Personelin görev rolü.
     */
    @Enumerated(EnumType.STRING)
    private PersonelRol rol;

    @Column(name = "aktif", nullable = false)
    private boolean aktif = true;

    private LocalDateTime olusturTarih;


    private LocalDateTime guncelleTarih;
}