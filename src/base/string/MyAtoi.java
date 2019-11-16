package base.string;

public class MyAtoi {
    public static int myAtoi(String str) {
        int l=str.length(),i=0;
        while (i<l){
            if(str.charAt(i)==' ')
                i++;
            else
                break;
        }
        if(i<l){
            char c = str.charAt(i);
            if(c!='+'&&c!='-'&&(c<'0'||c>'9')){
                return 0;
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                if(c=='+'||c=='-'){
                    sb.append('0');
                }
                i++;
                for (;i<l;i++){
                    char c1 = str.charAt(i);
                    if(c1!='+'&&c1!='-'&&(c1>='0'&&c1<='9')){
                        sb.append(c1);
                    }else{
                        break;
                    }
                }
                try {
                    return Integer.valueOf(sb.toString());
                }catch (Exception e){
                    if(c!='-'){
                        return Integer.MAX_VALUE;
                    }else{
                        return Integer.MIN_VALUE;
                    }
                }
            }
        }else{
            return 0;
        }
    }
    public static int myAtoi1(String str) {
        int l=str.length(),i=0;
        while (i<l){
            if(str.charAt(i)==' ')
                i++;
            else
                break;
        }
        if(i<l){
            char c = str.charAt(i);
            if(c!='+'&&c!='-'&&(c<'0'||c>'9')){
                return 0;
            }else{
                i++;
                int res=0;
                if(c!='+'&&c!='-'){
                    res+=c-'0';
                }
                for(;i<l;i++){
                    char c1 = str.charAt(i);
                    if(c1>='0'&&c1<='9'){
                        if(c!='-'){
                            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&c1>'7'))
                                return Integer.MAX_VALUE;
                            res = res*10+(c1-'0');
                        }else{
                            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&-1*(c1-'0')<-8))
                                return Integer.MIN_VALUE;
                            res = res*10+(-1*(c1-'0'));
                        }
                    }else{
                        break;
                    }
                }
                return res;
            }
        }else{
            return 0;
        }
    }
    public static void main(String [] args){
       int res =  myAtoi1("42");
       System.out.print(res);
    }
}
