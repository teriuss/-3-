package com.buildstore.Buildstore.Controllers;

import com.buildstore.Buildstore.Models.Allmaterials;
import com.buildstore.Buildstore.Models.Basket;
import com.buildstore.Buildstore.Models.Data;
import com.buildstore.Buildstore.Models.OrderedMaterials;
import com.buildstore.Buildstore.Repository.AllmaterialsRepository;
import com.buildstore.Buildstore.Repository.BasketRepository;
import com.buildstore.Buildstore.Repository.DataRepository;
import com.buildstore.Buildstore.Repository.OrderedMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class Delivery_Material {
    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private BasketRepository basketRepository;
    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private AllmaterialsRepository allmaterialsRepository;
    @Autowired//для того чтобы ссылать на аннотацию которую мы создали для передачи и манипуляции данными
    private DataRepository dataRepository;
    @Autowired
    private OrderedMaterialRepository orderedMaterialRepository;
    @GetMapping("/DeliveryHome")
    public String deliveryhome(Model model) {
        return "DeliveryHome";
    }
    @GetMapping("/EnterDelivery")
    public String enterdelivery(Model model) {
        return "EnterDelivery";
    }


    @GetMapping("/Delivery_Materials")
    public String Delivery_Material(Model model) {
        Iterable<Data> data = dataRepository.findAll();
        model.addAttribute("data", data);//пердаем массив со всеми материалами
        return "Delivery_Materials";
    }
    @PostMapping("/Delivery/{id}/delete")//это код для удаления материала
    public String materialsDelete(@PathVariable(value = "id") long id, Model model) {
       Data Deliveryordered = dataRepository.findById(id).orElseThrow();//находим определенный материал
        dataRepository.delete(Deliveryordered );
        return "redirect:/Delivery_Materials";
    }
    @PostMapping("/Delivery/{id}/end")//код для  передачи данных из одной таблицы в другую
    public String materialBasket2(@PathVariable(value = "id") long id, Model model) {
        Optional<Data> onematerialdelivery2 = dataRepository.findById(id);
        Data data = onematerialdelivery2.get();
        OrderedMaterials orderedMaterials = new OrderedMaterials();
        orderedMaterials.setCostfordelivery4(data.getCostfordelivery3());
        orderedMaterials.setTotal4(data.getTotal3());
        orderedMaterials.setOwnername4(data.getOwnername3());
        orderedMaterials.setOwnersurname4(data.getOwnersurname3());
        orderedMaterialRepository.save(orderedMaterials);
        return "redirect:/Delivery_Materials";
    }
    @GetMapping("/Salary")
    public String Salary(Model model) {
        Iterable<OrderedMaterials> orderedMaterials = orderedMaterialRepository.findAll();
        model.addAttribute("orderedMaterials", orderedMaterials);//пердаем массив со всеми материалами
        return "Salary";
    }
    @PostMapping("/Salary/{id}/delete")//это код для удаления материала
    public String SalaryDelete(@PathVariable(value = "id") long id, Model model) {
        OrderedMaterials orderedMaterials2= orderedMaterialRepository.findById(id).orElseThrow();//находим определенный материал
        orderedMaterialRepository.delete(orderedMaterials2);
        return "redirect:/Salary";
    }
}
