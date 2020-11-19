package com.company;
/* 11题：
给你 n 个非负整数 a1，a2，...，an，
每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int maxArea(int[] height) {
        int max=0;
        for (int i = 0; i <= height.length-1; i++) {
            for(int j=i+1;j<=height.length-1;j++)
            {
                int real=(j-i)*Math.min(height[j-1],height[j]);
                max=Math.max(max,real);
            }
        }
        return max;
    }
}
public class Main {
    public  static int maxArea(int[] height) {
        int max=0;
        for (int i = 0; i <= height.length-1; i++) {
            for(int j=i+1;j<=height.length-1;j++)
            {
                int real=(j-i)*Math.min(height[i],height[j]);
                //System.out.println(height[j-1]); 这行代码调试用的
                //System.out.println(height[j]);   这行代码调试用的
                max=Math.max(max,real);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
