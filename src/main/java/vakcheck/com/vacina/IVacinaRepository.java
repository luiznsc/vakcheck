package vakcheck.com.vacina;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IVacinaRepository extends JpaRepository<Vacina, Long> {
    Page<Vacina> findAllByIdVacina(@Param("vacina") Long idVacina, Pageable paginacao);
}