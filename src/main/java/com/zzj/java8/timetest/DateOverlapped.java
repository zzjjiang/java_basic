package com.zzj.java8.timetest;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zouzujiang
 */
public class DateOverlapped {
    public static boolean overlapped(TimeSlot slot1, TimeSlot slot2) {
        TimeSlot previous, next;
        previous = slot1.startTime.isBefore(slot2.startTime) ? slot1 : slot2;
        next = slot2.startTime.isAfter(slot1.startTime) ? slot2 : slot1;
        // 这里业务需要，允许时间点的重叠
        // 例如某个时间段的起始时间：2020-06-29 00:00:00
        // 和另一个时间段的终止时间：2020-06-29 00:00:00
        // 它们俩可以有交点。如果不需要这种逻辑只把le改成lt
        // ，ge改成gt就可
        return !(le(previous, next) || ge(previous, next));
    }

    /**
     * 构造一个时间段
     * @param startTime
     * @param endTime
     * @return
     */
    public static TimeSlot buildSlot(LocalDateTime startTime, LocalDateTime endTime) {
        return new TimeSlot(startTime, endTime);
    }

    /**
     * less equal
     * 小于等于
     * @param prev
     * @param next
     * @return
     */
    private static boolean le(TimeSlot prev, TimeSlot next) {
        return lt(prev, next) || next.endTime.isEqual(prev.startTime);
    }

    /**
     * greater equal
     * 大于等于
     * @param prev
     * @param next
     * @return
     */
    private static boolean ge(TimeSlot prev, TimeSlot next) {
        return gt(prev, next) || prev.endTime.isEqual(next.startTime);
    }

    /**
     * greater than
     * 大于
     * @param prev
     * @param next
     * @return
     */
    private static boolean gt(TimeSlot prev, TimeSlot next) {
        return prev.endTime.isBefore(next.startTime);
    }

    /**
     * less than
     * 小于
     * @param prev
     * @param next
     * @return
     */
    private static boolean lt(TimeSlot prev, TimeSlot next) {
        return next.endTime.isBefore(prev.startTime);
    }

    /**
     * 时间段类
     */
    @Data
    static class TimeSlot{
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
            if (startTime.isAfter(endTime)) {
                this.startTime = endTime;
                this.endTime = startTime;
            } else {
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }
    }

    public static void main(String[] args) {
        LocalDateTime startTime1 = LocalDateTime.of(2020, 11, 16, 15, 30, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2020, 11, 16, 17, 30, 0);
        LocalDateTime startTime2 = LocalDateTime.of(2020, 11, 16, 15, 30, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2020, 11, 16, 17, 30, 0);
        TimeSlot time1 = buildSlot(startTime1,endTime1);
        TimeSlot time2 = buildSlot(startTime2,endTime2);
        boolean overlapped = overlapped(time1, time2);
        System.out.println(overlapped);
    }
}
