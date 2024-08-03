package lab3.JonerClaudio.scafolding.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoundMatchDto {
    private MatchDto matchDto;
    private String respuesta;
}
