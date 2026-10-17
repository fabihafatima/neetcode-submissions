class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        int endRow = matrix.length, row =0;
        for( row = 0; row<endRow; row++){
              if(target<=matrix[row][matrix[0].length-1]){
                break;
              }
        }
        if (row == endRow) {
            return false;
        }
         int start=0, end = matrix[0].length-1;
         while(start<=end){
            int mid = start+(end-start)/2;
            if(target==matrix[row][mid]){
                return true;
            }else if(target>matrix[row][mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}
