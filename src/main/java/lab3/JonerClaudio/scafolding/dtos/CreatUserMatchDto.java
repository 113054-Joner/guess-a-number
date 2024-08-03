package lab3.JonerClaudio.scafolding.dtos;

import lab3.JonerClaudio.scafolding.models.Match;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatUserMatchDto {
    private MatchDifficulty matchDifficulty;
}
