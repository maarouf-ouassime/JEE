package com.example.etudientapp.web;

import com.example.etudientapp.entities.Etudiant;
import com.example.etudientapp.repositories.EtudiantRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
@Controller @AllArgsConstructor
public class EtudiantController {
    EtudiantRepository etudiantRepository;
    @GetMapping(path = "/user/index")
    public String patients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "4")  int size,
                           @RequestParam(name = "keyword",defaultValue = "")  String keyword){
        Page<Etudiant> etudiantPage = etudiantRepository.findByNomContains(keyword,PageRequest.of(page, size));
        model.addAttribute("listEtudiants",etudiantPage.getContent());
        model.addAttribute("pages",new int[etudiantPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "Etudiants";
    }
    @GetMapping("/admin/delete")
    public String delete(Long id,String keyword,int page){
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/Eudiants")
    @ResponseBody
    public List<Etudiant> patientsList(){
        return etudiantRepository.findAll();
    }

    @GetMapping("/admin/formEtudiants")
    public String formPatients(Model model){
        model.addAttribute("etudiant",new Etudiant());
        return "formEtudiants";
    }
    @PostMapping("/admin/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if (bindingResult.hasErrors()) return "formEtudiants";
        etudiantRepository.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/editEtudiant")
    public String editPatient(Model model,Long id,int page,String keyword){
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant == null) throw new RuntimeException("Etudiant Introuvable");
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "editEtudiant";
    }
}
