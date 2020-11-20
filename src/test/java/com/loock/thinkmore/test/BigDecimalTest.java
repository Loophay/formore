package com.loock.thinkmore.test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BigDecimalTest {
    @Test
    public void test(){
        DecimalFormat df = new DecimalFormat();
        String style = "0.00000";
        df.applyPattern(style);

        String str = "60支/日";
        String s = formatInviteCode(str);
        double v = Double.parseDouble(s);
        String format = df.format(v);
        BigDecimal bd = new BigDecimal(format);

        System.out.println(bd);
    }
    @Test
    public String formatInviteCode(String str1) {
        String str2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (Character.isDigit(str1.charAt(i))) {
                str2 += str1.charAt(i);
            }else{
                break;
            }
        }
        //System.out.println(str2);
        return  str2;
    }

    public void test2(){
        Map<String,String> map = new HashMap<>();
        map.put("value","1");

    }
}
