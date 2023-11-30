package vakcheck.com.fabricante;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RFabricante(
        @NotBlank
        String nomeFabricante,
        @NotBlank
        String contatoFabricante
) {
}