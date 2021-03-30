package com.zzj.javaversion.java8.lambda.all;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zouzujiang
 */
@Data
public class SourceCost {

        private Integer costId;

        private BigDecimal discount;

        private Integer paymentCycleType;

        private List<Integer> roomIds;
}
