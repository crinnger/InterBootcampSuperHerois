package br.com.crinnger.InterBootcampSuperHerois.repository;
import java.io.IOException;

public interface HeroesCustomRepository {
        void createTable();
        void loadData() throws IOException;
}
