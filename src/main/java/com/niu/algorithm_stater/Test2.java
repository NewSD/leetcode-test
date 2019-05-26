package com.niu.algorithm_stater;

import java.util.Arrays;

/**
 * Created by ami on 2019/5/26.
 */
public class Test2 {

    public int removeDupliaction(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 3,4,5};
        Test2 test2 = new Test2();
        int i = test2.removeDupliaction(ints);
        System.out.println(i);
        System.out.println(Arrays.toString(ints));
    }
}
