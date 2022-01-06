package com.buildstore.Buildstore.Controllers;

import com.buildstore.Buildstore.Models.Allmaterials;
import com.buildstore.Buildstore.Models.Data;
import com.buildstore.Buildstore.Repository.AllmaterialsRepository;
import com.buildstore.Buildstore.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AllmaterialsProrabController {
    @GetMapping("/ProrabHome")
    public String ProrabHome(Model model) {
        return "ProrabHome";
    }
    @GetMapping("/EnterProrab")
    public String Prorabenter(Model model) {
        return "EnterProrab";
    }
    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private AllmaterialsRepository allmaterialsRepository;
    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private DataRepository dataRepository;
    @GetMapping("/AllmaterialsProrab")
    public String AllmaterialsProrab(Model model) {
        Iterable<Allmaterials> allmaterials = allmaterialsRepository.findAll();
        model.addAttribute("allmaterials2", allmaterials);//пердаем массив со всеми материалами
        return "AllmaterialsProrab";
    }
    @PostMapping("/ProrabHome")//код для передачи данных через сайт в  список allmaterials
    public String addmaterials(@RequestParam String name, String categories, String brand, int cost, Model model) {
        Allmaterials material = new Allmaterials(name, categories, brand, cost);
        allmaterialsRepository.save(material);
        return "redirect:/AllmaterialsProrab";

    }

    @GetMapping("/AllmaterialsProrab/{id}")//код для более детального расмотрения товара
    public String materialsDetails(@PathVariable(value = "id") long id, Model model) {
        if (!allmaterialsRepository.existsById(id)) {
            return "redirect:/AllmaterialsProrab";
        }
        Optional<Allmaterials> onematerial = allmaterialsRepository.findById(id);
        ArrayList<Allmaterials> detail = new ArrayList<>();
        onematerial.ifPresent(detail::add);
        model.addAttribute("onematerial", detail);
        return "MaterialDetails";
    }

    @GetMapping("/AllmaterialsProrab/{id}/edit")
//код для редактирования данных т.е оно позволить обрабатывать уже существующие данные
    public String materialsEdit(@PathVariable(value = "id") long id, Model model) {
        if (!allmaterialsRepository.existsById(id)) {
            return "redirect:/AllmaterialsProrab";
        }
        Optional<Allmaterials> onematerial = allmaterialsRepository.findById(id);

        ArrayList<Allmaterials> detail = new ArrayList<>();
        onematerial.ifPresent(detail::add);
        model.addAttribute("onematerial", detail);
        return "MaterialEdit";
    }

    @PostMapping("/AllmaterialsProrab/{id}/edit")//код для  изменения материала
    public String materialsUpdate(@PathVariable(value = "id") long id, @RequestParam String name, String categories, String brand, int cost, Model model) {
        Allmaterials onematerial = allmaterialsRepository.findById(id).orElseThrow();
        onematerial.setName(name);
        onematerial.setCategories(categories);
        onematerial.setBrand(brand);
        onematerial.setCost(cost);
        allmaterialsRepository.save(onematerial);

        return "redirect:/AllmaterialsProrab";
    }
    @PostMapping("/AllmaterialsProrab/{id}/remove")//это код для удаления материала
    public String materialsDelete(@PathVariable(value = "id") long id, Model model) {
        Allmaterials onematerial = allmaterialsRepository.findById(id).orElseThrow();//находим определенный материал
        allmaterialsRepository.delete(onematerial);
        return "redirect:/AllmaterialsProrab";
    }
    @GetMapping("/Delivery_End_Prorab")
    public String Delivery_End_Prorab(Model model) {
        Iterable<Data> data = dataRepository.findAll();
        model.addAttribute("data", data);//пердаем массив со всеми материалами
        return "Delivery_End_Prorab";
    }


}
