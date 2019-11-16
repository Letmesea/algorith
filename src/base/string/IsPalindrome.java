package base.string;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<j){
            //ch | 0b00100000  小写
            //ch & 0b11011111   大写
//            char ci = Character.toLowerCase(s.charAt(i));
//            char cj = Character.toLowerCase(s.charAt(j));
            char ci = (char)(s.charAt(i)| 0x20);
            char cj = (char)(s.charAt(j)|0x20);
            if((ci>='0'&&ci<='9')||(ci>='a'&&ci<='z')){
                if((cj>='0'&&cj<='9')||(cj>='a'&&cj<='z')){
                    if(ci!=cj){
                        return false;
                    }else{
                        i++;j--;
                    }
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String test = "le, ,vel";
        boolean res = isPalindrome(test);
        System.out.println(Character.toLowerCase('1'));
    }
}
