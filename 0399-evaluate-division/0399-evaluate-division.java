class Solution {
    class Pair{
        String dest;
        double val;
        public Pair(String dest, double val){
            this.dest = dest;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> e, double[] v, List<List<String>> q) {
        int n = e.size();
        Map<String, List<Pair>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            List<String> curr = e.get(i);
            map.putIfAbsent(curr.get(0), new ArrayList<>());
            map.putIfAbsent(curr.get(1), new ArrayList<>());
            map.get(curr.get(0)).add(new Pair(curr.get(1), v[i]));
            map.get(curr.get(1)).add(new Pair(curr.get(0), 1/v[i]));
        }
        int len = q.size();
        double result[] = new double[len];
        for(int i=0; i<len; i++){
            String src = q.get(i).get(0);
            String des = q.get(i).get(1);
            double product = 1.0;
            double ans = -1.0;
            if(map.containsKey(src)){
                Set<String> vis = new HashSet<>();
                ans = dfs(map, vis, src, des, product, ans);
            }
            result[i] = ans;
        }
        return result;
    }
    public double dfs(Map<String, List<Pair>> map, Set<String> vis, String src, String des, double p, double ans){
        if(vis.contains(src)) return -1;
        if(src.equals(des)){
            return p;
        }
        vis.add(src);
        for(Pair ob : map.get(src)){
            ans = dfs(map, vis, ob.dest, des, p * ob.val, ans);
            if(ans != -1) return ans;
        }
    return -1;
    }
}