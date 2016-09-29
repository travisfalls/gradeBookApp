import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//Create Variables
		int option = 0;
		String studentName = " ";
		System.out.println("Welcome to the Gradebook");
		Scanner userIn = new Scanner(System.in);
		ArrayList<Double> gradeBook = new ArrayList<Double>();
		
		
		//Menu Loop
		while(option!=6){
			
			//Print Main Menu
			System.out.println("-------------------------------------------");
			System.out.println("Please select an option from the list below:");
			System.out.println("1) Enter Values");
			System.out.println("2) Modify Entry");
			System.out.println("3) Delete Entry");
			System.out.println("4) View Stats");
			System.out.println("5) View All Entries");
			System.out.println("6) Exit program");
			
			//User to Select Option
			option = userIn.nextInt();
			
			
			//Option 1 Enter Values
			if(option==1){
				System.out.println("Please student Name & enter values. Type -1 to exit.");
				double gradeBookEntry = 0;
				studentName = userIn.next();
				
				//While Loop for enter data
				while (true) {
					gradeBookEntry = userIn.nextDouble();
					
					//Exit if -1
					if(gradeBookEntry==-1){
						break;
					} else {
						gradeBook.add(gradeBookEntry);
					}
				}
			}
			
			//Option 2 - Modify Entry
			if(option==2){
				System.out.println("Which index would you like to modify?");
				int index = userIn.nextInt();
				System.out.println("Replace Index:" + index + " Value: " + gradeBook.get(index) + " with what?");
				gradeBook.set(index, userIn.nextDouble());
				System.out.println("Successfully Set");
			}
			
			//Option 3 - Delete Entry
			if(option==3) {
			System.out.println("Which index would you like to delte?");
				int index = userIn.nextInt();
				gradeBook.remove(index);
				System.out.println("Removed");
			}
			
			//Option 5 - View Elements
			if(option==5){
				System.out.println("Student Name: " + studentName);
				System.out.println("|Index| Value");
				for(int i=0; i < gradeBook.size();i++){
					//Create Rows
					System.out.println("|  " + i + "  | " + gradeBook.get(i));
				}
			}
			
			//Option 4 - View Stats
			if(option==4){
				//Calculate Average
				double total = 0;
				for(int i = 0; i < gradeBook.size();i++){
					total += gradeBook.get(i);
				}
				double average = total/gradeBook.size();
				
				//Sort gradeBook
				ArrayList<Double> copiedGradeBook = new ArrayList<Double>();
				copiedGradeBook.addAll(gradeBook);
				Collections.sort(copiedGradeBook);
				//Extract max and min
				double max = copiedGradeBook.get(gradeBook.size()-1); //This finds size of grade book and subtracts 1													  //to get the very last number in the array
				double min = copiedGradeBook.get(0);
				
				double median=0;
				//Find Median
				if(copiedGradeBook.size()%2==1){
					median = copiedGradeBook.get(copiedGradeBook.size()/2);
				} else {
					int secondIndex = copiedGradeBook.size()/2;
					double firstMedian = copiedGradeBook.get(secondIndex - 1);
					double secondMedian = copiedGradeBook.get(secondIndex);
					median = (firstMedian+secondMedian)/2.0;
				}
				
				System.out.println("Database Stats");
				System.out.println("Average:  " + average);
				System.out.println("Min:      " + min);
				System.out.println("Max:      " + max);
				System.out.println("Median:   " + median);
				System.out.println("Elements: " + gradeBook.size());
				
				
				
			}
		}		
		
	}
	
}
