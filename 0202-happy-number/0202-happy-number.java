class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> visited = new HashSet<>();
        while (n != 1) {
            if (visited.contains(n)) return false;
            visited.add(n);
            n = squareSum(n);
        }
        return true;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}