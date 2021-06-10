package com.zzj.javaversion.java8.timetest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzj.java8.timetest.DateVO;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/10/30 18:55
 * @since JDK 1.8
 */
public class LocaldateTest {
    private static LocalDateTime currentTime = LocalDateTime.now();

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();
        LocalTime time = LocalTime.of(3, 50);
        LocalDateTime dateTime = LocalDateTime.of(now, time);
        System.out.println(dateTime);
        System.out.println(dateTime.compareTo(now1));

        LocalTime time1 = LocalTime.of(23, 50, 0);
        LocalDateTime dateTime1 = LocalDateTime.of(now, time1);
        System.out.println(dateTime1);
    }

    /**
     * localDateTime 转换成对应的字符串类型
     */
    @Test
    public void test() {
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * 获取时间戳
     */
    @Test
    public void test2() {
        System.out.println(currentTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }


    /**
     * 根据时间戳 转换成对应的时间
     */
    @Test
    public void test4() {
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        LocalDateTime localDateTime = Instant.ofEpochMilli(1577203200000L).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        System.out.println(localDateTime);
    }

    /**
     * 获取昨天日期
     */
    @Test
    public void test5() {
        String format = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(format);
    }

    @Test
    public void test6() {
        String s = LocalDate.of(2020, 8, 24).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        LocalDate s1 = LocalDate.of(2020, 8, 24);
        LocalDate s2 = LocalDate.of(2020, 9, 25);
        LocalDate parse1 = LocalDate.parse("2020-08-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate parse2 = LocalDate.parse("2020-09-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(ChronoUnit.DAYS.between(parse1, parse2));
    }


    @Test
    public void test7() {
        String s = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(s);
        System.out.println(s.substring(0, 10));
    }

    @Test
    public void timeInterval() {
        String start = "2020-11-12 18:42:26";
        String stop = "2020-11-12 20:42:41";
        Integer interval = 30;
        LocalDateTime startTime = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endTime = LocalDateTime.parse(stop, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        List<DateVO> dates = new ArrayList<>();
        while (startTime.isBefore(endTime)) {
            DateVO vo = new DateVO();
            vo.setBeginTime(dateToStr(startTime));
            LocalDateTime plusMinutes = startTime.plusMinutes(interval);
            if (plusMinutes.isAfter(endTime)) {
            	vo.setEndTime(dateToStr(endTime));
            } else {
				vo.setEndTime(dateToStr(plusMinutes));
            }
            startTime = plusMinutes;
            dates.add(vo);
        }

		System.out.println(JSON.toJSONString(dates));
    }

    public String dateToStr(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    @Test
    public void timeInterval1() {
        String start = "08:00";
        String stop = "23:30";
        Integer interval = 30;
        LocalTime startTime = LocalTime.parse(start);
        LocalTime endTime = LocalTime.parse(stop);
        List<DateVO> dates = new ArrayList<>();
        while (startTime.isBefore(endTime)) {
            DateVO vo = new DateVO();
            vo.setBeginTime(timeToStr(startTime));
            LocalTime plusMinutes = startTime.plusMinutes(interval);
            if (plusMinutes.isAfter(endTime)) {
                vo.setEndTime(timeToStr(endTime));
            } else {
                vo.setEndTime(timeToStr(plusMinutes));
            }
            startTime = plusMinutes;
            dates.add(vo);
        }

        System.out.println(JSON.toJSONString(dates));
    }

    public String timeToStr(LocalTime localTime) {
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }


    @Test
    public void stringSub(){
        String date = "2020-11-14 15:05:00";
        System.out.println(date.substring(11,16));
    }

    @Test
    public void testWeek(){
        LocalDate now = LocalDate.now();
        LocalDate paramDate = now.plusWeeks(2);
        LocalDate toWeek = now.plusWeeks(2);
        if(toWeek.isBefore(paramDate)){
            System.out.println("超出预定时间预定时间内");
        }else{
            System.out.println("");
        }
        System.out.println("当前时间为：");
        System.out.println(paramDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("2周时间为：");
        System.out.println(toWeek.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }


    @Test
    public void months(){
        String startTime = "2021-05-21 16:17:53";
        LocalDate start = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDate now = LocalDate.now();
        long months = ChronoUnit.MONTHS.between(start, now);
        System.out.println(months);
        System.out.println("/-----------" + (months / 12));
        System.out.println("%-----------" + (months % 12));
    }

    @Test
    public void years(){
        String startTime = "2021-05-21 16:17:53";
        LocalDate start = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(start.plusYears(1));
    }

    @Test
    public void jsonStr(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("asstActType1", "客户");
        jsonObject.put("asstActName1", "1");
        jsonObject.put("asstActNumber1", "2");
        jsonObject.put("asstActType2", "合同");
        jsonObject.put("asstActName2", "3");
        jsonObject.put("asstActNumber2", "4");
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void forTest(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j== 1){
                    System.out.println(j);
                    break;
                }else{
                    System.out.println("--" + j);
                }
            }
        }
    }
}
