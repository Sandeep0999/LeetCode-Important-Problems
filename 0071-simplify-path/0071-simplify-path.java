class Solution {
    public String simplifyPath(String path) {
        String str[] = path.split("/");
        Stack<String> st = new Stack<>();
        for(String i : str){
            if(i.equals("") || i.equals(".")) continue;
            else if(i.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else st.push(i);
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(String i : st) sb.append("/").append(i);
        return sb.toString();
    }
}