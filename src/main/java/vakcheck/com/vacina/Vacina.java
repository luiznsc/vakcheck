package vakcheck.com.vacina;


import vakcheck.com.endereco.DadosEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "TB_VACINA")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idVacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VACINAVc")
    @SequenceGenerator(name="SQ_VACINA", sequenceName = "SQ_VACINA")
    @Column(name = "ID_VACINA")
    private Long idEmpresa;

    @Column(name = "NM_VACINA", nullable = false)
    private String rzSocialEmpresa;

    @Column(name = "LOTE_VACINA", nullable = false)
    private String nmFantEmpresa;

    @Column(name = "CNPJ_EMPRESA", nullable = false)
    private String cnpjEmpresa;

    @Column(name = "TEL_EMPRESA", nullable = false)
    private String telEmpresa;

    @Column(name = "EMAIL_EMPRESA", nullable = false)
    private String emailEmpresa;

    @Column(name =  "SITUACAO_EMPRESA", nullable = false)
    private String situacaoEmpresa;

    @Embedded
    private DadosEndereco EnderecoEmpresa;

    //construtor para repository campo empresaUsuario
    public Vacina(String cnpjEmpresa) {
        this();
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public Vacina(RDadosCadastroEmpresa dadosEmpresa) {
        this.rzSocialEmpresa = dadosEmpresa.rzSocialEmpresa();
        this.nmFantEmpresa = dadosEmpresa.nmFantEmpresa();
        this.cnpjEmpresa = dadosEmpresa.cnpjEmpresa();
        this.telEmpresa = dadosEmpresa.telEmpresa();
        this.emailEmpresa = dadosEmpresa.emailEmpresa();
        this.EnderecoEmpresa = new DadosEndereco();
    }
    //metodo para tratar os campos de atualizacao do endereco
    public void atualizarInformacoes(RDadosAtualizacaoEmpresa dadosEmpresa){
        if (dadosEmpresa.nmFantEmpresa() != null) {
            this.nmFantEmpresa = dadosEmpresa.nmFantEmpresa();
        }
        if (dadosEmpresa.telEmpresa() != null) {
            this.telEmpresa = dadosEmpresa.telEmpresa();
        }
        if (dadosEmpresa.emailEmpresa() != null) {
            this.emailEmpresa = dadosEmpresa.emailEmpresa();
        }
        if (dadosEmpresa.endereco() != null) {
            this.EnderecoEmpresa.atualizarInformacoes(dadosEmpresa.endereco());
        }

    }

    //delete fará empresa ficar inativa
    public void excluirEmpresa() {
        this.situacaoEmpresa = "INATIVA";
    }
}