package lab3.JonerClaudio.scafolding.entities;


import jakarta.persistence.*;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lab3.JonerClaudio.scafolding.models.MatchStatus;
import lab3.JonerClaudio.scafolding.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "marchs")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne//Mucho match a 1 usuario
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private MatchDifficulty difficulty;

    private Integer numeroDescubrir;


    private Integer cantIntentos;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column
    private LocalDateTime fechaCreacion;

    @Column
    private LocalDateTime fechaActualzacion;

}
