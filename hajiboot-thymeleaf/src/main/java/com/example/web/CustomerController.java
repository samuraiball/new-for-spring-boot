package com.example.web;

import com.example.domain.Customer;
import com.example.domain.User;
import com.example.service.CustomerService;
import com.example.service.LoginUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //Formの初期化、@RequestMappingでマッピングされたメソッドの前に実行され
    //返り値は自動でモデルに追加される。
    @ModelAttribute
    CustomerForm setUpForm() {
        return new CustomerForm();
    }

    @GetMapping
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @PostMapping(path = "create")
        //Validatedアノテーションが評価された後に隣のBindingResultに結果が格納される。
    String create(@Validated CustomerForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {

        if (result.hasErrors()) {
            return list(model);
        }
        Customer customer = new Customer();

        //フィールド名が同じものの場合につかえるBean変換
        //より柔軟なものにはDozerやModelMapperが存在する。
        BeanUtils.copyProperties(form, customer);
        customerService.create(customer, userDetails.getUser());
        return "redirect:/customers";
    }

    @GetMapping(path = "edit", params = "form")
    String edit(@RequestParam Integer id, CustomerForm form) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(customer, form);
        return "customers/edit";
    }

    @PostMapping(path = "edit")
    String editForm(@RequestParam Integer id, @Validated CustomerForm form,
                    @AuthenticationPrincipal LoginUserDetails userDetails) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(form, customer);
        customer.setId(id);
        customerService.update(customer,userDetails.getUser());
        return "redirect:/customers";
    }

    @PostMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/customers";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
