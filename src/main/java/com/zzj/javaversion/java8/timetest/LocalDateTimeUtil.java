package com.zzj.javaversion.java8.timetest;

import org.junit.Test;

import java.time.*;
import java.time.temporal.Temporal;

/**
 * @author zouzujiang
 * 获取小时 分钟
 */
public class LocalDateTimeUtil {

    @Test
    public void days(){
        LocalDate begin = LocalDate.of(2020, 12, 3);
        LocalDate end = LocalDate.of(2020, 12, 5);
        System.out.println("天数为：---" + periodDays(begin,end));
    }

    @Test
    public void hours(){
        LocalDateTime begin = LocalDateTime.of(2020, 12, 3, 16, 52, 50);
        LocalDateTime end = LocalDateTime.of(2020, 12, 3, 16, 53, 49);
        Duration duration = Duration.between(begin, end);
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
    }

    @Test
    public void getHour() {
        LocalDateTime now = LocalDateTime.of(2020, 12, 2, 17, 7, 35);
        LocalDateTime end = LocalDateTime.of(2020, 12, 1, 18, 6, 38);
        System.out.println("计算两个时间的差：");
        //获取秒数
        long nowSecond = now.toEpochSecond(ZoneOffset.ofHours(0));
        long endSecond = end.toEpochSecond(ZoneOffset.ofHours(0));
        long absSeconds = Math.abs(nowSecond - endSecond);
        //获取秒数
        long s = absSeconds % 60;
        //获取分钟数
        long m = absSeconds / 60 % 60;
        //获取小时数
        long h = absSeconds / 60 / 60 % 24;
        //获取天数
        long d = absSeconds / 60 / 60 / 24;

        System.out.println(d + "天" + h + "时" + m + "分" + s + "秒");
    }

    @Test
    public void getMinutes() {
        LocalDateTime now = LocalDateTime.of(2020, 12, 2, 17, 7, 35);
        LocalDateTime end = LocalDateTime.of(2020, 12, 2, 16, 7, 38);
        System.out.println("计算两个时间的差：");
        //获取秒数
        long nowSecond = now.toEpochSecond(ZoneOffset.ofHours(0));
        long endSecond = end.toEpochSecond(ZoneOffset.ofHours(0));
        long absSeconds = Math.abs(nowSecond - endSecond);
        //获取秒数
        long s = absSeconds % 60;
        //获取分钟数
        long m = absSeconds / 60 % 60;
        //获取小时数
        long h = absSeconds / 60 / 60 % 24;
        //获取天数
        long d = absSeconds / 60 / 60 / 24;

        System.out.println(d + "天" + h + "时" + m + "分" + s + "秒");
    }

    @Test
    public void minutes(){

    }
    /**
     * 日期相隔天数
     *
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }


    @Test
    public void minus(){
        long seconds = 7201;
        long s = seconds % 60;
        //获取分钟数
        long m = seconds / 60;
        if (s != 0) {
            m = m + 1;
        }
        System.out.println(m);
    }

    @Test
    public void getH() {
        long seconds = 7201;
        long s = seconds % (60*60);
        //获取小时数
        long h = seconds / 60 / 60;
        if (s != 0) {
            h = h + 1;
        }
        System.out.println(h);
    }

    @Test
    public void getDay() {
        long seconds = 7200*12;
        //获取秒数
        long s = seconds % (60*60*24);
        //获取天数
        long d = seconds / 60 / 60 / 24;
        if (s != 0) {
            d = d + 1;
        }
        System.out.println(d);
    }
}
