package com.zzj.javaversion.java8.lambda.all;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zouzujiang
 */
@Data
@Accessors(chain = true)
public class LeaseForeseeBillGenerateVO {

    private Long roomId;

    private String roomName;

    private String floorName;

    private String buildingName;

    private String chargeName;

    private Integer paymentCycleType;

    private Integer chargeType;

    private BigDecimal discount;

    private Date billingPeriodStart;

    private Date billingPeriodEnd;

    public LeaseForeseeBillGenerateVO copy() {
        return BeanUtil.toBean(this, LeaseForeseeBillGenerateVO.class);
    }

    @Data
    public static class Room {
        private Long roomId;
        private String roomName;
        private String floorName;
        private String buildingName;
    }
}
