package br.edu.infnet.SpringMVCPU.AppController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.service.AlunoService;
import java.util.List;

@Controller
public class AppController {
	
    @Autowired
    private AlunoService alunoService;
	
    @RequestMapping("/cadastro")
    public String cadastro(Model model) 
    {
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "cadastro";
    }
    
    @RequestMapping("/cadastrar")
    public String cadastrar(Model model, Aluno aluno) {
    	alunoService.salvar(aluno);
        return "redirect:/";
    }
    
    @RequestMapping("/")
    public String consulta(Model model) {
    	model.addAttribute("lista", alunoService.consultar());
        return "consulta";
    }
    
    @RequestMapping("excluir")
    public String excluir(@RequestParam int id) {
    	alunoService.excluir(id);
            return "redirect:/";
    }
    
    @RequestMapping("alterar")
    public ModelAndView alterar(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("alterar");
        Aluno aluno = alunoService.consultarPorID(id);
        mav.addObject("aluno", aluno);
        return mav;
    }
    
    @RequestMapping(value = "salvaraluno", method = RequestMethod.POST)
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
    	alunoService.salvar(aluno);
        return "redirect:/";
    }
    
    @RequestMapping("procurar")
    public ModelAndView procura(@RequestParam String keyword) {
        List<Aluno> result = alunoService.procurar(keyword);
        ModelAndView mav = new ModelAndView("procura");
        mav.addObject("result", result);
        return mav;
    }
}