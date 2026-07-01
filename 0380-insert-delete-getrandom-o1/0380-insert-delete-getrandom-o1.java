class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;  
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int idx = map.get(val);
        int n = list.size() - 1;
        int last = list.get(n);

        list.set(idx, last);
        map.put(last, idx);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */