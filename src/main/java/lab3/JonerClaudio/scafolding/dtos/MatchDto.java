package lab3.JonerClaudio.scafolding.dtos;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchDto {
    private Long id;

    private MatchDifficulty difficulty;

    private Integer cantIntentos;

}
