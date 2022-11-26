// package sh.surge.fulgure.fulgure_brasil.controller;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import sh.surge.fulgure.fulgure_brasil.model.Alternativas;
// import sh.surge.fulgure.fulgure_brasil.repository.AlternativasRepository;

// @CrossOrigin
// @RestController
// public class AlternativasController {
//     @Autowired
//     AlternativasRepository AlternativasRepository;

//     @GetMapping("/alternativas")
//     public List<Alternativas> recuperaAlternativas(){
//         return (List<Alternativas>) AlternativasRepository.findAll();
//     }

//     @GetMapping("/alternativas/{id}")
//     public Optional<Alternativas> RecuperaAlternativasPeloId(@PathVariable("id") Long id) {
//         return AlternativasRepository.findById(id);
//     }

//     @PostMapping("/alternativas")
//     public void adicionaAlternativas(@RequestBody Alternativas novasAlternativas){
//         AlternativasRepository.save(novasAlternativas);
//     }

//     @DeleteMapping("/alternativas/{id}") 
//     public void deletaAlternativas(@PathVariable("id") Long id){
//         AlternativasRepository.deleteById(id);
//     }

// }
