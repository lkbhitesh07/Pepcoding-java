//Via Recursion(First approach to tell recruiter)
// A recursive solution for subset sum problem.

//class GFG {

// 	// Returns true if there is a subset
// 	// of set[] with sum equal to given sum
// 	static boolean isSubsetSum(int set[],
// 							int n, int sum)
// 	{
// 		// Base Cases
// 		if (sum == 0)
// 			return true;
// 		if (n == 0)
// 			return false;

// 		// If last element is greater than
// 		// sum, then ignore it
// 		if (set[n - 1] > sum)
// 			return isSubsetSum(set, n - 1, sum);

// 		/* else, check if sum can be obtained
// 		by any of the following
// 			(a) including the last element
// 			(b) excluding the last element */
// 		return isSubsetSum(set, n - 1, sum)
// 			|| isSubsetSum(set, n - 1, sum - set[n - 1]);
// 	}

// 	/* Driver code */
// 	public static void main(String args[])
// 	{
// 		int set[] = { 3, 34, 4, 12, 5, 2 };
// 		int sum = 9;
// 		int n = set.length;
// 		if (isSubsetSum(set, n, sum) == true)
// 			System.out.println("Found a subset"
// 							+ " with given sum");
// 		else
// 			System.out.println("No subset with"
// 							+ " given sum");
// 	}
// }






//Via DP
import java.io.*;
import java.util.*;

class TargetSumSubset {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int tar = scn.nextInt();
        
        boolean[][] dp = new boolean[n+1][tar+1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    //sum 0 with no elements is possible
                    dp[i][j] = true;
                }
                else if(i == 0){
                    // Non zero sum(as j != 0) with no elements is never possible
                    dp[i][j] = false;
                }
                else if(j == 0){
                    //sum zero is always possible
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] = dp[i-1][j]; //when excluding the ith number
                    int val = arr[i-1]; //ith number will have index i-1
                    if(j >= val){
                        if(dp[i-1][j-val] == true){
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        
        System.out.println(dp[n][tar]);
    }
}
