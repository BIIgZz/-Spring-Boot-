package com.zzh.sell.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zzh.sell.dataobject.ProductCategory;
import com.zzh.sell.dataobject.ProductInfo;
import com.zzh.sell.dto.OrderDTO;
import com.zzh.sell.exception.SellException;
import com.zzh.sell.form.ProductForm;
import com.zzh.sell.service.CategoryService;
import com.zzh.sell.service.ProductService;
import com.zzh.sell.utils.KeyUtils;
import lombok.Value;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.spec.PSSParameterSpec;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 14:47 2020/4/3
 * @Modified By:
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    /*
 * @Description:列表
 * @param: [page, size, map]
 * @return: org.springframework.web.servlet.ModelAndView
 */

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest request = PageRequest.of(page-1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);

        return  new ModelAndView("product/list",map);
    }

    /*
     * @Description:上架
     * @param: [id, map]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId")String id,
                               Map<String,Object>map){
        try {
            productService.onSale(id);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return  new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }
    /*
     * @Description:下架
     * @param: [id, map]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId")String id,
                               Map<String,Object>map){
        try {
            productService.offSale(id);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return  new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false)String productId,
                      Map<String,Object>map){
            if (!StringUtils.isEmpty(productId)){
                ProductInfo productInfo = productService.findOne(productId);
                map.put("productInfo",productInfo);
            }
            //查询所有类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index",map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index");
            return  new ModelAndView("common/error",map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productId是空的话。说明是新增
            if (!StringUtils.isEmpty(productForm.getProductId())){
                productInfo =productService.findOne(productForm.getProductId());
            }else {
                productForm.setProductId(KeyUtils.genUniqueKey());
            }
            BeanUtils.copyProperties(productForm,productInfo);
            productService.save(productInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/index");
            return  new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return  new ModelAndView("common/success",map);
    }
}
