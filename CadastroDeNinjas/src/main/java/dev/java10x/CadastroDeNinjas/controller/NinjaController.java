package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService service;

    //METODO POST
    //LINK: localhost:8080/api/ninjas/add
    @PostMapping("/add")
    public ResponseEntity<NinjaModel> createNinja(@RequestBody NinjaModel ninja) {
       NinjaModel newNinja = service.createNinja(ninja);
       return new ResponseEntity<>(newNinja,HttpStatus.CREATED);
    }

    //METODO GET ALL
    //LINK: localhost:8080/api/ninjas/all
    @GetMapping("/all")
    public ResponseEntity <List<NinjaModel>> getAllNinjas() {
        List <NinjaModel> allNinjas = service.getAllNinjas();
        return new ResponseEntity<>(allNinjas, HttpStatus.OK);
    }

    //METODO GET BY ID
    //LINK: localhost:8080/api/ninjas/id
    @GetMapping("/{id}")
    public ResponseEntity<?> findNinjaById(@PathVariable Long id){
        Optional<NinjaModel> optionalNinja = service.findNinjaById(id);

        if(optionalNinja.isPresent()){
            return ResponseEntity.ok(optionalNinja.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id invalido");
        }
    }

    //METODO UPDATE NINJA
    //LINK: localhost:8080/api/ninjas/update/id
    @PutMapping("/update/{id}")
    public ResponseEntity <NinjaModel> updateNinja(@PathVariable Long id, @RequestBody NinjaModel ninja){

        try{
            NinjaModel ninjaUpdate = service.updateNinja(id, ninja);
            return new ResponseEntity<>(ninjaUpdate, HttpStatus.OK);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //METODO DELETE
    //LINK: LOCALHOST:8080/API/NINJAS/DELETE/1
    //TO DO: USAR OPTIONAL CASO O ID SEJA INVALIDO
    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id) {
       service.deleteNinja(id);
    }
}
