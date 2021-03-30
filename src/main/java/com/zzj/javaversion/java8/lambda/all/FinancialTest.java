package com.zzj.javaversion.java8.lambda.all;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zouzujiang
 */
public class FinancialTest {

    @Test
    public void first() throws ParseException {
        String start = "2021-01-25 19:50:11";
        String end = "2021-07-25 19:50:11";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
        boolean auto = false;
        LeaseForeseeBillGenerateDTO dto = new LeaseForeseeBillGenerateDTO();
        List<LeaseForeseeBillGenerateVO> list = dto.getSourceCostList().stream()
                .flatMap(sourceCost -> {
                    Long costId = sourceCost.getCostId();
                    SmartCharges charge = getChargesByCid(costId);
                    return sourceCost.getRoomIdList().stream()
                            .map(sourceCostId -> {
                                return getLeaseForeseeBillRoom(sourceCostId);
                            })
                            .map(room -> new LeaseForeseeBillGenerateVO()
                                    .setRoomId(room.getRoomId())
                                    .setRoomName(room.getRoomName())
                                    .setFloorName(room.getFloorName())
                                    .setBuildingName(room.getBuildingName())
                                    .setChargeName(charge.getChargesName())
                                    .setChargeType(charge.getChargesType())
                                    .setDiscount(sourceCost.getDiscount())
                                    .setPaymentCycleType(sourceCost.getPaymentCycleType())
                            );
                })
                .filter(vo -> auto == (vo.getChargeType() == 1 || vo.getChargeType() == 2))
                .flatMap(vo -> {
                    int paymentCycleType = vo.getPaymentCycleType();
                    if (paymentCycleType == 1) {// 自然月
                        return Stream.iterate(DateUtil.beginOfMonth(startDate),
                                date -> DateUtil.offsetMonth(date, 1))
                                .limit(DateUtil.betweenMonth(startDate, endDate, true) + 1)
                                .map(date -> vo.copy()
                                        .setBillingPeriodStart(date)
                                        .setBillingPeriodEnd(DateUtil.endOfMonth(date)));
                    }
                    // 合同月
                    return Stream.iterate(startDate, date -> DateUtil.offsetMonth(date, 1))
                            .limit(DateUtil.betweenMonth(startDate, endDate, false) + 1)
                            .map(date -> vo.copy()
                                    .setBillingPeriodStart(date)
                                    .setBillingPeriodEnd(DateUtil.offsetDay(DateUtil
                                            .offsetMonth(date, 1), -1)));
                })
                .collect(Collectors.toList());
    }


    public SmartCharges getChargesByCid(Long costId){
        return null;
    }

    public LeaseForeseeBillRoomVO getLeaseForeseeBillRoom(Long sourceCostId){
        return null;
    }
}
