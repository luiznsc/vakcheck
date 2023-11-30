package vakcheck.com.vacina;

import jakarta.validation.constraints.NotNull;
import vakcheck.com.fabricante.RFabricante;

public record RDadosAtualizacaoVacina(
        @NotNull
        Long idVacina,
        String nmVacina,
        Long fxEtariaVacina,
        Long nmDoseVacina,
        String intervaloDoseVacina,
        String loteVacina
) {
}