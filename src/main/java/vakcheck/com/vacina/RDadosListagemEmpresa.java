package vakcheck.com.vacina;

public record RDadosListagemEmpresa(
        Long   idEmpresa,
        String nmFantEmpresa,
        String cnpjEmpresa){

    public RDadosListagemEmpresa(Vacina vacina){
        this(vacina.getIdEmpresa(), vacina.getNmFantEmpresa(), vacina.getCnpjEmpresa());
    }
}