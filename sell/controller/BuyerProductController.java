package com.zzh.sell.controller;

import com.zzh.sell.VO.ProductInfoVO;
import com.zzh.sell.VO.ProductVo;
import com.zzh.sell.VO.ResultVO;
import com.zzh.sell.dataobject.ProductCategory;
import com.zzh.sell.dataobject.ProductInfo;
import com.zzh.sell.repository.ProductInfoRepository;
import com.zzh.sell.service.CategoryService;
import com.zzh.sell.service.ProductService;
import com.zzh.sell.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhuZHUzhu
 * @Description:买家商品
 * @Date: Created in 20:16 2020/3/7
 * @Modified By:
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //1.查询所有上架的商品
         List<ProductInfo> productInfoList = productService.findUpAll();

        //2、查询类目（一次性查询）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e->e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        //3、数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory :productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO =new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVo.setProductInfoVOS(productInfoVOList);
            productVoList.add(productVo);
        }
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVoList);
        return ResultVOUtils.success(productVoList);
    }
}
