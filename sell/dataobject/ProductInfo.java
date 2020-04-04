package com.zzh.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zzh.sell.enums.ProductStatusEnum;
import com.zzh.sell.utils.EnumUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@DynamicUpdate
@Proxy(lazy = false)
public class ProductInfo {

    @Id
    private String productId;

    /** 名字。 */
    private String productName;

    /** 单价。 */
    private BigDecimal productPrice;

    /** 库存 。*/
    private Integer productStock;

    /** 商品描述*/
    private String productDescription;

    /** 图片*/
    private String productIcon;

    /** 小图*/
    private  Integer categoryType;

    /**  状态0正常1下架*/
    private  Integer productStatus=ProductStatusEnum.UP.getCode();

    /** 更新时间*/
    private Date updateTime;

    /** 创建时间*/
    private  Date createTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
