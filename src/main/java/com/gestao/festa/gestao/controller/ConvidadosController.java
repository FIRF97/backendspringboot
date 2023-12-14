package com.gestao.festa.gestao.controller;

import com.gestao.festa.gestao.model.Convidado;
import com.gestao.festa.gestao.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/api")
public class ConvidadosController {

    @Autowired
    ConvidadoRepository repository;

    @GetMapping(value={"/convidados", "/", ""})
    public ModelAndView lista(){
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        modelAndView.addObject("convidados", repository.findAllOrderByNome());
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public String registroForm(){
        return "RegistroFormulario";
    }

    @PostMapping("/registro_convidado")
    public String registroForm(@ModelAttribute("convidado") Convidado convidado){
        repository.save(convidado);
        return "redirect:/api/convidados";
    }

    @GetMapping("/api/remover/{id}")
    public String deleteForm(@PathVariable(value="id") Long id){
        System.out.println("Recebida solicitação DELETE para o ID: " + id);
        repository.deleteById(id);
        return "redirect:/api/convidados";  // Use o redirecionamento correto para a página desejada
    }
}
