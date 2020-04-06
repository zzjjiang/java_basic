package com.zzj.test;

/**
 * @author Jone
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月04日 15:47
 */
public class OtherClass {
    public static void main(String[] args) {
       /* String[] str1 = {"22","44","11","22"};
        String[] str2={"33","4","6","199","11"};
        List<String> strList = new ArrayList<>(Arrays.asList(str1));
        strList.addAll(Arrays.asList(str2));
        List<Integer> intList = strList.stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = intList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(result);
        for (int big = 0; big < 200; big++) {
            for (int middle = 0; middle < 200; middle++) {
                for (int small = 3; small < 200; small=small+3) {
                    if((big*10+middle*6+small*2/3)==200
                            &&((big+middle+small)==200)){
                        System.out.println(big+"-"+middle+"-"+small);
                        //2-9-189
                        //6-2-192
                    }
                }
            }
        }*/
        System.out.println(6&2);
    }

    public static void getNums(){

        for (int big = 0; big < 200; big++) {
            for (int middle = 0; middle < 200; middle++) {
                for (int small = 3; small < 200; small=small+3) {
                    if((big*10+middle*6+small*2/3)==200
                    &&((big+middle+small)==200)){
                        System.out.println(big+"-"+middle+"-"+small);
                    //2-9-189
                    //6-2-192
                    }
                }
            }
        }
        
    }
}
