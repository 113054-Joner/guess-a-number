package lab3.JonerClaudio.scafolding.controllers;

import lab3.JonerClaudio.scafolding.dtos.DummyDto;
import lab3.JonerClaudio.scafolding.dtos.MatchDto;
import lab3.JonerClaudio.scafolding.dtos.UserDto;
import lab3.JonerClaudio.scafolding.models.Dummy;
import lab3.JonerClaudio.scafolding.models.Match;
import lab3.JonerClaudio.scafolding.models.MatchDifficulty;
import lab3.JonerClaudio.scafolding.models.User;
import lab3.JonerClaudio.scafolding.services.MatchService;
import lab3.JonerClaudio.scafolding.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Qualifier("moddelMapper")
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public ResponseEntity<UserDto> postUser(@RequestBody UserDto userDto){
        User user = userService.createUser(userDto.getUserName(),userDto.getEmail());
        if (Objects.isNull(user)){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"El mail ya Existe");
        }
        else {
            UserDto userDtoCreated = modelMapper.map(user,UserDto.class);
            return ResponseEntity.ok(userDtoCreated);
        }
    }

//    @PostMapping("/{userId}/matches/{difficulty}")
//    public ResponseEntity<MatchDto> postUserMatch(@PathVariable Long userId,@PathVariable MatchDifficulty difficulty){
//        Match match = userService.createUserMatch(userId,difficulty);
//        MatchDto mactchDto = modelMapper.map(match,MatchDto.class);
//        return ResponseEntity.ok(mactchDto);
//    }

    @PostMapping("/{userId}/matches")
    public ResponseEntity<MatchDto> postUserMatch(@PathVariable Long userId, @RequestBody MatchDifficulty difficulty) {
        Match match = userService.createUserMatch(userId, difficulty);
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);
        return ResponseEntity.ok(matchDto);
    }

}
