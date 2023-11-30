package vakcheck.com.vacina;

public record RDadosListagemVacina(
        Long   idVacina,
        String nmDoseVacina,
        String intervaloDoseVacina){

    public RDadosListagemVacina(Vacina vacina){
        this(vacina.getIdVacina(), vacina.getNmVacina(), vacina.getIntervaloDoseVacina());
    }
}