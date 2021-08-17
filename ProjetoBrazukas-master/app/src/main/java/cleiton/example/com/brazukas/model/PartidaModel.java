package cleiton.example.com.brazukas.model;

/**
 * Created by Cleiton on 09/10/2017.
 */

public class PartidaModel {
    private Integer partida_id;
    private Integer clube_casa_id;
    private Integer clube_casa_posicao;
    private Integer clube_visitante_id;
    private String[] aproveitamento_mandante;
    private String[] aproveitamento_visitante;
    private Integer clube_visitante_posicao;
    private String partida_data;
    private String local;
    private boolean valida;
    private String placar_oficial_mandante;
    private String placar_oficial_visitante;
    private String url_confronto;
    private String url_transmissao;

    public Integer getPartida_id() {
        return partida_id;
    }

    public void setPartida_id(Integer partida_id) {
        this.partida_id = partida_id;
    }

    public Integer getClube_casa_id() {
        return clube_casa_id;
    }

    public void setClube_casa_id(Integer clube_casa_id) {
        this.clube_casa_id = clube_casa_id;
    }

    public Integer getClube_casa_posicao() {
        return clube_casa_posicao;
    }

    public void setClube_casa_posicao(Integer clube_casa_posicao) {
        this.clube_casa_posicao = clube_casa_posicao;
    }

    public Integer getClube_visitante_id() {
        return clube_visitante_id;
    }

    public void setClube_visitante_id(Integer clube_visitante_id) {
        this.clube_visitante_id = clube_visitante_id;
    }

    public String[] getAproveitamento_mandante() {
        return aproveitamento_mandante;
    }

    public void setAproveitamento_mandante(String[] aproveitamento_mandante) {
        this.aproveitamento_mandante = aproveitamento_mandante;
    }

    public String[] getAproveitamento_visitante() {
        return aproveitamento_visitante;
    }

    public void setAproveitamento_visitante(String[] aproveitamento_visitante) {
        this.aproveitamento_visitante = aproveitamento_visitante;
    }

    public Integer getClube_visitante_posicao() {
        return clube_visitante_posicao;
    }

    public void setClube_visitante_posicao(Integer clube_visitante_posicao) {
        this.clube_visitante_posicao = clube_visitante_posicao;
    }

    public String getPartida_data() {
        return partida_data;
    }

    public void setPartida_data(String partida_data) {
        this.partida_data = partida_data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public String getPlacar_oficial_mandante() {
        return placar_oficial_mandante;
    }

    public void setPlacar_oficial_mandante(String placar_oficial_mandante) {
        this.placar_oficial_mandante = placar_oficial_mandante;
    }

    public String getPlacar_oficial_visitante() {
        return placar_oficial_visitante;
    }

    public void setPlacar_oficial_visitante(String placar_oficial_visitante) {
        this.placar_oficial_visitante = placar_oficial_visitante;
    }

    public String getUrl_confronto() {
        return url_confronto;
    }

    public void setUrl_confronto(String url_confronto) {
        this.url_confronto = url_confronto;
    }

    public String getUrl_transmissao() {
        return url_transmissao;
    }

    public void setUrl_transmissao(String url_transmissao) {
        this.url_transmissao = url_transmissao;
    }
}
