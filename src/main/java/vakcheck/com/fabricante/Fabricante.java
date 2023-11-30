package vakcheck.com.fabricante;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fabricante {
    private String nomeFabricante;
    private String contatoFabricante;

    public Fabricante(RFabricante dadosEndereco) {
        this.nomeFabricante = dadosEndereco.nomeFabricante();
        this.contatoFabricante = dadosEndereco.contatoFabricante();
    }

    public void atualizarInformacoes(RFabricante dadosFabricante) {
        if (dadosFabricante.nomeFabricante() != null ) {
            this.nomeFabricante = dadosFabricante.nomeFabricante();
        }
        if (dadosFabricante.contatoFabricante() != null ) {
            this.contatoFabricante = dadosFabricante.contatoFabricante();
        }
    }
}
