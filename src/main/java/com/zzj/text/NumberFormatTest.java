package com.zzj.text;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zzj
 * @description
 * @date 2020.07.20
 */
public class NumberFormatTest {

    @Test
    public void test(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        int number = 20;
        int parkingCount =30;
        String value = numberFormat.format((float) number / (float) parkingCount * 100);
        System.out.println(value);
    }

    @Test
    public void test11(){
        BigDecimal punchRate = new BigDecimal(20).divide(new BigDecimal(30), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(punchRate);
    }

    @Test
    public void test12(){
        String time = getDateAfter(new Date(),0,"yyyy-MM-dd 00:00:00");
        System.out.println(time);
    }


    private static String getDateAfter(Date d, int day, String formatStyle) {
        SimpleDateFormat format = new SimpleDateFormat(formatStyle);
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return format.format(now.getTime());
    }


}
