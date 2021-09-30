package lexicon.jorgen.form_bindingpractice.controller;

import lexicon.jorgen.form_bindingpractice.DTO.CustomerDTO;
import lexicon.jorgen.form_bindingpractice.model.Customer;
import lexicon.jorgen.form_bindingpractice.model.CustomerDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CustomerController {

    List<Customer> listCustomer = new ArrayList<>();

    @GetMapping("/customer/create")
    public String getForm(Model model){

        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("form", customerDTO);
        return "customer-form";
    }

    @PostMapping("/customer/create/process")
    public String handleForm(@Valid @ModelAttribute(name="customer-form") CustomerDTO form, BindingResult result){

        System.out.println(form.toString());
        if(result.hasErrors()){
            return "customer-form";
        }

        CustomerDetails customerDetails = new CustomerDetails(
                UUID.randomUUID().toString(),
                form.getStreet(),
                form.getZipCode(),
                form.getCity(),
                form.getHomePhone(),
                form.getCellPhone()
                );

        Customer customer = new Customer(form.getEmail(), LocalDate.now(), customerDetails);

                if(!listCustomer.contains(customer)){
                    listCustomer.add(customer);
                }

        return "redirect:/customer/"+customer.getCustomerId();
    }

    @GetMapping("/customer/{id}")
    public String findById(@PathVariable(name="id") String id, Model model){
        Customer customer = listCustomer.stream()
                .filter(c -> c.getCustomerId().equals(id))
                .findFirst().orElseThrow();
        model.addAttribute("customer", customer);
        return "customer-view";

    }

}
