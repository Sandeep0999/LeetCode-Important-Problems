class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        int c = 0;
        for(char ch : text.toCharArray()){
            if(ch == 'b') b++;
            else if(ch == 'a') a++;
            else if(ch == 'l') l++;
            else if(ch == 'o') o++;
            else if(ch == 'n') n++;
        }
        while(b >= 1 && a >= 1 && l >= 2 && n >= 1 && o >= 2){
                c++;
                b--; a--; n--;
                o = o - 2;
                l = l - 2;
            }
        return c;
    }
}