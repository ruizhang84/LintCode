/*k数和 II
给定n个不同的正整数，整数k（1<= k <= n）以及一个目标数字。　　　　

在这n个数里面找出K个数，使得这K个数的和等于目标数字，你需要找出所有满足要求的方案。
样例
给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
*/


public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>> ();
        if (k < 0){
            return ans;
        }else if (k == 1){
            ArrayList<Integer> temp = new ArrayList<Integer> ();
            for (int i = 0;i < A.length;i++){
                if (A[i] == target){
                    temp.add(target);
                    break;
                }
            }
            ans.add(temp);
            return ans;
        }else if (k == 2){
            int left = 0, right = A.length-1;
            ArrayList<Integer> temp = new ArrayList<Integer> ();
            while (left < right){
                if (A[left] + A[right] > target){
                    right--;
                }else if (A[left] + A[right] < target){
                    left ++;
                }else{
                    temp.add(A[left]);
                    temp.add(A[right]);
                    ans.add(temp);
                    temp = new ArrayList<Integer> ();
                    right--;
                    left ++;
                }
            }
            return ans;
        }else {
            for (int i = 0; i < A.length && A[i] < target/k; i ++){
                ArrayList<Integer> temp = new ArrayList<Integer> ();
                temp.add(A[i]);
                recur_kSumII(A, k-1, target-A[i], i+1, temp, ans);
            }
            
        }
        
        return ans;
    }
    public void recur_kSumII(int [] A, int k, int target, int start, ArrayList<Integer> prev, ArrayList<ArrayList<Integer>> ans){
         if (k == 2){
            ArrayList<Integer> temp = new ArrayList<Integer> (prev);
            int left = start, right = A.length-1;
            while (left < right){
                if (A[left] + A[right] > target){
                    right--;
                }else if (A[left] + A[right] < target){
                    left ++;
                }else{
                    temp.add(A[left]);
                    temp.add(A[right]);
                    ans.add(temp);
                    temp = new ArrayList<Integer> (prev);
                    right--;
                    left ++;
                }
            }
            
        }else{
            for (int i = start; i < A.length && A[i] < target/(k-1); i ++){
                ArrayList<Integer> temp = new ArrayList<Integer> (prev);
                temp.add(A[i]);
                recur_kSumII(A, k-1, target-A[i], i+1, temp, ans);
            }
        }
    }
}



