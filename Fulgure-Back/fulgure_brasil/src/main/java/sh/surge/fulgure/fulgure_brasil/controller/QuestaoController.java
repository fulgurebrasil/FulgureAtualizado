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

import sh.surge.fulgure.fulgure_brasil.model.Questao;
import sh.surge.fulgure.fulgure_brasil.repository.QuestaoRepository;

@CrossOrigin
@RestController
public class QuestaoController {
    @Autowired
    QuestaoRepository questaoRepository;

    @GetMapping("/questao")
    public List<Questao> recuperaQuestoes() {
        return (List<Questao>) questaoRepository.findAll();
    }

    @GetMapping("/questao/{id}")
    public Optional<Questao> RecuperaQuestaoPeloId(@PathVariable("id") Long id) {
        return questaoRepository.findById(id);
    }

    @PostMapping("/questao")
    public void adicionaQuestao(@RequestBody Questao novaQuestao) {
        questaoRepository.save(novaQuestao);
    }

    @DeleteMapping("/questao/{id}")
    public void deletaUsuario(@PathVariable("id") Long id) {
        questaoRepository.deleteById(id);
    }

}
