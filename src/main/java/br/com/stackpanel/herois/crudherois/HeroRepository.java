package br.com.stackpanel.herois.crudherois;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    // Busca por parte do nome (case-insensitive)
    List<Hero> findByNomeHeroiContainingIgnoreCase(String nomeHeroi);

    // Busca por poder de ataque exato
    List<Hero> findByPoderAtaque(int poderAtaque);

    // Busca por defesa exata
    List<Hero> findByPoderDefesa(int poderDefesa);

    // Busca combinando nome e poder de ataque
    List<Hero> findByNomeHeroiContainingIgnoreCaseAndPoderAtaque(String nomeHeroi, int poderAtaque);
}
