package chucknorris;
import java.util.Scanner;

public class Main {

    public static String padLeftzeroes(String str){
        while(str.length()<7){
            str=0+str;
        }
        return str;
    }

    public static String toBinary(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            // str1=str1+str.charAt(i)+" ";
            char c = s.charAt(i);
            String str1 = Integer.toBinaryString(c);
            if (str1.length() < 7)
                str1 = padLeftzeroes(str1);
            str = str + str1;
            // System.out.printf("%c = %s%n",c,str1);
        }
        return str;
    }
    public static String encode(String string){
        String s=toBinary(string);
        String str="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                str=str+"00 ";
                while(i<s.length()&&s.charAt(i)=='0'){
                    str=str+'0';
                    i++;
                }
                str=str+" ";
                i--;
            }
            else{
                str=str+"0 ";
                while(i<s.length()&&s.charAt(i)!='0'){
                    str=str+'0';
                    i++;
                }
                str=str+" ";
                i--;
            }

        }
        return str;
    }
    public static String decode(String str){
        if(str.length()==0){
            return null;
        }
        String str1="";
        boolean isChar=true;
        char c=0;
        for(int i=0;i<str.length();i++){
            if(isChar){
                isChar=false;
                if(i<str.length()-1&&str.charAt(i)=='0'&&str.charAt(i+1)=='0'){
                    c='0';
                    i+=2;
                }

                else {
                    c='1';
                    i++;
                }

            }else{
                while(i<str.length()&&str.charAt(i)!=' '){
                    str1=str1+c;
                    i++;
                }

                isChar=true;
            }

        }
        return  str1;
    }

    public static String convertToCharacters(String str){
        if(str.length()==0){
            return null;
        }
        String cString="";
        String str1="";
        int i=0;
        char c=0;
        while(i<str.length()){
            if(i>0&&i%7==0){
                c=(char) Integer.parseInt(cString,2);
                str1=str1+c;
                cString=""+str.charAt(i);
            }else{
                cString=cString+str.charAt(i);
            }
            i++;
        }
        c=(char) Integer.parseInt(cString,2);
        str1=str1+c;
        cString="";
        return str1;
    }
    public static boolean isValid(String str){
        if(str.charAt(0)!='0')
            return false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='0')
                if(str.charAt(i)!=' ')
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);


        while(true){
            System.out.println("Please input operation (encode/decode/exit):");
            String choice=s.nextLine();
            if("encode".equals(choice)){
                System.out.println("Input string:");
                String str=s.nextLine();
                String str1=encode(str);
                System.out.println("Encoded string:");
                System.out.println(str1);
            }
            else if("decode".equals(choice)){
                System.out.println("Input encoded string:");
                String str=s.nextLine();
                if(!isValid(str)){
                    System.out.println("Encoded string is not valid.");
                    continue;
                }

                String str1=decode(str);
                if(str1.length()%7!=0){
                    System.out.println("Encoded string is not valid.");
                    continue;
                }
                String result=convertToCharacters(str1);
                System.out.println("Decoded string:");
                System.out.println(result);
            }
            else if("exit".equals(choice)){
                System.out.println("Bye!");
                break;
            }
            else{
                System.out.printf("There is no '%s' operation%n",choice);
            }
        }

    }
}