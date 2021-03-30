package com.zzj.javaversion.java8.lambda.all;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zouzujiang
 */
@Data
public class LeaseForeseeBillGenerateDTO {

    private Long originalContractId;

    private Date changeDate;

    private Date startDate;

    private Date endDate;

    private List<SourceCost> sourceCostList;

    private List<CostAdjustment> costAdjustmentList;


    @Data
    public static class SourceCost {

        private Long costId;

        private Integer unitPriceType;

        private BigDecimal discount;

        private BigDecimal unitPrice;

        private Integer paymentCycleType;

        private Long gatheringId;

        private List<Long> roomIdList;

    }

    @Data
    public static class CostAdjustment {

        private Long costId;

        private Integer progressiveIncreaseType;

        private BigDecimal progressiveIncreaseNumber;

        private Date beginTime;
    }

    @Data
    public static class Exempt{
        private Date endTime;
        private Long costId;
        private Long roomId;
    }
}
