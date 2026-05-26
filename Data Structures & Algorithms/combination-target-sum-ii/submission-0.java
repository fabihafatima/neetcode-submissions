class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        calculateSum(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
    }
    void calculateSum(int index, int nums[], int target, List<Integer> arrSum, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(arrSum));
            return;
        }
        if(target<0|| index>=nums.length){
            return;
        }
       
      
        for(int i = index; i< nums.length; i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            arrSum.add(nums[i]);
            calculateSum(i+1, nums,  target - nums[i],arrSum,result);
            arrSum.remove(arrSum.size()-1);
        }

    }
}
