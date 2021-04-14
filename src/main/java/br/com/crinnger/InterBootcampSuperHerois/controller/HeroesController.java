package br.com.crinnger.InterBootcampSuperHerois.controller;

import br.com.crinnger.InterBootcampSuperHerois.constans.HeroesConstant;
import br.com.crinnger.InterBootcampSuperHerois.document.Heroes;
import br.com.crinnger.InterBootcampSuperHerois.repository.HeroesRepository;
import br.com.crinnger.InterBootcampSuperHerois.service.HeroesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HeroesController {

    private final HeroesService heroesService;
    private final HeroesRepository heroesRepository ;

    @PostConstruct
    private void criarTabelas(){
        heroesRepository.createTable();
    }

    @GetMapping(HeroesConstant.HEROES_ENDPOINT_LOCAL)
    public Flux<Heroes> getAllHeroes(){
        log.info("requisicao lista herois");
        return heroesService.findAll();
    }

    @GetMapping(HeroesConstant.HEROES_ENDPOINT_LOCAL+"/{id}")
    public Mono<ResponseEntity<Heroes>> findById(@PathVariable String id){
        log.info("requisicao heroi com id{}",id);
        return heroesService.findById(id)
                .map((item)-> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HeroesConstant.HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes hero){
        log.info("requisicao heroi criado " + hero.toString());
        return heroesService.save(hero);
    }

    @DeleteMapping(HeroesConstant.HEROES_ENDPOINT_LOCAL+"/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<HttpStatus> deleteById(@PathVariable String id){
        heroesService.deleteById(id);
        log.info("requisicao delete heroi com id{}",id);
        return Mono.just(HttpStatus.NO_CONTENT);
    }
}
