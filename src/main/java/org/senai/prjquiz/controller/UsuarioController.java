package org.senai.prjquiz.controller;

import java.util.Optional;

import org.senai.prjquiz.entity.Usuario;
import org.senai.prjquiz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioRepository qRepository;

    @PostMapping("/")
    public @ResponseBody Integer addQuiz(@RequestBody Usuario objQuiz) {
        qRepository.save(objQuiz);
        return objQuiz.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Usuario> buscarQuiz() {
        return qRepository.findAll();
    }

    @PutMapping("/")
    public @ResponseBody Usuario atualizarQuiz(@RequestBody Usuario objQuiz) {
        qRepository.save(objQuiz);
        return objQuiz;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagarQuiz(@PathVariable Integer id) {
        qRepository.deleteById(id);
        return "Ok ao apagar";
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Usuario> localizarQuiz(@PathVariable Integer id) {
        return qRepository.findById(id);
    }

}
