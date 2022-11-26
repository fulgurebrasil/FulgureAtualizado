// package sh.surge.fulgure.fulgure_brasil.model;

// import java.util.List;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.ManyToMany;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// @Entity
// public class AreaConhecimento {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private Long id;
//     private String descricao;

//     @ManyToMany(mappedBy = "areaConhecimento")
//     @JsonBackReference
//     private List<Questao> questoes;

//     public AreaConhecimento() {

//     }

//     public List<Questao> getQuestoes() {
//         return questoes;
//     }

//     public void setQuestoes(List<Questao> questoes) {
//         this.questoes = questoes;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getDescricao() {
//         return descricao;
//     }

//     public void setDescricao(String descricao) {
//         this.descricao = descricao;
//     }
// }
