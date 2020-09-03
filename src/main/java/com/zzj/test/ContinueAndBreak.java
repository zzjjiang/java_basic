package com.zzj.test;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzj
 * @description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @date 2020.07.17
 */
public class ContinueAndBreak {
    /**
     * 普通数组
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length; i++){
            for(int j = 0;j < nums.length;j++){
                if(j == i){
                    continue;
                }
                if(nums[i]+nums[j] == target){
                   return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * hash定位
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumOther(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if(map.containsKey(res) && map.get(res) != i){
                return new int[]{map.get(res),i};
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        /*int[] params = new int[]{3,2,4};
        int target = 6;
        twoSum(params,target);*/

        int[] params = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(params, k);
        System.out.println(JSON.toJSONString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int end = length - k;
        int[] result = new int[end];
        for(int i = 0;i < end;i++){
            //取出3者最大值
            int[] temp = new int[k];
            for(int j = 0;j < k;j++){
                temp[j] = nums[i+j];
            }
            int max = 0;
            for(int l = 0;l < k-1;l++){
                max = temp[0];
                if(temp[l+1]>max){
                    max = temp[l+1];
                }
            }
            result[i] = max;
        }
        return result;
    }


}
