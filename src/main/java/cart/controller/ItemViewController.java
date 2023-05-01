package cart.controller;

import cart.controller.dto.ItemResponse;
import cart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemViewController {

    private final ItemService itemService;

    @Autowired
    public ItemViewController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String showItemList(final Model model) {
        List<ItemResponse> items = itemService.loadAllItem();
        model.addAttribute("products", items);
        return "index";
    }

    @GetMapping("/admin")
    public String showAdmin(final Model model) {
        List<ItemResponse> items = itemService.loadAllItem();
        model.addAttribute("products", items);
        return "admin";
    }
}