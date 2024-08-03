package lab3.JonerClaudio.scafolding.models;


import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Match {
    private Long id;
    private User user;
    private MatchDifficulty difficulty;
    private Integer numeroDescubrir;
    private Integer cantIntentos;

    private MatchStatus status;
}
