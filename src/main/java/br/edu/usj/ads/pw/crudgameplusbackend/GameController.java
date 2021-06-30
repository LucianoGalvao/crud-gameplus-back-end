package br.edu.usj.ads.pw.crudgameplusbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@ResponseBody
@CrossOrigin
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping(value = "/")
    public List<Game> getListarTodos() {
        List<Game> lista = gameRepository.findAll();
        return lista;
    }

    @GetMapping(value = "/detalhes/{id}")
    public Game getDetalhes(@PathVariable Long id) {
        Game game = new Game();
        game = gameRepository.findById(id).get();
        return game;
    }

    @PostMapping(value = "/adicionar")
    public Game postAdicionar(@RequestBody Game game) {
        Game gameNovo = gameRepository.save(game);
        return gameNovo;
    }

    @GetMapping(value = "/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        gameRepository.deleteById(id);
        return "Registro deletado com sucesso!";
    }

}
