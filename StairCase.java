package generalPrograms;

public class StairCase {
	public static void main(String[] args) {
		int steps = 6;
		int jumps[] = {1,3,5};
		int climbingWays[] = new int[steps+1];
		climbingWays[0]=1;
		//climbingWays[1]=1;
		for(int i=1;i<=steps;i++) {
			int total=0;
			for (int j:jumps) {
				if(i-j>=0)
					total += climbingWays[i-j];
				climbingWays[i] = total;
			}
		}
		for (int i : climbingWays) {
			System.out.println(i);
		}	
	}

}
