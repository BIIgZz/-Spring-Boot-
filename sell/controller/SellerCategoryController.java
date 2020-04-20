package com.zzh.sell.controller;

import com.zzh.sell.dataobject.ProductCategory;
import com.zzh.sell.exception.SellException;
import com.zzh.sell.form.CategoryForm;
import com.zzh.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 15:12 2020/4/20
 * @Modified By:
 */
@Controller
@RequestMapping("seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

/*
 * @Description:分类列表
 * @param: [map]
 * @return: org.springframework.web.servlet.ModelAndView
 */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("category/list",map);
    }

    /*
     * @Description:修改分类
     * @param: [categoryId, map]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId" ,required = false) Integer categoryId,
                              Map<String,Object> map){
        if (categoryId!=null){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }
        return new ModelAndView("category/index",map);
    }

    /*
     * @Description:保存分类
     * @param: [categoryForm, bindingResult, map]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm,
                             BindingResult bindingResult,
                             Map<String ,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return  new ModelAndView("common/error",map);
        }
        ProductCategory productCategory = new ProductCategory();
        try{
            if (categoryForm.getCategoryId()!=null){
                productCategory = categoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm,productCategory);
            categoryService.save(productCategory);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/category/list");
        return  new ModelAndView("common/success",map);
    }
}
