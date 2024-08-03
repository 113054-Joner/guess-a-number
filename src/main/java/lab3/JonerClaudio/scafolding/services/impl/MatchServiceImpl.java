package lab3.JonerClaudio.scafolding.services.impl;

import lab3.JonerClaudio.scafolding.entities.MatchEntity;
import lab3.JonerClaudio.scafolding.entities.UserEntity;
import lab3.JonerClaudio.scafolding.models.*;
import lab3.JonerClaudio.scafolding.repositories.DummyRepository;
import lab3.JonerClaudio.scafolding.repositories.MatchRepository;
import lab3.JonerClaudio.scafolding.services.DummyService;
import lab3.JonerClaudio.scafolding.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Qualifier("moddelMapper")
    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();

    @Override
    public Match createMatch(User user, MatchDifficulty matchDifficulty) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUser(modelMapper.map(user, UserEntity.class));
        matchEntity.setDifficulty(matchDifficulty);
        switch (matchDifficulty){
            case HARD -> matchEntity.setCantIntentos(5);
            case MEDIUM -> matchEntity.setCantIntentos(8);
            case EASY -> matchEntity.setCantIntentos(10);
        }
        matchEntity.setNumeroDescubrir(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYINING);
        matchEntity.setFechaCreacion(LocalDateTime.now());
        matchEntity.setFechaActualzacion(LocalDateTime.now());
        MatchEntity matchGuardado = matchRepository.save(matchEntity);
        return modelMapper.map(matchGuardado,Match.class);
    }
}
