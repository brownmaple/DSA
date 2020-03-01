package generalPrograms;

import java.util.Arrays;

public class SubStringInMainString {

    public static void test(){}

    public static void main(String[] args) {
        String mString = "cbaebabcd";
        int mStrLen = mString.length();
        int[] mStrArray = new int[256];
        Arrays.fill(mStrArray,0);

        String pattern = "abc";
        int patternLen = pattern.length();
        int[] patternArray = new int[256];
        Arrays.fill(patternArray,0);

        for(int i=0;i<patternLen;i++){
            patternArray[pattern.charAt(i)]++;
        }

        for(int i=0;i<mStrLen;i++){
            mStrArray[mString.charAt(i)]++;
        }

        SubStringInMainString sims = new SubStringInMainString();

    }
}
