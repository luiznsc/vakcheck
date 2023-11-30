package vakcheck.com.vacina;

import vakcheck.com.fabricante.RFabricante;

public record RDadosCadastroVacina(

        String nmVacina,
        Long fxEtariaVacina,
        String nmDoseVacina,
        String intervaloDoseVacina,
        String loteVacina,
        RFabricante enderecoEmpresa
) {
}