package com.zzj.javaversion.java8.lambda.all;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zouzujiang
 */
public class FinancialTest {

    @Test
    public void all() throws ParseException {
        String start = "2021-01-25 19:50:11";
        String end = "2021-02-25 19:50:11";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
        List<SourceCost> sourceCosts = getSourceCosts();
        List<LeaseForeseeBillGenerateVO> list = sourceCosts.stream()
                .flatMap(sourceCost -> {
                    Integer costId = sourceCost.getCostId();
                    SmartCharges charge = getChargesByCid(costId);
                    return sourceCost.getRoomIds().stream()
                            .map(this::getLeaseForeseeBillRoom)
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
                .filter(vo -> vo.getChargeType() == 1 && vo.getRoomId() == 1)
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
        for (LeaseForeseeBillGenerateVO vo:
        list) {
            System.out.println(JSON.toJSONString(vo));
        }

    }


    @Test
    public void first() {
        List<SourceCost> sourceCosts = getSourceCosts();
        List<LeaseForeseeBillGenerateVO> list = sourceCosts.stream()
                .flatMap(sourceCost -> {
                    Integer costId = sourceCost.getCostId();
                    SmartCharges charge = getChargesByCid(costId);
                    return sourceCost.getRoomIds().stream()
                            .map(this::getLeaseForeseeBillRoom)
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
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void tow() {
        List<SourceCost> sourceCosts = getSourceCosts();
        List<LeaseForeseeBillGenerateVO> list = sourceCosts.stream()
                .flatMap(sourceCost -> {
                    Integer costId = sourceCost.getCostId();
                    SmartCharges charge = getChargesByCid(costId);
                    return sourceCost.getRoomIds().stream()
                            .map(this::getLeaseForeseeBillRoom)
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
                .filter(vo -> vo.getChargeType() == 1)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void StreamIterate() throws ParseException {
        String start = "2021-01-26 19:50:11";
        String end = "2021-06-25 19:50:11";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
        long month = DateUtil.betweenMonth(startDate, endDate, true);
        System.out.println(month);
        Stream.iterate(DateUtil.beginOfMonth(startDate),
                date -> DateUtil.offsetMonth(date, 1))
                .limit(DateUtil.betweenMonth(startDate, endDate, true) + 1)
                .forEach(x -> System.out.println(x));
    }











    private List<SourceCost> getSourceCosts() {
        List<SourceCost> list = new ArrayList<>();
        SourceCost cost1 = new SourceCost();
        cost1.setCostId(1);
        cost1.setDiscount(BigDecimal.ONE);
        cost1.setPaymentCycleType(1);
        cost1.setRoomIds(Arrays.asList(1, 2));

        SourceCost cost2 = new SourceCost();
        cost2.setCostId(2);
        cost2.setDiscount(BigDecimal.TEN);
        cost2.setPaymentCycleType(2);
        cost2.setRoomIds(Arrays.asList(2, 3));
        list.add(cost1);
        list.add(cost2);
        return list;
    }


    public SmartCharges getChargesByCid(Integer costId) {
        SmartCharges charges = new SmartCharges();
        if (costId == 1) {
            charges.setChargesName("one");
            charges.setChargesType(1);
        }
        if (costId == 2) {
            charges.setChargesName("tow");
            charges.setChargesType(2);
        }
        return charges;
    }

    public LeaseForeseeBillRoomVO getLeaseForeseeBillRoom(Integer roomId) {
        LeaseForeseeBillRoomVO vo = new LeaseForeseeBillRoomVO();
        if (roomId == 1) {
            vo.setRoomId(1);
            vo.setRoomName("one room");
            vo.setFloorName("one floor");
            vo.setBuildingName("one building");
        }
        if (roomId == 2) {
            vo.setRoomId(2);
            vo.setRoomName("tow room");
            vo.setFloorName("tow floor");
            vo.setBuildingName("tow building");
        }
        if (roomId == 3) {
            vo.setRoomId(3);
            vo.setRoomName("three room");
            vo.setFloorName("three floor");
            vo.setBuildingName("three building");
        }
        return vo;
    }
}
