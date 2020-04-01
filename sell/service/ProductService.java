package com.zzh.sell.service;

import com.zzh.sell.dataobject.ProductInfo;
import com.zzh.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    //查询所有上架商品
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
}
