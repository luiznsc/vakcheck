package vakcheck.com.vacina;

import jakarta.validation.constraints.NotNull;
import vakcheck.com.endereco.RDadosEndereco;

public record RDadosAtualizacaoEmpresa(
        @NotNull
        Long id,
        String nmFantEmpresa,
        String telEmpresa,
        String emailEmpresa,
        RDadosEndereco endereco) {
}