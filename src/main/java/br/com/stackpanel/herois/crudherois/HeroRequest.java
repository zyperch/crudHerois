package br.com.stackpanel.herois.crudherois;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Classe para a criacao do heroi com validacoes
public class HeroRequest {
    @NotBlank(message = "nomeHeroi nao pode ser vazio")
    private String nomeHeroi;

    @NotNull @Min(value = 1, message = "poderAtaque deve ser > 0 ")
    private Integer poderAtaque;

    @NotNull @Min(value = 1, message = "poderDefesa deve ser > 0 ")
    private Integer poderDefesa;

    @NotNull @Min(value = 1, message = "vida deve ser > 0")
    private Integer vida;

    public HeroRequest() {}

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public Integer getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(Integer poderAtaque) {
        this.poderAtaque = poderAtaque;
    }

    public Integer getPoderDefesa() {
        return poderDefesa;
    }

    public void setPoderDefesa(Integer poderDefesa) {
        this.poderDefesa = poderDefesa;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }
}
