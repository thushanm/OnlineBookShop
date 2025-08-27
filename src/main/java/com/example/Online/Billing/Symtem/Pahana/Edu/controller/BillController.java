package com.example.Online.Billing.Symtem.Pahana.Edu.controller;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.BillDTO;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.BillService;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private CustomerService customerService;

    // CHANGE THIS LINE
    @GetMapping("") // Explicitly map to the root of /bills
    public String viewBills(Model model) {
        model.addAttribute("bills", billService.getAllBills());
        return "view-bills";
    }

    @GetMapping("/create")
    public String showCreateBillForm(Model model) {
        model.addAttribute("bill", new BillDTO());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "create-bill";
    }

    @PostMapping("/create")
    public String createBill(@ModelAttribute("bill") BillDTO billDTO) {
        billService.createAndSaveBill(billDTO);

        return "redirect:/bills";
    }
}
