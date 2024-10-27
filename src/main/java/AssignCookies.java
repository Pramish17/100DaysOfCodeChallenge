import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g ={1,2,3};
        int[] s= {1,1};

        System.out.println(findContentChildren(g,s));
    }

    private static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int aPointer = 0;
        int bPointer = 0;

        while(aPointer<g.length && bPointer<s.length){
            if(g[aPointer]<=s[bPointer]){
                aPointer++;
                bPointer++;
            }else{
                bPointer++;
            }
        }

        return aPointer;
    }
}
