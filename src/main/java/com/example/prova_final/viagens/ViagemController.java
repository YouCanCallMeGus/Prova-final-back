package com.example.prova_final.viagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @GetMapping
    public List<Viagem> getViagens() {
        return viagemService.getViagens();
    }

    @PostMapping
    public Viagem createViagem(@RequestBody Viagem viagem, @AuthenticationPrincipal Jwt jwt) {
        return viagemService.createViagem(viagem);
    }

    @DeleteMapping("/{id}")
    public Viagem getViagem(@PathVariable Integer id) {
        return viagemService.deleteViagem(id);
    }
}

