package vakcheck.com.vacina;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IEmpresaRepository extends JpaRepository<Vacina, Long> {
    Page<Vacina> findAllBySituacaoEmpresa(@Param("situacao") String situacaoEmpresa, Pageable paginacao);
}