package sh.surge.fulgure.fulgure_brasil.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int vidas, pontos;
    private String nome, email, senha;

    @PrePersist
    void defaultValue() {
        vidas = 5;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario")
    @JsonManagedReference
    private List<Sugestao> sugestoes;

    public Usuario() {
    }

    public List<Sugestao> getSugestoes() {
        return sugestoes;
    }

    public void setSugestoes(List<Sugestao> sugestoes) {
        this.sugestoes = sugestoes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
