public class Rough {
    public static void main(String[] args){
        String key = "ColtA";
        int length = key.length();
        int i = 0;
        int sum =  0;
        while(i<length){
            String pair = "";
            if(i+1==length){
                pair = key.charAt(i)+"N";
            }
            else{
                //char ch1 = key.charAt(i);
                //char ch2 = key.charAt(i+1);
                pair = key.charAt(i)+""+key.charAt(i+1);// SUBSTRING USE KORSI EKHANE
            }
            int ascii1 = (int) pair.charAt(0);
            int ascii2 = (int) pair.charAt(1);
            int reqAscii = concatenate1(ascii1, ascii2);
            sum+= reqAscii;
            i+=2;
        }
    }
    public static int concatenate1( int a, int b ){
        int btem = b;
        int length = 0;
        while(btem!=0){
            btem = btem/10;
            length++;
        }
        return (int) (Math.pow(10,length)*a + b);
    }
}
