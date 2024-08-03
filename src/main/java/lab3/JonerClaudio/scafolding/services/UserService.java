package lab3.JonerClaudio.scafolding.services;

import lab3.JonerClaudio.scafolding.models.RoundMatch;
import lab3.JonerClaudio.scafolding.models.Match;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lab3.JonerClaudio.scafolding.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(String userName,String email);

    Match createUserMatch(Long userId, MatchDifficulty difficulty);

    RoundMatch playUserMatch(Long userId, Long matchId, Integer numeroABuscar);
}
