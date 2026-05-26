class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      backtrack(0, nums, new ArrayList<Integer>() ,result);
      return result;

    }
    void backtrack(int index, int[] nums, List<Integer> cSubset, List<List<Integer>>result){
        if(index>=nums.length){
            result.add(new ArrayList<>(cSubset));
            return;
        }
        cSubset.add(nums[index]);
        backtrack(index+1, nums, cSubset, result);
        cSubset.remove(cSubset.size() - 1);
        backtrack(index+1,nums, cSubset, result);

    }
}
// class Solution {

//     public List<List<Integer>> subsets(int[] nums) {

//         List<List<Integer>> result = new ArrayList<>();
//         result.add(new ArrayList<>());

//         for (int num : nums) {
//             int size = result.size();
//             for (int i = 0; i < size; i++) {

//                 List<Integer> newSubset =
//                         new ArrayList<>(result.get(i));

//                 newSubset.add(num);

//                 result.add(newSubset);
//             }
//         }

//         return result;
//     }
// }