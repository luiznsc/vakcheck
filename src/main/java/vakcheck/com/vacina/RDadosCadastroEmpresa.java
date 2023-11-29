package vakcheck.com.vacina;

import vakcheck.com.endereco.RDadosEndereco;

public record RDadosCadastroEmpresa(
        String rzSocialEmpresa,
        String nmFantEmpresa,
        String cnpjEmpresa,
        String telEmpresa,
        String emailEmpresa,
        RDadosEndereco enderecoEmpresa
) {
}