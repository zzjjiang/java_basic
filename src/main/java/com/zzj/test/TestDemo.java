package com.zzj.test;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zzj
 * @description
 * @date 2020.08.24
 */
public class TestDemo {

    @Test
    public void test(){
        int i = 2;
        if(i == 2){
            System.out.println("if");
        }else if(i != 0){
            System.out.println("else1");
        }else {
            System.out.println("else2");
        }
    }

    @Test
    public void test1(){
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(3L);
        set.add(3L);
        set.add(1L);
        System.out.println(set.toString());
    }

    @Test
    public void test2(){
        TestModel model = new TestModel();
        model.setCityId(22L);
        model.setId(11L);
        model.setName("test");

        TestVO vo = new TestVO();
        BeanUtil.copyProperties(model,vo);
        System.out.println(JSON.toJSONString(vo));
    }

    @Test
    public void test3(){
        String s = "827CCB0EEA8A706C4C34A16891F84E7B";
        System.out.println(s.substring(s.length()-16,s.length()));
    }

    @Test
    public void test4(){
        Map<Integer, Integer> map = new HashMap<>(2);
        map.put(1,2);
        map.put(1,3);
        System.out.println(JSON.toJSONString(map));
    }




    /**
     * 获取固定间隔时刻集合
     * @param start 开始时间
     * @param end 结束时间
     * @param interval 时间间隔(单位：分钟)
     * @return
     */
    public static List<String> getIntervalTimeList(String start, String end, int interval){
        Date startDate = convertString2Date("HH:mm:ss",start);
        Date endDate = convertString2Date("HH:mm:ss",end);
        List<String> list = new ArrayList<>();
        while(startDate.getTime()<=endDate.getTime()){
            list.add(convertDate2String("HH:mm:ss",startDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MINUTE,interval);
            if(calendar.getTime().getTime()>endDate.getTime()){
                if(!startDate.equals(endDate)){
                    list.add(convertDate2String("HH:mm:ss",endDate));
                }
                startDate = calendar.getTime();
            }else{
                startDate = calendar.getTime();
            }

        }
        return list;
    }

    public static Date convertString2Date(String format, String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertDate2String(String format,Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

}
