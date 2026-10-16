class Solution {
    public int search(int[] nums, int target) {
        int end = nums.length-1;
        int start =0;
        
        while(start<=end){
            int mid = (end + start)/2;
           
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]> target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
