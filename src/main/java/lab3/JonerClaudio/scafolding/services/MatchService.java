package lab3.JonerClaudio.scafolding.services;

import lab3.JonerClaudio.scafolding.models.RoundMatch;
import lab3.JonerClaudio.scafolding.models.Match;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lab3.JonerClaudio.scafolding.models.User;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {

    Match createMatch(User user, MatchDifficulty matchDifficulty);

    Match getMatchById(Long matchId);

    RoundMatch playMatch(Match match, Integer numero);
}
