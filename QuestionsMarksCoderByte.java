package generalPrograms;
import java.util.*; 
import java.io.*;

class QuestionsMarksCoderByte {

  public static String QuestionsMarks(String str) {
    int[] pos = new int[str.length()];
		
		for(int i=0,j=0;i<str.length();i++) {
			if((int)str.charAt(i)>=48 && (int)str.charAt(i)<=57) {
				//System.out.println(i+","+j);
				pos[j]=i;
				j++;
			}
		}
		
		for(int i=0,j=1;i<pos.length;i++,j++) {
			int count = 0;
			if(pos[i]>0 && pos[j]>0)
			{
				if((str.charAt(pos[i])-48) + (str.charAt(pos[j])-48) == 10)
				{			
					if(Math.abs(pos[i]-pos[j])>3) 
					{	
						for(int k=pos[i]+1;k<pos[j];k++) 
						{
							if(str.charAt(k)=='?')
								count++;
						}
					}
					
					if(count ==3) {
						//System.out.println("true between numbers"+(str.charAt(pos[i])-48)+" and "+(str.charAt(pos[j])-48));
					return "true";
					}
				}
				else 
					//System.out.println("false between numbers"+(str.charAt(pos[i])-48)+" and "+(str.charAt(pos[j])-48));
					return "false";
			}
		}
		
		return "false";
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(QuestionsMarks(s.nextLine())); 
  }

}