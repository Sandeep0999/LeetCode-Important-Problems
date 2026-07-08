class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < messages.length; i++) {
            map.put(senders[i],
                    map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);
        }

        String ans = "";
        int max = -1;

        for (String sender : map.keySet()) {
            int cnt = map.get(sender);
            if (cnt > max || (cnt == max && sender.compareTo(ans) > 0)) {
                max = cnt;
                ans = sender;
            }
        }

        return ans;
        // int n = m.length;
        // TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        // for(int i=0; i<n; i++){
        //     String arr[] = m[i].split(" ");
        //     int len = arr.length;
        //     map.put(s[i], map.getOrDefault(s[i], 0) + len);
        // }
        // String ans = " ";
        // int max = 0;
        // for(Map.Entry<String, Integer> en : map.entrySet()){
        //     int freq = en.getValue();
        //     String name = en.getKey();
        //     if(freq > max){
        //         ans = name;
        //         max = freq;
        //     }
        // }
        // return ans;
    }
}