package lab3.JonerClaudio.scafolding.services;

import lab3.JonerClaudio.scafolding.models.Dummy;
import lab3.JonerClaudio.scafolding.models.Match;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lab3.JonerClaudio.scafolding.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {

    Match createMatch(User user, MatchDifficulty matchDifficulty);
}
