package vakcheck.com.controller;

import vakcheck.com.vacina.Vacina;
import vakcheck.com.vacina.IVacinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vakcheck.com.vacina.*;

@RestController
@RequestMapping("vacinas")
public class VacinaController {

    @Autowired
    private IVacinaRepository VacRepository;

    //cadastrar
    @PostMapping
    @Transactional
    public void cadastroEmpresa(@RequestBody @Valid RDadosCadastroVacina dadosEmpresa){
        VacRepository.save(new Vacina(dadosEmpresa));
    }
    //buscar
    @GetMapping
    public Page<RDadosListagemVacina> listar(@RequestParam(name = "idVacina") Long idVacina, @PageableDefault(size = 10, sort = {"idVacina"}) Pageable paginacao){
        return VacRepository.findAllByIdVacina(idVacina, paginacao).map(RDadosListagemVacina::new);
    }

    //atualizar
    @PutMapping("/vacinas/{idVacina}")
    @Transactional
    public void atualizarEmpresa(@PathVariable Long idEmpresa, @RequestBody @Valid RDadosAtualizacaoVacina dadosEmpresa){
        var vacina = VacRepository.getReferenceById(dadosEmpresa.idVacina());
        vacina.atualizarInformacoes(dadosEmpresa);
    }

    //excluir
    @DeleteMapping("/vacinas/{idVacina}")
    @Transactional
    public void excluirVacina(@PathVariable Long idVacina){
        VacRepository.deleteById(idVacina);
    }
}