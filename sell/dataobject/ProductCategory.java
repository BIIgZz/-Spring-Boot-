package com.zzh.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;

@Entity
@DynamicUpdate
@Data
@Proxy(lazy=false)
//@Table(name = "product_category")
public class ProductCategory {
    /**类目id。*/
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer categoryId;

    /**类目名称。*/
    @Column(name = "category_name")
    private String categoryName;

    /**类目类型。*/
    @Column(name = "category_type")
    private Integer categoryType;

    /**创建时间。*/
    @Column(name = "create_time")
    private Date createTime;

    /**更新时间。*/
    @Column(name = "update_time")
    private Date updateTime;

    public ProductCategory(){

    }
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
