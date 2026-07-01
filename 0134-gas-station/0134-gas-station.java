class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, req = 0;

        for(int i : gas) total += i;
        for(int i : cost) req += i;
        if(req > total) return -1;

        int tank = 0, idx = 0;
        for(int i=0; i<n; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                idx = i + 1;
            }
        }
    return idx;
    }
}