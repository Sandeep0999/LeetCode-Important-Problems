class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = n * n;
        int even = n * (n + 1);
        return gcd(even, odd);
    }
    public int gcd(int i, int j){
        if(j == 0) return i;
        return gcd(j, i % j);
    }
}