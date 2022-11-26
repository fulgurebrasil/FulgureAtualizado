package sh.surge.fulgure.fulgure_brasil.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comando, curiosidade, dica, resposta, areaConhecimento;
    private int pontuacao;
    private ArrayList alternativas = new ArrayList();

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_alternativas") // tabela submissa
    // // @JsonManagedReference
    // private Alternativas alternativas;

    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(name = "associacao_questao_areaConhecimento", joinColumns = @JoinColumn(name = "fk_questao"), inverseJoinColumns = @JoinColumn(name = "fk_areaConhecimento"))
    // // @JsonManagedReference
    // private List<AreaConhecimento> areaConhecimento;

    public Questao() {
    }

    // public List<AreaConhecimento> getAreaConhecimento() {
    //     return areaConhecimento;
    // }

    // public void setAreaConhecimento(List<AreaConhecimento> areaConhecimento) {
    //     this.areaConhecimento = areaConhecimento;
    // }

    // public Alternativas getAlternativas() {
    //     return alternativas;
    // }

    // public void setAlternativas(Alternativas alternativas) {
    //     this.alternativas = alternativas;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getComando() {
        return comando;
    }

    public String getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(String areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getCuriosidade() {
        return curiosidade;
    }

    public void setCuriosidade(String curiosidade) {
        this.curiosidade = curiosidade;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    // public int getTempo() {
    //     return tempo;
    // }

    // public void setTempo(int tempo) {
    //     this.tempo = tempo;
    // }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ArrayList getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList alternativas) {
        this.alternativas = alternativas;
    }

}
