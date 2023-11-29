package vakcheck.com.controller;

import vakcheck.com.vacina.Vacina;
import vakcheck.com.vacina.IEmpresaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vakcheck.com.vacina.*;

@RestController
@RequestMapping("empresas")
public class VacinaController {

    @Autowired
    private IEmpresaRepository EmpRepository;

    //cadastrar
    @PostMapping
    @Transactional
    public void cadastroEmpresa(@RequestBody @Valid RDadosCadastroEmpresa dadosEmpresa){
        EmpRepository.save(new Vacina(dadosEmpresa));
    }
    //buscar
    @GetMapping
    public Page<RDadosListagemEmpresa> listar(@RequestParam(name = "situacaoEmpresa") String situacaoEmpresa, @PageableDefault(size = 10, sort = {"nmFantEmpresa"}) Pageable paginacao){
        return EmpRepository.findAllBySituacaoEmpresa(situacaoEmpresa, paginacao).map(RDadosListagemEmpresa::new);
    }

    //atualizar
    @PutMapping("empresas/{idEmpresa}")
    @Transactional
    public void atualizarEmpresa(@PathVariable Long idEmpresa, @RequestBody @Valid RDadosAtualizacaoEmpresa dadosEmpresa){
        var empresa = EmpRepository.getReferenceById(dadosEmpresa.id());
        empresa.atualizarInformacoes(dadosEmpresa);
    }

    //excluir
    @DeleteMapping("empresas/{idEmpresa}")
    @Transactional
    public void excluirEmpresa(@PathVariable Long idEmpresa){
        var empresa = EmpRepository.getReferenceById(idEmpresa);
        empresa.excluirEmpresa();
    }
}