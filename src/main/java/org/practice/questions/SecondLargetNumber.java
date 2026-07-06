package org.practice.questions;

public class SecondLargetNumber {

    public static void main(String[] args) {

        int[] num = new int[] {5,5,5};

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {
            if (num[i] > firstMax && num[i] > secondMax) { // 10, 5
                secondMax = firstMax;// min, 
                firstMax = num[i]; // 10, 
            }else if(num[i] > secondMax){
                secondMax = num[i];
            }
        }
        System.out.println(firstMax);

        System.out.println(secondMax);
    }

}
