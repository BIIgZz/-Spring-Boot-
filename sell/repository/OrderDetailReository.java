package com.zzh.sell.repository;

import com.zzh.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 17:19 2020/3/9
 * @Modified By:
 */
public interface OrderDetailReository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);

}
