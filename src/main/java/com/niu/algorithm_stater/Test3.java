package com.niu.algorithm_stater;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ami on 2019/5/26.
 * <p>
 * 快慢指针
 */
public class Test3 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if (num != val) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public int func(int[] nums, int val){
        int i = 0, j = nums.length-1;
        while(i<=j){
            if(nums[i]==val){
                nums[i]=nums[j];
                j--;
            }else
                i++;
        }
        return j+1 ;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5,6,7,8,9};
        int i = new Test3().removeElement(nums, 5);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));



    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,5,6,7,8,9};
        int j  = new Test3().func(nums,3);
        System.out.println(j);
        System.out.println(Arrays.toString(nums));
    }
}
