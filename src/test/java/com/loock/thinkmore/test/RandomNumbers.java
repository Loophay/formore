package com.loock.thinkmore.test;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomNumbers {

  @Test
  public void testRandom(){
    for (int i = 0; i < 10 ; i++){
      randomNumbers();
    }
  }
  @Test
  public String randomNumbers(){
    int  maxNum = 62;
    int i;
    int count = 0;
    char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
      'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
      'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
      'r','s','t','u','v','w','x','y','z'};
    StringBuffer pwd = new StringBuffer("");
    Random r = new Random();
    while(count < 8){
      i = Math.abs(r.nextInt(maxNum));
      if (i >= 0 && i < str.length) {
        pwd.append(str[i]);
        count ++;
      }
    }
    System.out.println(pwd.toString());
    return pwd.toString();
  }
}
