package PracticeProject;
import java.util.ArrayList;
import java.util.List;
public class LongestIncreasingSubsequence {
	public static List<Integer> findLongestIncreasingSubsequence(int[] nums) {
        List<Integer> longestSubsequence = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] indices = new int[n];
        int maxLength = 0;
        int endIndex = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            indices[i] = -1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    indices[i] = j;
                }
            }
            
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }
        
        while (endIndex >= 0) {
            longestSubsequence.add(0, nums[endIndex]);
            endIndex = indices[endIndex];
        }
        
        return longestSubsequence;
    }
    
    public static void main(String[] args) {
        int[] nums = {33, 12, 22, 41, 20};
        List<Integer> longestSubsequence = findLongestIncreasingSubsequence(nums);
        
        System.out.println("Longest Increasing Subsequence:");
        for (int num : longestSubsequence) {
            System.out.print(num + " ");
        }
    }

}

