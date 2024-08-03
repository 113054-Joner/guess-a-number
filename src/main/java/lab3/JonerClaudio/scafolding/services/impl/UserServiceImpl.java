package lab3.JonerClaudio.scafolding.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lab3.JonerClaudio.scafolding.entities.UserEntity;
import lab3.JonerClaudio.scafolding.models.Dummy;
import lab3.JonerClaudio.scafolding.models.Match;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lab3.JonerClaudio.scafolding.models.User;
import lab3.JonerClaudio.scafolding.repositories.DummyRepository;
import lab3.JonerClaudio.scafolding.repositories.UserRepository;
import lab3.JonerClaudio.scafolding.services.DummyService;
import lab3.JonerClaudio.scafolding.services.MatchService;
import lab3.JonerClaudio.scafolding.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchService matchService;

    @Qualifier("moddelMapper")
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public User createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);

        if(userEntityOptional.isPresent()){
            //TODO: enviar error al usuario
            return null;

        }else{
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setEmail(email);

            UserEntity userEntitySaved = userRepository.save(userEntity);

            return modelMapper.map(userEntitySaved,User.class);
        }


    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulty difficulty) {
        Optional<UserEntity> userEntity =userRepository.findById(userId);
        if (userEntity.isEmpty()){
            throw new EntityNotFoundException();
        }else {
            User user = modelMapper.map(userEntity.get(),User.class);
            return matchService.createMatch(user,difficulty);
        }
    }
}
