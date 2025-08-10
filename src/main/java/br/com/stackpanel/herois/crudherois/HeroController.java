package br.com.stackpanel.herois.crudherois;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

// Classe aonde fica os meus endpoints
@RestController//Anotacao de classe que lida com requisicoes http
@RequestMapping("/api/herois")//usada para mapear a rota /api/herois
public class HeroController {

    private final HeroRepository repo;

    public HeroController(HeroRepository repo) {
        this.repo = repo;
    }

    @PutMapping("/atacar/{id}")
    public ResponseEntity<Map<String,String>> atacar(
            @Valid @RequestBody AtaqueRequest req,
            @PathVariable Long id

    ){
      Optional<Hero> opt = repo.findById(id);
      if (opt.isEmpty()){
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body(Map.of("mensagem", "O heroi nao esta no campo de batalha"));
      }

      Hero hero = opt.get();
      int valorAtaque = req.getValorAtaque();

      if (valorAtaque <= hero.getPoderDefesa()){
          return ResponseEntity.ok(Map.of("mensagem", "O heroi nao sofreu danos, tente novamente"));
      }

      int dano = valorAtaque - hero.getPoderDefesa();
      int novaVida = Math.max(0, hero.getVida() - dano);
      hero.setVida(novaVida);
      repo.save(hero);

      return  ResponseEntity.ok(Map.of("mensagem", "O heroi sofreu danos. Vida atual " + novaVida));

    }

    @PostMapping
    public ResponseEntity<Hero> cadastrar(@Valid @RequestBody HeroRequest req) {
        Hero hero = new Hero(req.getNomeHeroi(), req.getPoderAtaque(), req.getPoderDefesa(), req.getVida());
        Hero saved = repo.save(hero);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Hero> listar(
            @RequestParam(required = false) String nomeHeroi,
            @RequestParam(required = false) Integer poderAtaque,
            @RequestParam(required = false) Integer poderDefesa
    ) {
        if (nomeHeroi != null && poderAtaque != null) {
            return repo.findByNomeHeroiContainingIgnoreCaseAndPoderAtaque(nomeHeroi, poderAtaque);
        }
        if (nomeHeroi != null) {
            return repo.findByNomeHeroiContainingIgnoreCase(nomeHeroi);
        }
        if (poderAtaque != null) {
            return repo.findByPoderAtaque(poderAtaque);
        }
        if (poderDefesa != null) {
            return repo.findByPoderDefesa(poderDefesa);
        }

        // Se nenhum filtro foi passado, retorna todos
        return repo.findAll();
    }




}
