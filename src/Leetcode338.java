public class Leetcode338 {
    // Counting Bits
    public int[] countBits(int num) {
        if(num==0){
            return new int[]{0};
        }
        int[] dp = new int[num+1];
        dp[1]=1;
        for (int i=2;i<=num;i++){
            if(i%2==1){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=dp[i/2];
            }
        }
        return dp;
    }
}
