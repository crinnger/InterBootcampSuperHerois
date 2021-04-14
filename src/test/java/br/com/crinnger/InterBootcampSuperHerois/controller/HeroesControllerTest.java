package br.com.crinnger.InterBootcampSuperHerois.controller;

import br.com.crinnger.InterBootcampSuperHerois.constans.HeroesConstant;
import br.com.crinnger.InterBootcampSuperHerois.document.Heroes;
import br.com.crinnger.InterBootcampSuperHerois.repository.HeroesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    HeroesRepository heroesRepository;

    @Test
    void getByIdNotFound() {
        webTestClient.get().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL.concat("/{id}"),"10")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void getByIdOneHero() {
        webTestClient.get().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL.concat("/{id}"),"2")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Heroes.class);
    }

    @Test
    void findAllHeroes() {
        webTestClient.get().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL)
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    void createHero() {
        Heroes heroes = Heroes.builder()
                .id("9")
                .name("Shazam")
                .universe("DC")
                .films(1)
                .build();

        webTestClient.post().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL)
                .body(Mono.just(heroes),Heroes.class)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Heroes.class);
    }

    @Test
    void deleteById() {
        webTestClient.delete().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL.concat("/{id}"),"9")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNoContent()
                .expectBody(Void.class);
    }
}