package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.negocio.Aluno;
import br.edu.infnet.springmvc.model.repository.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {

    @RequestMapping("")
    public String consulta(Model model) {
        AlunoRepository ar = new AlunoRepository();

        model.addAttribute("lista", ar.consulta());
        return "consulta";
    }
    
    @RequestMapping("cadastro")
    public String cadastro(Model model) {
        
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "cadastro";
    }
    
    @RequestMapping("cadastrar")
    public String cadastrar(Model model, Aluno aluno) {
        AlunoRepository ar = new AlunoRepository();
        
        ar.incluir(aluno);
        return "redirect:/";
    }
    
    @RequestMapping("excluir")
    public String excluir(@RequestParam int id) {
        AlunoRepository ar = new AlunoRepository();
     
        ar.excluir(id);
        return "redirect:/";
    }
    
    @RequestMapping("alterar")
    public ModelAndView alterar(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("alterar");
        AlunoRepository ar = new AlunoRepository();
        Aluno aluno = ar.consultarPorId(id);
        
        mav.addObject(aluno);
        return mav;
        
    }
    
    @RequestMapping(value="salvaraluno", method=RequestMethod.POST)
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
        AlunoRepository ar = new AlunoRepository();
        
        ar.alterar(aluno);
        return "redirect:/";
    }
}
