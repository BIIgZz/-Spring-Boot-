package com.zzh.sell.form;

import lombok.Data;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 15:24 2020/4/20
 * @Modified By:
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**类目名称。*/

    private String categoryName;

    /**类目类型。*/

    private Integer categoryType;
}
