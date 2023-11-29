package vakcheck.com.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DadosEndereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public DadosEndereco(RDadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
        this.complemento = dadosEndereco.complemento();
        this.numero = dadosEndereco.numero();
    }

    public void atualizarInformacoes(RDadosEndereco dadosEndereco) {
        if (dadosEndereco.logradouro() != null ) {
            this.logradouro = dadosEndereco.logradouro();
        }
        if (dadosEndereco.bairro() != null ) {
            this.bairro = dadosEndereco.bairro();
        }
        if (dadosEndereco.cep() != null ) {
            this.cep = dadosEndereco.cep();
        }
        if (dadosEndereco.cidade() != null ) {
            this.cidade = dadosEndereco.cidade();
        }
        if (dadosEndereco.uf() != null ) {
            this.uf = dadosEndereco.uf();
        }
        if (dadosEndereco.complemento() != null ) {
            this.complemento = dadosEndereco.complemento();
        }
        if (dadosEndereco.numero() != null ) {
            this.numero = dadosEndereco.numero();
        }
    }
}
