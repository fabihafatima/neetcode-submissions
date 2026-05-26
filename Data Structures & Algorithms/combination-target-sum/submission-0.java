class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        calculateSum(0, nums, target, new ArrayList<Integer>(),0, result);
        return result;

    }
    void calculateSum(int index, int nums[], int target,List<Integer> arrSum, int currSum, List<List<Integer>> result){
        if(currSum>target || index>=nums.length){
            return;
        }
        if(currSum==target){
            result.add(new ArrayList<>(arrSum));
            return;
        }

        arrSum.add(nums[index]);
        currSum = currSum + nums[index];
        calculateSum(index, nums, target,arrSum, currSum,result);
        currSum = currSum - arrSum.get(arrSum.size()-1);
        arrSum.remove(arrSum.size()-1);
        calculateSum(index+1, nums, target,arrSum, currSum,result);

    }
}
