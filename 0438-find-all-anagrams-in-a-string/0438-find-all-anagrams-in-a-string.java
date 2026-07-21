class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int f1[] = new int[26];
        int f2[] = new int[26];
        ArrayList<Integer> l = new ArrayList<>();
        if(p.length() > s.length()) return l;
        for(int i=0;i<p.length();i++){
            f1[s.charAt(i)-'a']++;
            f2[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(f1,f2)) l.add(0);

        for(int i=1;i<=s.length()-p.length();i++){
            f1[s.charAt(i-1)-'a']--;
            f1[s.charAt(i+p.length()-1)-'a']++;
            if(Arrays.equals(f1,f2)) l.add(i);  
        }
        return l;
    }
}