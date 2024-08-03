package lab3.JonerClaudio.scafolding.repositories;


import lab3.JonerClaudio.scafolding.entities.DummyEntity;
import lab3.JonerClaudio.scafolding.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity,Long> {
}
