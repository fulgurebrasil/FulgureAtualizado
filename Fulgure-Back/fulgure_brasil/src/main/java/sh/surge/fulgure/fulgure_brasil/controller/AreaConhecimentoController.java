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

// import sh.surge.fulgure.fulgure_brasil.model.AreaConhecimento;
// import sh.surge.fulgure.fulgure_brasil.repository.AreaConhecimentoRepository;

// @CrossOrigin
// @RestController
// public class AreaConhecimentoController {
//     @Autowired
//     AreaConhecimentoRepository areaConhecimentoRepository;

//     @GetMapping("/areaConhecimento")
//     public List<AreaConhecimento> recuperaAreaConhecimento(){
//         return (List<AreaConhecimento>) areaConhecimentoRepository.findAll();
//     }

//     @GetMapping("/areaConhecimento/{id}")
//     public Optional<AreaConhecimento> RecuperaAreaConhecimentoPeloId(@PathVariable("id") Long id) {
//         return areaConhecimentoRepository.findById(id);
//     }

//     @PostMapping("/areaConhecimento")
//     public void adicionaAreaConhecimento(@RequestBody AreaConhecimento novaAreaConhecimento){
//         areaConhecimentoRepository.save(novaAreaConhecimento);
//     }

//     @DeleteMapping("/areaConhecimento/{id}") 
//     public void deletaAreaConhecimento(@PathVariable("id") Long id){
//         areaConhecimentoRepository.deleteById(id);
//     }

// }
