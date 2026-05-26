class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(0, nums, subset, res);
        return res;
    }
    void backtrack(int index, int[]nums, List<Integer>subset, List<List<Integer>> res){
        res.add(new ArrayList<>(subset));
        for(int i = index; i<nums.length; i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            backtrack(i+1, nums, subset, res);
            subset.remove(subset.size()-1);
        }
    }
}
