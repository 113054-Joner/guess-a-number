package lab3.JonerClaudio.scafolding.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;

    @JsonProperty("username")
    String userName;

    @Email
    String email;
}
