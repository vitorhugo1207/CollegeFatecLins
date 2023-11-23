package br.edu.fatec.lins.apiVitrine.Controlador;

import br.edu.fatec.lins.apiVitrine.dto.ProdutoDTO;
import br.edu.fatec.lins.apiVitrine.dto.SecaoDTO;
import br.edu.fatec.lins.apiVitrine.modelo.loja.Produto;
import br.edu.fatec.lins.apiVitrine.modelo.loja.Secao;
import br.edu.fatec.lins.apiVitrine.repositorio.ProdutoRepositorio;
import br.edu.fatec.lins.apiVitrine.repositorio.SecaoRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecaoController {
    @Autowired
    SecaoRepositorio repositorio;

    @PostMapping("/secoes")
    public ResponseEntity<Secao> salvarProduto(@RequestBody SecaoDTO secaoDTO){
        var secaoModelo = new Secao();
        BeanUtils.copyProperties(secaoDTO, secaoModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(secaoModelo));
    }
}
