package pdp.uz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.domain.Card;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {

    Optional<Card> findByUsernameAndIdAndActiveTrue(String username, Long id);

    List<Card> findAllByUsername(String username);

    Optional<Card> findByIdAndActiveTrue(Long toCardId);
}
