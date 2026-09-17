class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] lookupTable = new int[n + 1];

        lookupTable[1] = 1;
        lookupTable[2] = 2; 

        for(int i = 3; i<= n; i++){
            lookupTable[i] = lookupTable[i-1] + lookupTable[i-2];
        }

        return lookupTable[n];
    }
}
