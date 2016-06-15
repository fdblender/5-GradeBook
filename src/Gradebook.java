
/* Gradebook.java
 * F. Blendermann
 * Write an application that will accept the user input as long as it continues.
 * At any point the user should be able to request a report of the following:
 * Number of Students
* Overall Average
* Average for Gender
* Average for Major
* Average by State
*/
import java.util.Scanner;

public class Gradebook {
	
	/*public void printReport(int lastRecord) {
		for(int i=0; i<=lastRecord;i++) {
			System.out.print(name[i]+" "+letterGrade[i]+
					" "+gender[i]+" "+major[i]+" "+state[i]+" "+avg[i]);
		}

		System.out.println(" ");
	}*/

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int MAX_ARRAY = 50;		
		String name[] = new String[MAX_ARRAY];
		String letterGrade[] = new String[MAX_ARRAY];		
		String gender[] = new String[MAX_ARRAY];
		String major[] = new String[MAX_ARRAY];
		String state[] = new String[MAX_ARRAY];
		float avg[] = new float[MAX_ARRAY];
		String enterMore, wantReport;
		boolean more = true;
		int index = 0;
		float overallSum = 0.0f;
		int M = 0; int F = 1;
		float genderSum[] = {0.0f, 0.0f};
		int genderCount[] = {0,0};
		int ECON = 0, CS=1, EE=2;		
		float majorSum[] = {0.0f,0.0f,0.0f};
		int majorCount[] = {0,0,0};
		int MD=0, DC=1, VA=2;
		float stateSum[] = {0.0f,0.0f,0.0f};
		int stateCount[] = {0,0,0};		
		
		while (more) {
			
			System.out.print("Enter the name: ");
			name[index] = keyboard.next();			
			System.out.print("Enter the letter grade: ");
			letterGrade[index] = keyboard.next();
			System.out.print("Enter the gender: ");
			gender[index] = keyboard.next();
			System.out.print("Enter the major: ");
			major[index] = keyboard.next();

			System.out.print("Enter the state: ");
			state[index] = keyboard.next();
			System.out.print("Enter the average: ");
			avg[index] = keyboard.nextFloat();
			
			// keep track of report numbers
			overallSum = overallSum + avg[index];
			
			if (gender[index].equals("M")) {
				genderCount[M]++;
				genderSum[M] = genderSum[M] + avg[index];
			} else {
				genderCount[F]++;
				genderSum[F] = majorSum[F] + avg[index];
			}
			if (major[index].equals("ECON")) {
				majorCount[ECON]++;
				majorSum[ECON] = majorSum[ECON] + avg[index];
			} else if (major[index].equals("CS")){
				majorCount[CS]++;
				majorSum[CS] = majorSum[CS] + avg[index];
			} else if (major[index].equals("EE")){
				majorCount[EE]++;
				majorSum[EE] = majorSum[EE] + avg[index];
			}
			
			
			System.out.print("Do you want to print a report (y/n)? ");
			wantReport = keyboard.next();	
			if (wantReport.equals("y")) {
				System.out.println("\n------------- GRADE REPORT -------------");
				for(int i=0; i<=index;i++) {
					System.out.println(name[i]+" "+letterGrade[i]+" "+
							gender[i]+" "+major[i]+" "+
							state[i]+" "+avg[i]);
				}
				System.out.println("\nNo of Students: "+(index+1));
				System.out.println("Overall Average: "+(overallSum/(index+1)));
				if (genderCount[M] > 0) {
					System.out.print("Average for Males: "+genderSum[M]/genderCount[M]);
				}
				if (genderCount[F] > 0) {
					System.out.print(" Average for Females: "+genderSum[F]/genderCount[F]);
				}
				System.out.println("");
				if (majorCount[ECON] > 0) {
					System.out.print("Average for ECON: "+majorSum[ECON]/majorCount[ECON]);
				}
				if (majorCount[CS] > 0) 
				{System.out.print(" Average for CS: "+majorSum[CS]/majorCount[CS]);
				}
				if (majorCount[EE] > 0) {
					System.out.print(" Average for EE: "+majorSum[EE]/majorCount[EE]);
				}
				System.out.println("\n--------- END OF GRADE REPORT ---------");
			}
			
			System.out.println("\nDo you want to enter more? ");
			enterMore = keyboard.next();
			if (enterMore.equals("n")) {
				more = false;
			} else {
				index++;
			}
		}
		System.out.println("Exited Gradebook");
	}
}





