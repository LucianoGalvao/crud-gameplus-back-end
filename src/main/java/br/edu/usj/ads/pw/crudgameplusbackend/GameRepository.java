package br.edu.usj.ads.pw.crudgameplusbackend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAll();
}