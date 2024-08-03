package lab3.JonerClaudio.scafolding.repositories;


import lab3.JonerClaudio.scafolding.entities.DummyEntity;
import lab3.JonerClaudio.scafolding.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> getByEmail(String email);
}
