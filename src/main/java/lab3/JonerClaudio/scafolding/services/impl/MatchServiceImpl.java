package lab3.JonerClaudio.scafolding.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lab3.JonerClaudio.scafolding.models.RoundMatch;
import lab3.JonerClaudio.scafolding.entities.MatchEntity;
import lab3.JonerClaudio.scafolding.entities.UserEntity;
import lab3.JonerClaudio.scafolding.models.*;
import lab3.JonerClaudio.scafolding.repositories.MatchRepository;
import lab3.JonerClaudio.scafolding.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
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

    @Override
    public Match getMatchById(Long matchId) {
        Optional<MatchEntity> matchEntity = matchRepository.findById(matchId);
        if(matchEntity.isEmpty()){
            throw new EntityNotFoundException();
        }else{
            Match match = modelMapper.map(matchEntity.get(),Match.class);
            return match;
        }

    }

    @Override
    public RoundMatch playMatch(Match match, Integer numero) {
        RoundMatch roundMatch = new RoundMatch();
        roundMatch.setMatch(match);
        if(match.getStatus().equals(MatchStatus.FINISHED)){
            //TODO: ERROR
            return null;
        }
        if(match.getNumeroDescubrir().equals(numero)){
            //TODO: CALCULAR SCORE
            //TODO: DAR RESPUESTA
            match.setStatus(MatchStatus.FINISHED);
            roundMatch.setRespuesta("Gano");
        }else{
            match.setCantIntentos(match.getCantIntentos()-1);
            if(match.getCantIntentos().equals(0)){
                match.setStatus(MatchStatus.FINISHED);
                roundMatch.setRespuesta("Perdio");
            }else{
                if(numero > match.getNumeroDescubrir()){
                    //Todo: Responde Menor
                    roundMatch.setRespuesta("Menor");
                }else{
                    //Todo: Responde Mayor
                    roundMatch.setRespuesta("Mayor");
                }
            }
        }
        UserEntity userEntity = modelMapper.map(match.getUser(),UserEntity.class);

        MatchEntity matchEntity = modelMapper.map(match,MatchEntity.class);
        matchEntity.setUser(userEntity);
        matchEntity.setFechaActualzacion(LocalDateTime.now());
        matchRepository.save(matchEntity);
        return roundMatch;
    }
}
