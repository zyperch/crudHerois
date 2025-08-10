package br.com.stackpanel.herois.crudherois;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

// Classe para atacar o heroi
public class AtaqueRequest {
    @NotNull @Min(value = 1, message = "valorAtaque deve ser > 0")
    private Integer valorAtaque;

    public AtaqueRequest() {}

    public Integer getValorAtaque() {
        return valorAtaque;
    }

    public void setValorAtaque(Integer valorAtaque) {
        this.valorAtaque = valorAtaque;
    }



}
