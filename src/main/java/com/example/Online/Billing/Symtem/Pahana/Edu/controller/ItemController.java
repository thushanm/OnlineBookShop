package com.example.Online.Billing.Symtem.Pahana.Edu.controller;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.ItemDTO;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String viewItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "view-items";
    }

    @GetMapping("/add")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new ItemDTO());
        return "add-item";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String showEditItemForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "edit-item";
    }

    @PostMapping("/edit/{id}")
    public String updateItem(@PathVariable("id") Long id, @ModelAttribute("item") ItemDTO itemDTO) {
        itemDTO.setId(id);
        itemService.saveItem(itemDTO);
        return "redirect:/items";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }
}
