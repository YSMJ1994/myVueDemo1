package controller;

import org.springframework.web.servlet.ModelAndView;
import po.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建自: Sober 时间: 2016/12/2.
 */
public class ItemController1 implements org.springframework.web.servlet.mvc.Controller {
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        List<Items> itemsList = new ArrayList<Items>();
        Items items1 = new Items();
        items1.setItem_name("镜子");
        items1.setPrice(20);
        Items items2 = new Items();
        items2.setItem_name("梳子");
        items2.setPrice(10);
        itemsList.add(items1);
        itemsList.add(items2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }
}
