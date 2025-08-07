package hamit.demir.model.dto.masaCategory;

public record MenuCategoryUpdateRequest(
        Long id,
        String ad,
        String aciklama,
        Integer menuSira,
        Boolean aktif
) {
}
