package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

   @Autowired
    private NinjaRepository repo;

    // Criar um novo ninja
    public NinjaModel createNinja(NinjaModel ninja){
        return repo.save(ninja);
    }

    // Mostrar ninjas criados
    public List<NinjaModel> getAllNinjas(){
        return repo.findAll();
    }

    // Mostrar um ninja por id
    public Optional<NinjaModel> findNinjaById(Long id){
        return repo.findById(id);
    }

    // Deletar ninja pelo id
    public void deleteNinja(Long id){
        repo.deleteById(id);
    }

    // Atualizar ninja
    public NinjaModel updateNinja(Long id, NinjaModel ninja) {
        Optional<NinjaModel> oldNinja = repo.findById(id);

        if (oldNinja.isPresent()) {
            NinjaModel newNinja = oldNinja.get();
            newNinja.setNome(ninja.getNome());
            newNinja.setAldeia(ninja.getAldeia());
            newNinja.setIdade(ninja.getIdade());
            newNinja.setElemento(ninja.getElemento());
            newNinja.setImgUrl(ninja.getImgUrl());

            return repo.save(newNinja);
        } else {
            throw new RuntimeException("ninjolas nao encontradolas do o id: " + id + "Tente novamente");
        }
    }
}
