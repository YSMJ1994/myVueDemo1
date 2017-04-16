package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import po.Items;
import service.ItemService;

import java.util.List;

/**
 * 创建自: Sober 时间: 2016/12/2.
 */
@Controller
public class ItemController2 {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception{
        List<Items> itemsList = itemService.queryItemsByName("椅子");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }
}
