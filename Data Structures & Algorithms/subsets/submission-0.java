// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         HashSet <Integer >
    
//     List<List<Integer>> result = new ArrayList<>();
//     backtrack(0, nums, new ArrayList<>(), result);
//     return results;
//     }

//     private void backtrack(int index, int[] nums, List<Integer> subset, List<List<Integer>> result){


//     }
// }
class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // start with empty subset
        result.add(new ArrayList<>());

        for (int num : nums) {

            int size = result.size();

            // add current number to all existing subsets
            for (int i = 0; i < size; i++) {

                List<Integer> newSubset =
                        new ArrayList<>(result.get(i));

                newSubset.add(num);

                result.add(newSubset);
            }
        }

        return result;
    }
}