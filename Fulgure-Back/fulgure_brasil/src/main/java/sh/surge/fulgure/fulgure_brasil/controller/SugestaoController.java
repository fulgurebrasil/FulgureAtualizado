package sh.surge.fulgure.fulgure_brasil.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sh.surge.fulgure.fulgure_brasil.model.Sugestao;
import sh.surge.fulgure.fulgure_brasil.repository.SugestaoRepository;

@CrossOrigin
@RestController
public class SugestaoController {
    @Autowired
    SugestaoRepository sugestaoRepository;

    @GetMapping("/sugestao")
    public List<Sugestao> recuperaSugestao(){
        return (List<Sugestao>) sugestaoRepository.findAll();
    }

    @GetMapping("/sugestao/{id}")
    public Optional<Sugestao> recuperaSugestaoPeloId(@PathVariable("id") Long id) {
        return sugestaoRepository.findById(id);
    }

    @PostMapping("/sugestao")
    public void adicionaSugestao(@RequestBody Sugestao novaSugestao){
        sugestaoRepository.save(novaSugestao);
    }

    @DeleteMapping("/sugestao/{id}") 
    public void deletaSugestao(@PathVariable("id") Long id){
        sugestaoRepository.deleteById(id);
    }

}
