package com.example.prova_final.viagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;


    public List<Viagem> getViagens() {
        return viagemRepository.findAll();
    }

    public Viagem createViagem(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public Viagem deleteViagem(Integer id) {
        try {
            Viagem viagem = viagemRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));
            viagemRepository.delete(viagem);
            return viagem;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar viagem: " + e.getMessage());
        }
    }
}