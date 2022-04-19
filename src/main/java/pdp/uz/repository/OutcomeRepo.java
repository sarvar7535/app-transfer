package pdp.uz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.domain.Outcome;

import java.util.List;

@Repository
public interface OutcomeRepo extends JpaRepository<Outcome, Long> {

    List<Outcome> findAllByFromCardId(Long id);
}
