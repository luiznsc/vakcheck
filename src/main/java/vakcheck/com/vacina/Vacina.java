package vakcheck.com.vacina;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import vakcheck.com.fabricante.Fabricante;

@Table(name = "TB_VACINA")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idVacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VACINA")
    @SequenceGenerator(name="SQ_VACINA", sequenceName = "SQ_VACINA")
    @Column(name = "ID_VACINA")
    private Long idVacina;

    @Column(name = "NOME_VACINA", nullable = false)
    private String nmVacina;

    @Column(name = "FX_ETARIA_VACINA", nullable = false)
    private Long fxEtariaVacina;

    @Column(name = "NM_DOSE_VACINA", nullable = false)
    private Long nmDoseVacina;

    @Column(name = "INTERVALO_DOSE_VACINA", nullable = false)
    private String intervaloDoseVacina;

    @Column(name =  "LOTE_VACINA", nullable = false)
    private String loteVacina;

    @Embedded
    private Fabricante fabricanteVacina;

    public Vacina(Long idVacina) {
        this();
        this.idVacina = idVacina;
    }

    public Vacina(RDadosCadastroVacina dadosVacina) {
        this.nmVacina = dadosVacina.nmVacina();
        this.fxEtariaVacina = dadosVacina.fxEtariaVacina();
        this.nmDoseVacina = dadosVacina.nmDoseVacina();
        this.intervaloDoseVacina = dadosVacina.intervaloDoseVacina();
        this.loteVacina = dadosVacina.loteVacina();
        this.fabricanteVacina = new Fabricante();
    }

    public void atualizarInformacoes(RDadosAtualizacaoVacina dadosVacina){
        if (dadosVacina.nmVacina() != null) {
            this.nmVacina = dadosVacina.nmVacina();
        }
        if (dadosVacina.fxEtariaVacina() != null) {
            this.fxEtariaVacina = dadosVacina.fxEtariaVacina();
        }
        if (dadosVacina.nmDoseVacina() != null) {
            this.nmDoseVacina = dadosVacina.nmDoseVacina();
        }
        if (dadosVacina.intervaloDoseVacina() != null) {
            this.intervaloDoseVacina = dadosVacina.intervaloDoseVacina();
        }
        if (dadosVacina.loteVacina() != null) {
            this.loteVacina = dadosVacina.loteVacina();
        }
    }
}