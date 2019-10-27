package cn.kgc.controller;

import cn.kgc.domain.Product;
import cn.kgc.domain.Takeout;
import cn.kgc.service.ProductService;
import cn.kgc.service.TakeoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/page/")
public class TakeoutController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TakeoutService takeoutService;

    @RequestMapping("getProduct")
    public ModelAndView getProduct(ModelAndView mv, HttpSession session){
        List<Product> productList = productService.getProductAll();
        session.setAttribute("productList",productList);
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("takeout")
    public ModelAndView takeout(ModelAndView mv, Takeout takeout){
        takeout.setOutdate(new Date());
        boolean b = takeoutService.addTakeout(takeout);
        if (b){
            mv.addObject("xx","t");
            mv.setViewName("main");
        }else {
            mv.addObject("xx","f");
            mv.addObject("take",takeout);
            mv.setViewName("main");
        }
        return mv;
    }

    @RequestMapping("searchQuantity")
    @ResponseBody
    public Map<String,Object> searchQuantity(Integer id,Integer quantity){
        Integer i = takeoutService.SearchQuantity(id);
        Map<String,Object> map =new HashMap<>();
        if (i-quantity>=0){
            map.put("msg","库存充足");
            return map;
        }else {
            map.put("msg","所选商品库存不足,库存量为"+i);
            return map;
        }
    }
}
