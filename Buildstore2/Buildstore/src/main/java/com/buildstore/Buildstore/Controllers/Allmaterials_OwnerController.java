package com.buildstore.Buildstore.Controllers;

import com.buildstore.Buildstore.Models.Allmaterials;
import com.buildstore.Buildstore.Repository.AllmaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class Allmaterials_OwnerController {

    //Работа над шаблоном для клиентов ювсе изменения которые водит прораб долно измняться и в шаблоне клиента
    @GetMapping("/OwnerHome")
    public String OwnerHome(Model model) {
        return "OwnerHome";//метод для вызова главной страницы клиента
    }

    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private AllmaterialsRepository allmaterialsRepository;

    @GetMapping("/Allmaterials_Owner")
    public String Allmaterials_Owner(Model model) {
        Iterable<Allmaterials> allmaterials = allmaterialsRepository.findAll();
        model.addAttribute("allmaterials2", allmaterials);//пердаем массив со всеми материалами
        return "Allmaterials_Owner";
    }


    @GetMapping("/Allmaterials_Owner/{id}")//код для более детального расмотрения товара
    public String materialsDetails(@PathVariable(value = "id") long id, Model model) {
        if (!allmaterialsRepository.existsById(id)) {
            return "redirect:/Allmaterials_Owner";
        }
        Optional<Allmaterials> onematerial = allmaterialsRepository.findById(id);
        ArrayList<Allmaterials> detail = new ArrayList<>();
        onematerial.ifPresent(detail::add);
        model.addAttribute("onematerial", detail);
        return "MaterialDetails_Owner";
    }

}