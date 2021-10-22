package com.pipi.firstdemo.likou;

public class 解码方法II {
    //1*2*9
    public int numDecodings(String s) {
        int res =1;
        char lastChar ;
        char nextChar = s.charAt(1);
        for (int i = 0; i < s.length(); i++) {
            //第一个
            if(i==0){
                if(s.charAt(i)=='*'){
                    res = 9;
                }else {
                    res =1;
                }
            }else{

            }
        }
        return 1;
    }

}
