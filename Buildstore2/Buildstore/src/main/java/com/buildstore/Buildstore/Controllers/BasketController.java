package com.buildstore.Buildstore.Controllers;

import com.buildstore.Buildstore.Models.Allmaterials;
import com.buildstore.Buildstore.Models.Basket;
import com.buildstore.Buildstore.Models.Data;
import com.buildstore.Buildstore.Repository.AllmaterialsRepository;
import com.buildstore.Buildstore.Repository.BasketRepository;
import com.buildstore.Buildstore.Repository.DataRepository;
import liquibase.pro.packaged.S;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BasketController {

    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private BasketRepository basketRepository;
    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private AllmaterialsRepository allmaterialsRepository;
    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private DataRepository dataRepository;
    @GetMapping("/")
    public String Choice(Model model) {
        return "Choice";
    }

    @GetMapping("/Basket")
    public String Basket(Model model) {
        Iterable<Basket> basket = basketRepository.findAll();
        model.addAttribute("basket", basket);//пердаем массив со всеми материалами
        return "Basket";
    }


    @PostMapping("/AllmaterialsOwner/{id}/basket")//код для  передачи данных из одной таблицы в другую
    public String materialBasket(@PathVariable(value = "id") long id, @RequestParam int quantity,String ownername2,String ownersurname2,String address2, String phone2, Model model) {
        Optional<Allmaterials> onematerial2 = allmaterialsRepository.findById(id);
        Allmaterials allmaterials = onematerial2.get();
        Basket basket = new Basket();
        basket.setName2(allmaterials.getName());
        basket.setCategories2(allmaterials.getCategories());
        basket.setBrand2(allmaterials.getBrand());
        basket.setCost2(allmaterials.getCost());
        basket.setQuantity(quantity);
        basket.setCostfordelivery(quantity*30);
        basket.setTotal(quantity*30+quantity* basket.getCost2());
        basket.setOwnername2(ownername2);
        basket.setOwnersurname2(ownersurname2);
        basket.setAddress2(address2);
        basket.setPhone2(phone2);
        basketRepository.save(basket);
        return "redirect:/Basket";

    }
    @PostMapping("/Basket/{id}/order")//код для  передачи данных из одной таблицы в другую
    public String materialBasket2(@PathVariable(value = "id") long id, Model model) {
        Optional<Basket> onematerialdelivery = basketRepository.findById(id);
        Basket basket = onematerialdelivery.get();
        Data data = new Data();
        data.setName3(basket.getName2());
        data.setCategories3(basket.getCategories2());
        data.setBrand3(basket.getBrand2());
        data.setCost3(basket.getCost2());
        data.setQuantity3(basket.getQuantity());
        data.setCostfordelivery3(basket.getCostfordelivery());
        data.setTotal3(basket.getTotal());
        data.setOwnername3(basket.getOwnername2());
        data.setOwnersurname3(basket.getOwnersurname2());
        data.setAddress3(basket.getAddress2());
        data.setPhone3(basket.getPhone2());
        dataRepository.save(data);
        return "Gratitude";
    }
    @PostMapping("/Basket/{id}/delete")//это код для удаления материала
    public String basketDelete2(@PathVariable(value = "id") long id, Model model) {
        Basket basket = basketRepository.findById(id).orElseThrow();//находим определенный материал
        basketRepository.delete(basket);
        return "redirect:/Basket";
    }
}