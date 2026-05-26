class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        boolean status[]= new boolean[nums.length];
        permuteCombine(nums, status, arr, res);
        return res;
    }   
    void permuteCombine(int[] nums, boolean[] status, List<Integer> arr, List<List<Integer>> res ){
        if(arr.size()==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (!status[i]) {

                arr.add(nums[i]);
                status[i] = true;
                permuteCombine(nums, status, arr, res);
                arr.remove(arr.size() - 1);
                status[i] = false;
            }
        }
    }
}
