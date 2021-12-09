package by.gsu.pms.idz_12.controllers;

import by.gsu.pms.idz_12.model.Order;
import by.gsu.pms.idz_12.model.OrderState;
import by.gsu.pms.idz_12.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository repository;

    @GetMapping("/new")
    public String formNew(Model model) {
        model.addAttribute("order", new Order());
        return "orders/new";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(Model model, @PathVariable("id") long id) {
        model.addAttribute("order", repository.findById(id).orElseThrow(
                () -> new RuntimeException("Order for id = " + id + " not found")));
        return "orders/edit";
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("orders", repository.findAll());
        return "orders/all";
    }

    @PostMapping()
    public String create(@ModelAttribute("order") Order order) {
        order.setState(OrderState.READY);
        repository.save(order);
        return "redirect:/orders";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("order") Order order) {
        Order oldOrder = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Order for id = " + id + " not found"));
        if(!OrderState.DELIVERED.equals(oldOrder.getState()) && OrderState.DELIVERED.equals(order.getState())){
            order.setDeliveryTime(LocalDateTime.now());
        }
        repository.save(order);
        return "redirect:/orders/" + id;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("order", repository.findById(id).orElseThrow(
                () -> new RuntimeException("Order for id = " + id + " not found")));
        return "orders/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        System.out.println("delete");
        repository.delete(repository.findById(id).orElseThrow(
                () -> new RuntimeException("Order for id = " + id + " not found")));
        return "redirect:/orders";
    }

    @ModelAttribute("orderStates")
    public List<OrderState> getOrderStates(){
        return OrderState.ALL;
    }
}
