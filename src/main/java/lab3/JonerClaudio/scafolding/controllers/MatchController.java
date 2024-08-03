package lab3.JonerClaudio.scafolding.controllers;

import lab3.JonerClaudio.scafolding.dtos.DummyDto;
import lab3.JonerClaudio.scafolding.dtos.MatchDto;
import lab3.JonerClaudio.scafolding.models.Dummy;
import lab3.JonerClaudio.scafolding.models.Match;
import lab3.JonerClaudio.scafolding.services.DummyService;
import lab3.JonerClaudio.scafolding.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guess-number/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;


}
