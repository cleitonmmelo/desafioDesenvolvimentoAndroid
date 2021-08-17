package cleiton.example.com.brazukas.model;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Cleiton on 09/10/2017.
 */

public class ClubeModel {
    private Integer id;
    private String nome;
    private String abreviacao;
    private Integer posicao;
    private HashMap<String, String> escudos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public HashMap<String, String> getEscudos() {
        return escudos;
    }

    public void setEscudos(HashMap<String, String> escudos) {
        this.escudos = escudos;
    }
}
