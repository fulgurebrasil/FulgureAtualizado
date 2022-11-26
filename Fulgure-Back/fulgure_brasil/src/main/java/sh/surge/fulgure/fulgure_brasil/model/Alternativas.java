// package sh.surge.fulgure.fulgure_brasil.model;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToOne;

// import com.fasterxml.jackson.annotation.JsonBackReference;


// @Entity
// public class Alternativas {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private Long id;

//     private String a, b, c, d, e;

//     @OneToOne(mappedBy = "alternativas") // campo alternativas dentro da tabela Questão
//     @JsonBackReference
//     private Questao questao;

//     public Alternativas() {
//     }

//     public Questao getQuestao() {
//         return questao;
//     }

//     public void setQuestao(Questao questao) {
//         this.questao = questao;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getA() {
//         return a;
//     }

//     public void setA(String a) {
//         this.a = a;
//     }

//     public String getB() {
//         return b;
//     }

//     public void setB(String b) {
//         this.b = b;
//     }

//     public String getC() {
//         return c;
//     }

//     public void setC(String c) {
//         this.c = c;
//     }

//     public String getD() {
//         return d;
//     }

//     public void setD(String d) {
//         this.d = d;
//     }

//     public String getE() {
//         return e;
//     }

//     public void setE(String e) {
//         this.e = e;
//     }

// }
