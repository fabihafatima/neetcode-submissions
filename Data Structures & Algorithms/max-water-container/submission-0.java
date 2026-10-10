class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxA= 0;
        while(left<right){
           int l = right -left;
           int minH = Math.min(heights[right], heights[left]);
           maxA= Math.max(maxA, l * minH);
           if(minH == heights[right]) right--;
           else{
            left++;
           }
        }
        return maxA;
    }
}
