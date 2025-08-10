package br.com.stackpanel.herois.crudherois;

import jakarta.persistence.*;

//Entidades (Tabelas banco)
@Entity
@Table(name = "herois")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeHeroi;

    @Column(nullable = false)
    private int poderAtaque;

    @Column(nullable = false)
    private int poderDefesa;

    @Column(nullable = false)
    private int vida;

    public Hero(){}

    public Hero(String nomeHeroi, int poderAtaque, int poderDefesa, int vida) {
        this.nomeHeroi = nomeHeroi;
        this.poderAtaque = poderAtaque;
        this.poderDefesa = poderDefesa;
        this.vida = vida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(int poderAtaque) {
        this.poderAtaque = poderAtaque;
    }

    public int getPoderDefesa() {
        return poderDefesa;
    }

    public void setPoderDefesa(int poderDefesa) {
        this.poderDefesa = poderDefesa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
