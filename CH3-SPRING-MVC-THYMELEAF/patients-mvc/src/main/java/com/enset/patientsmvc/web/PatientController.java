package com.enset.patientsmvc.web;

import com.enset.patientsmvc.entities.Patient;
import com.enset.patientsmvc.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller @AllArgsConstructor
public class PatientController {
    PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "4")  int size,
                           @RequestParam(name = "keyword",defaultValue = "")  String keyword){
        //Page<Patient> patientPages = patientRepository.findAll(PageRequest.of(page, size));
        Page<Patient> patientPages = patientRepository.findByNomContains(keyword,PageRequest.of(page, size));
        model.addAttribute("listPatients",patientPages.getContent());
        model.addAttribute("pages",new int[patientPages.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
    @GetMapping("/patients") @ResponseBody
    public List<Patient> patientsList(){
        return patientRepository.findAll();
    }
}
