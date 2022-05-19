import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

public class Main {
	Scanner sc = new Scanner(System.in);
	int student;
	int student2;
	int day;
	int selection;
	int avgSelection;
	int minSelection;
	int maxSelection;
	int rangeSelection;
	int healthSelection;
	int varianceSelection;
	int deviationSelection;
	students s1;
	boolean menu = true;

	public static void main(String[] args) throws IOException {
		new Main();
	}

	public Main() throws IOException {
		FileReader input = new FileReader("data.json");
		Gson gson = new Gson();
		s1 = gson.fromJson(input, students.class);
		System.out.format("Data Project - Ryan & Nathan%n");
		System.out.format("%n");
		System.out.format("Notes:%n- 'NaN' = No a Number, Used When Values are Equal to 0.00 or No Value is Entered%n");
		System.out.format("- For Students: Input Numbers Between (0-23), #0 = Student 1 and Etc%n");
		System.out.format("- For Days: Input Numbers Between(0-6), #0 = Day 1 and Etc%n");
		System.out.format("%n");
		System.out.format("Press 1 to Start%n");
		selection = getInt();
		if (selection == 1) {
			if (menu) {
				main();
			}
		}
	}

	public int getInt() {
		return sc.nextInt();
	}
	public int selectionCategory() {
		System.out.println("Enter a Number for the Avg of that Category");
		System.out.println("1 - Sleep");
		System.out.println("2 - Sugar");
		System.out.println("3 - Phone");
		System.out.println("4 - Fruit");
		System.out.println("5 - Vegetables");
		System.out.println("6 - Caffeine");
		System.out.println("7 - Strength");
		System.out.println("8 - Moderate");
		System.out.println("9 - High");
		System.out.println("10 - Steps");
		selection = getInt();
		return selection;
	}
	public void main() {
		System.out.format("Menu:%nPress 1 - Table Students Information%nPress 2 - Table Student Information%nPress 3 - Utilities%nPress 4 - Exit%n");
		selection = getInt();
		if (selection == 1) {
			displayStudentInformationTable(s1, student);
			main();

		}else if (selection == 2) {
			System.out.format("Student Information:%nPress 1 - All 7 Days%nPress 2 - Select A Certain Day%n");
			selection = getInt();
			if (selection == 1) {
				System.out.println("Enter a Number for the Student: 0-23");
				student = getInt(); //0-23
				displaySubjectsAllDays(s1, student);
				main();

			}else if (selection == 2) {
				System.out.println("Enter a Number for the Student: (0-23)");
				student = getInt(); //0-23
				System.out.format("Enter a Number for the Day: (0-6)%n");
				day = getInt();
				displaySubjects1Day(s1, student, day);
				main();
			}
		}else if (selection == 3) {
			System.out.format("Utilities:%nPress 1 - Average%nPress 2- Minimum%nPress 3 - Maximum%nPress 4 - Range%nPress 5 - Health Check%nPress 6 - Statistical Analysis%nPress 7 - Compare Subjects%n");
			selection = getInt();

			//Avg
			if (selection == 1) {
				System.out.format("Average: %nPress 1 - Table of Average Values%nPress 2 - Individual Category Average%n");
				selection = getInt();
				if (selection == 1) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					weeklyAvgTable(s1, student);
					main();
				} else if (selection == 2){
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					avgSelection = selectionCategory();
					float average = weeklyAvg(s1, student, avgSelection);
					weeklyAvgCategory(average);
					main();
				}
			} else if (selection == 2) {
				System.out.format("Minimum:%nPress 1 - Table of Minimum Values%nPress 2 - Individual Category Minimum%n");
				selection = getInt();
				if (selection == 1) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					weeklyMinTable(s1, student);
					main();
				} else if (selection == 2) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					minSelection = selectionCategory();
					float minimum = weeklyMin(s1, student, minSelection);
					weeklyMinCategory(minimum);
					main();
				}
			} else if (selection == 3) {
				System.out.format("Minimum:%nPress 1 - Table of Maximum Values%nPress 2 - Individual Category Maximum%n");
				selection = getInt();

				if (selection == 1) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					weeklyMaxTable(s1, student);
					main();

				} else if (selection == 2) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					maxSelection = selectionCategory();
					float maximum = weeklyMax(s1, student, minSelection);
					weeklyMaxCategory(maximum);
					main();
				}
			}else if (selection == 4) {
				System.out.format("Minimum:%nPress 1 - Table of Range Values%nPress 2 - Individual Category Range%n");
				selection = getInt();

				if (selection == 1) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					weeklyRangeTable(s1, student);
					main();

				} else if (selection == 2) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					rangeSelection = selectionCategory();
					float range = weeklyRange(s1, student, rangeSelection);
					weeklyRangeCategory(range);
					main();
				}
			}else if (selection == 5) {
				System.out.println("Enter a Number for the Student: 0-23");
				student = getInt(); //0-23
				healthSelection= selectionCategory();
				healthCheck(s1, student, healthSelection);
				main();

			}else if (selection == 6) {
				System.out.format("Press 1 - Variance%nPress 2 - Standard Deviation%n");
				selection = getInt();
				if (selection == 1) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					varianceTable(s1, student);
					main();
				} else if (selection == 2) {
					System.out.println("Enter a Number for the Student: 0-23");
					student = getInt(); //0-23
					deviationTable(s1, student);
					main();
				}
			} else if (selection == 7){
				System.out.format("Compare:%nPress 1 - Basic Information%nPress 2 - Average%nPress 3 - Minimum%nPress 4 - Maximum%nPress 5 - Variance%nPress 6 - Standard Deviation%n");
				selection = getInt();
				if (selection == 1){
					System.out.format("Press 1 - 1 Day%nPress 2 - All 7 Days%n");
					selection = getInt();
					if (selection == 1) {
						System.out.println("Enter a Number for the First Student: 0-23");
						student = getInt(); //0-23
						System.out.println("Enter a Number for the Second Student: 0-23");
						student2 = getInt(); //0-23
						System.out.format("Enter a Number for the Day: 0-6%n");
						day = getInt();
						compareStudentsDay(s1, student, student2, day);
						main();
					}else if (selection == 2) {
						System.out.println("Enter a Number for the First Student: 0-23");
						student = getInt(); //0-23
						System.out.println("Enter a Number for the First Student: 0-23");
						student2 = getInt(); //0-23
						compareStudentsAllDays(s1, student, student2);
						main();
					}
				} else if (selection == 2) {
					System.out.println("Enter a Number for the First Student: 0-23");
					student = getInt(); //0-23
					System.out.println("Enter a Number for the Second Student: 0-23");
					student2 = getInt(); //0-23
					compareStudentsAvg(s1, student, student2);
					main();
				} else if (selection == 3) {
					System.out.println("Enter a Number for the First Student: 0-23");
					student = getInt(); //0-23
					System.out.println("Enter a Number for the Second Student: 0-23");
					student2 = getInt(); //0-23
					compareStudentsMin(s1, student, student2);
					main();
				} else if(selection == 4) {
					System.out.println("Enter a Number for the First Student: 0-23");
					student = getInt(); //0-23
					System.out.println("Enter a Number for the Second Student: 0-23");
					student2 = getInt(); //0-23
					compareStudentsMax(s1, student, student2);
					main();
				} else if (selection == 5){
					System.out.println("Enter a Number for the First Student: 0-23");
					student = getInt(); //0-23
					System.out.println("Enter a Number for the Second Student: 0-23");
					student2 = getInt(); //0-23
					compareStudentsVariance(s1, student, student2);
					main();
				} else if (selection == 6) {
					System.out.println("Enter a Number for the First Student: 0-23");
					student = getInt(); //0-23
					System.out.println("Enter a Number for the Second Student: 0-23");
					student2 = getInt(); //0-23
					compareStudentsDeviation(s1, student, student2);
					main();
				}
			}
		}else if (selection == 4) {
			menu = false;
		}
	}

	//Display Students and Information
	public void displayStudentInformationTable(students s1, int student) {
		for (int k = 0; k < s1.students.size(); k++) {
			System.out.format("Student: %d%n",s1.students.get(k).getId());
			System.out.format("--------------------------------------------%n");
			for (int i = 0; i < s1.students.get(k).getDays().size(); i++){
				System.out.format("Day: %d%n", i+1);
				if (s1.students.get(k).getDays().get(day).getSleep() == 0f) {
					System.out.format("Minutes of Sleep:%27s%n", "NaN");
				}else {
					System.out.format("Minutes of Sleep:%27.2f%n", s1.students.get(k).getDays().get(i).getSleep());
				}
				if (s1.students.get(k).getDays().get(i).getSugar() == 0f) {
					System.out.format("Sugar Drinks:%31s%n", "NaN");
				}else {
					System.out.format("Sugar Drinks:%31.2f%n", s1.students.get(k).getDays().get(i).getSugar());
				}
				if (s1.students.get(k).getDays().get(i).getPhone() == 0f) {
					System.out.format("Minutes on Phone:%27s%n", "NaN");
				}else {
					System.out.format("Minutes on Phone: %26.2f%n", s1.students.get(k).getDays().get(i).getPhone());
				}
				if (s1.students.get(k).getDays().get(i).getFruit() == 0f) {
					System.out.format("Serving of Fruit:%27s%n", "NaN");
				}else {
					System.out.format("Serving of Fruit:%27.2f%n", s1.students.get(k).getDays().get(i).getFruit());
				}
				if (s1.students.get(k).getDays().get(i).getVegetables() == 0f) {
					System.out.format("Serving of Vegetables:%22s%n", "NaN");
				}else {
					System.out.format("Serving of Vegetables:%22.2f%n", s1.students.get(k).getDays().get(i).getVegetables());
				}
				if (s1.students.get(k).getDays().get(i).getCaffeine() == 0f) {
					System.out.format("Caffeine Drinks:%28s%n", "NaN");
				}else {
					System.out.format("Caffeine Drinks:%28.2f%n",s1.students.get(k).getDays().get(i).getCaffeine());
				}
				if (s1.students.get(k).getDays().get(i).getStrength() == 0f) {
					System.out.format("Minutes of Strength Training:%15s%n", "NaN");
				}else {
					System.out.format("Minutes of Strength Training:%15.2f%n",s1.students.get(k).getDays().get(i).getStrength());
				}
				if (s1.students.get(k).getDays().get(i).getModerate() == 0f) {
					System.out.format("Minutes of Moderate Training:%15s%n", "NaN");
				}else {
					System.out.format("Minutes of Moderate Training:%15.2f%n",s1.students.get(k).getDays().get(i).getModerate());
				}
				if (s1.students.get(k).getDays().get(i).getHigh() == 0f) {
					System.out.format("Minutes of High Intense Training:%11s%n", "NaN");
				}else {
					System.out.format("Minutes of High Intense Training:%11.2f%n",s1.students.get(k).getDays().get(i).getHigh());
				}
				if (s1.students.get(k).getDays().get(i).getSteps() == 0f) {
					System.out.format("Steps Taken:%32s%n", "NaN");
				}else {
					System.out.format("Steps Taken:%32.2f%n", s1.students.get(k).getDays().get(i).getSteps());
				}
				System.out.format("--------------------------------------------%n");
			}
		}
	}
	public void displaySubjects1Day(students s1, int student, int day) {
		System.out.format("Student: %d%n",s1.students.get(student).getId());
		System.out.format("--------------------------------------------%n");
		System.out.format("Day: %d%n", day+1);
		if (s1.students.get(student).getDays().get(day).getSleep() == 0f) {
			System.out.format("Minutes of Sleep:%27s%n", "NaN");
		}else {
			System.out.format("Minutes of Sleep:%27.2f%n", s1.students.get(student).getDays().get(day).getSleep());
		}
		if (s1.students.get(student).getDays().get(day).getSugar() == 0f) {
			System.out.format("Sugar Drinks:%31s%n", "NaN");
		}else {
			System.out.format("Sugar Drinks:%31.2f%n", s1.students.get(student).getDays().get(day).getSugar());
		}
		if (s1.students.get(student).getDays().get(day).getPhone() == 0f) {
			System.out.format("Minutes on Phone:%26s%n", "NaN");
		}else {
			System.out.format("Minutes on Phone: %26.2f%n", s1.students.get(student).getDays().get(day).getPhone());
		}
		if (s1.students.get(student).getDays().get(day).getFruit() == 0f) {
			System.out.format("Serving of Fruit:%27s%n", "NaN");
		}else {
			System.out.format("Serving of Fruit:%27.2f%n", s1.students.get(student).getDays().get(day).getFruit());
		}
		if (s1.students.get(student).getDays().get(day).getVegetables() == 0f) {
			System.out.format("Serving of Vegetables:%22s%n", "NaN");
		}else {
			System.out.format("Serving of Vegetables:%22.2f%n", s1.students.get(student).getDays().get(day).getVegetables());
		}
		if (s1.students.get(student).getDays().get(day).getCaffeine() == 0f) {
			System.out.format("Caffeine Drinks:%28s%n", "NaN");
		}else {
			System.out.format("Caffeine Drinks:%28.2f%n",s1.students.get(student).getDays().get(day).getCaffeine());
		}
		if (s1.students.get(student).getDays().get(day).getStrength() == 0f) {
			System.out.format("Minutes of Strength Training:%15s%n", "NaN");
		}else {
			System.out.format("Minutes of Strength Training:%15.2f%n",s1.students.get(student).getDays().get(day).getStrength());
		}
		if (s1.students.get(student).getDays().get(day).getModerate() == 0f) {
			System.out.format("Minutes of Moderate Training:%15s%n", "NaN");
		}else {
			System.out.format("Minutes of Moderate Training:%15.2f%n",s1.students.get(student).getDays().get(day).getModerate());
		}
		if (s1.students.get(student).getDays().get(day).getHigh() == 0f) {
			System.out.format("Minutes of High Intense Training:%11s%n", "NaN");
		}else {
			System.out.format("Minutes of High Intense Training:%11.2f%n",s1.students.get(student).getDays().get(day).getHigh());
		}
		if (s1.students.get(student).getDays().get(day).getSteps() == 0f) {
			System.out.format("Steps Taken:%32s%n", "NaN");
		}else {
			System.out.format("Steps Taken:%32.2f%n", s1.students.get(student).getDays().get(day).getSteps());
		}
		System.out.format("--------------------------------------------%n");
	}
	public void displaySubjectsAllDays(students s1, int student) {
		System.out.format("Student: %d%n",s1.students.get(student).getId());
		System.out.format("--------------------------------------------%n");
		for (int i = 0; i < s1.students.get(student).getDays().size(); i++){
			System.out.format("Day: %d%n", i+1);
			if (s1.students.get(student).getDays().get(i).getSleep() == 0f) {
				System.out.format("Minutes of Sleep:%27s%n", "NaN");
			}else {
				System.out.format("Minutes of Sleep:%27.2f%n", s1.students.get(student).getDays().get(i).getSleep());
			}
			if (s1.students.get(student).getDays().get(i).getSugar() == 0f) {
				System.out.format("Sugar Drinks:%31s%n", "NaN");
			}else {
				System.out.format("Sugar Drinks:%31.2f%n", s1.students.get(student).getDays().get(i).getSugar());
			}
			if (s1.students.get(student).getDays().get(i).getPhone() == 0f) {
				System.out.format("Minutes on Phone:%26s%n", "NaN");
			}else {
				System.out.format("Minutes on Phone: %26.2f%n", s1.students.get(student).getDays().get(i).getPhone());
			}
			if (s1.students.get(student).getDays().get(i).getFruit() == 0f) {
				System.out.format("Serving of Fruit:%27s%n", "NaN");
			}else {
				System.out.format("Serving of Fruit:%27.2f%n", s1.students.get(student).getDays().get(i).getFruit());
			}
			if (s1.students.get(student).getDays().get(i).getVegetables() == 0f) {
				System.out.format("Serving of Vegetables:%22s%n", "NaN");
			}else {
				System.out.format("Serving of Vegetables:%22.2f%n", s1.students.get(student).getDays().get(i).getVegetables());
			}
			if (s1.students.get(student).getDays().get(i).getCaffeine() == 0f) {
				System.out.format("Caffeine Drinks:%28s%n", "NaN");
			}else {
				System.out.format("Caffeine Drinks:%28.2f%n",s1.students.get(student).getDays().get(i).getCaffeine());
			}
			if (s1.students.get(student).getDays().get(i).getStrength() == 0f) {
				System.out.format("Minutes of Strength Training:%15s%n", "NaN");
			}else {
				System.out.format("Minutes of Strength Training:%15.2f%n",s1.students.get(student).getDays().get(i).getStrength());
			}
			if (s1.students.get(student).getDays().get(i).getModerate() == 0f) {
				System.out.format("Minutes of Moderate Training:%15s%n", "NaN");
			}else {
				System.out.format("Minutes of Moderate Training:%15.2f%n",s1.students.get(student).getDays().get(i).getModerate());
			}
			if (s1.students.get(student).getDays().get(i).getHigh() == 0f) {
				System.out.format("Minutes of High Intense Training:%11s%n", "NaN");
			}else {
				System.out.format("Minutes of High Intense Training:%11.2f%n",s1.students.get(student).getDays().get(i).getHigh());
			}
			if (s1.students.get(student).getDays().get(i).getSteps() == 0f) {
				System.out.format("Steps Taken:%32s%n", "NaN");
			}else {
				System.out.format("Steps Taken:%32.2f%n", s1.students.get(student).getDays().get(i).getSteps());
			}
			System.out.format("--------------------------------------------%n");
		}
	}

	//Avg
	public float weeklyAvg(students s1, int student, int avgSelection) {
		float avg = 0;
		int zeroValue = 0;
		if (avgSelection == 1){
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getSleep() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getSleep();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if (avgSelection == 2){
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getSugar() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getSugar();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 3) {
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getPhone() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getPhone();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 4){
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getFruit() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getFruit();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 5) {
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getVegetables() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getVegetables();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 6) {
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getCaffeine() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getCaffeine();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 7) {
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getStrength() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getStrength();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 8) {
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getModerate() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getModerate();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 9){
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getHigh() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getHigh();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		} else if(avgSelection == 10) {
			for (int i = 0; i <= s1.students.get(student).getDays().size() -1; i ++) {
				if (s1.students.get(student).getDays().get(i).getSteps() == 0) {
					zeroValue += 1;
				} else {
					avg += s1.students.get(student).getDays().get(i).getSteps();
				}
			}
			avg = avg / (s1.students.get(student).getDays().size() - zeroValue);
		}
		return avg;
	}
	public void weeklyAvgTable(students s1, int student) {
		System.out.format("Student: %d%n", s1.students.get(student).getId());
		System.out.format("------------------------------------------------------%n");
		if (weeklyAvg(s1, student, 1) == 0f) {
			System.out.format("Average Minutes of Sleep: %28s%n","NaN");
		}else {
			System.out.format("Average Minutes of Sleep: %28.2f%n",weeklyAvg(s1, student, 1));
		}
		if (weeklyAvg(s1, student, 2) == 0f) {
			System.out.format("Average Sugary Drinks: %31s%n", "NaN");
		}else {
			System.out.format("Average Sugary Drinks: %31.2f%n", weeklyAvg(s1, student, 2));
		}
		if (weeklyAvg(s1, student, 3) == 0f) {
			System.out.format("Average Minutes on Phone: %28s%n","NaN");
		}else {
			System.out.format("Average Minutes on Phone: %28.2f%n",weeklyAvg(s1, student, 3));
		}
		if (weeklyAvg(s1, student, 4) == 0f) {
			System.out.format("Average Servings of Fruit: %27s%n","NaN");
		}else {
			System.out.format("Average Servings of Fruit: %27.2f%n",weeklyAvg(s1, student, 4));
		}
		if (weeklyAvg(s1, student, 5) == 0f) {
			System.out.format("Average Servings of Vegetables: %22s%n","NaN");
		}else {
			System.out.format("Average Servings of Vegetables: %22.2f%n",weeklyAvg(s1, student, 5));
		}
		if (weeklyAvg(s1, student, 6) == 0f) {
			System.out.format("Average Caffeinated Drinks: %26s%n","NaN");
		}else {
			System.out.format("Average Caffeinated Drinks: %26.2f%n",weeklyAvg(s1, student, 6));
		}
		if (weeklyAvg(s1, student, 7) == 0f) {
			System.out.format("Average Minutes of Strength Training: %16s%n","NaN");
		}else {
			System.out.format("Average Minutes of Strength Training: %16.2f%n",weeklyAvg(s1, student, 7));
		}
		if (weeklyAvg(s1, student, 8) == 0f) {
			System.out.format("Average Minutes of Moderate Intensity Training: %6s%n","NaN");
		}else {
			System.out.format("Average Minutes of Moderate Intensity Training: %6.2f%n",weeklyAvg(s1, student, 8));
		}
		if (weeklyAvg(s1, student, 9) == 0f) {
			System.out.format("Average Minutes of High Intensity Training: %10s%n","NaN");
		}else {
			System.out.format("Average Minutes of High Intensity Training: %10.2f%n",weeklyAvg(s1, student, 9));
		}
		if (weeklyAvg(s1, student, 10) == 0f) {
			System.out.format("Average Amount of Steps: %29s%n","NaN");
		}else {
			System.out.format("Average Amount of Steps: %29.2f%n",weeklyAvg(s1, student, 10));
		}
		System.out.format("------------------------------------------------------%n");
	}
	public void weeklyAvgCategory(float average) {
		if (avgSelection == 1) {
			System.out.format("On average Student %d received %.2f Minutes of Sleep in One Week%n",s1.students.get(student).getId(), average);
		} else if (avgSelection == 2) {
			System.out.format("On Average Student %d Consumed %.2f Sugary Drinks in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 3) {
			System.out.format("On average Student %d Spent %.2f Minutes On Their Phone in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 4) {
			System.out.format("On average Student %d Consumed %.2f Servings of Fruit in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 5) {
			System.out.format("On average Student %d Consumed %.2f Servings of Vegetables in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 6) {
			System.out.format("On average Student %d Consumed %.2f Caffeinated Drinks in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 7) {
			System.out.format("On average Student %d Performed %.2f Minutes of Strength Training in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 8) {
			System.out.format("On average Student %d Performed %.2f Minutes of Moderate Intense Training in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 9) {
			System.out.format("On average Student %d Performed %.2f Minutes of High Intense Training in One Week%n",s1.students.get(student).getId(), average);
		}else if (avgSelection == 10) {
			System.out.format("On average Student %d Took %.2f Steps in One Week%n",s1.students.get(student).getId(), average);
		}
	}


	//Min
	public float weeklyMin(students s1, int student, int minSelection) {
		float min = 10000000;
		float min2 = 10000000;
		if (minSelection == 1) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getSleep() != 0) {
					if (s1.students.get(student).getDays().get(i).getSleep() < min) {
						min = s1.students.get(student).getDays().get(i).getSleep();
					}
				}
			}
		} else if (minSelection == 2) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getSugar() != 0) {
					if (s1.students.get(student).getDays().get(i).getSugar() < min) {
						min = s1.students.get(student).getDays().get(i).getSugar();
					}
				}
			}
		} else if (minSelection == 3) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getPhone() != 0) {
					if (s1.students.get(student).getDays().get(i).getPhone() < min) {
						min = s1.students.get(student).getDays().get(i).getPhone();
					}
				}
			}
		} else if (minSelection == 4) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getFruit() != 0) {
					if (s1.students.get(student).getDays().get(i).getFruit() < min) {
						min = s1.students.get(student).getDays().get(i).getFruit();
					}
				}
			}
		} else if (minSelection == 5) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getVegetables() != 0) {
					if (s1.students.get(student).getDays().get(i).getVegetables() < min) {
						min = s1.students.get(student).getDays().get(i).getVegetables();
					}
				}
			}
		} else if (minSelection == 6) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getCaffeine() != 0) {
					if (s1.students.get(student).getDays().get(i).getCaffeine() < min) {
						min = s1.students.get(student).getDays().get(i).getCaffeine();
					}
				}
			}
		} else if (minSelection== 7) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getStrength() != 0) {
					if (s1.students.get(student).getDays().get(i).getStrength() < min) {
						min = s1.students.get(student).getDays().get(i).getStrength();
					}
				}
			}
		} else if (minSelection == 8) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getModerate() != 0) {
					if (s1.students.get(student).getDays().get(i).getModerate() < min) {
						min = s1.students.get(student).getDays().get(i).getModerate();
					}
				}
			}
		} else if (minSelection == 9) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getHigh() != 0) {
					if (s1.students.get(student).getDays().get(i).getHigh() < min) {
						min = s1.students.get(student).getDays().get(i).getHigh();
					}
				}
			}
		} else if (minSelection == 10) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getSteps() != 0) {
					if (s1.students.get(student).getDays().get(i).getSteps() < min) {
						min = s1.students.get(student).getDays().get(i).getSteps();
					}
				}
			}
		}
		if (min == min2) {
			min = 0.00f;
		}
		return min;
	}
	public void weeklyMinTable(students s1, int student) {
		System.out.format("Student: %d%n", s1.students.get(student).getId());
		System.out.format("------------------------------------------------------%n");
		if (weeklyMin(s1, student, 1) == 0f){
			System.out.format("Minimum Minutes of Sleep: %28s%n", "NaN");
		}else {
			System.out.format("Minimum Minutes of Sleep: %28.2f%n", weeklyMin(s1, student, 1));
		}
		if (weeklyMin(s1, student, 2) == 0f){
			System.out.format("Minimum Amount of Sugary Drinks: %21s%n", "NaN");
		}else {
			System.out.format("Minimum Amount of Sugary Drinks: %21.2f%n", weeklyMin(s1, student, 2));
		}
		if (weeklyMin(s1, student, 3) == 0f){
			System.out.format("Minimum Amount of Minutes on Phone: %18s%n", "NaN");
		}else {
			System.out.format("Minimum Amount of Minutes on Phone: %18.2f%n", weeklyMin(s1, student, 3));
		}
		if (weeklyMin(s1, student, 4) == 0f){
			System.out.format("Minimum Amount of Servings of Fruit: %17s%n", "NaN");
		}else {
			System.out.format("Minimum Amount of Servings of Fruit: %17.2f%n", weeklyMin(s1, student, 4));
		}
		if (weeklyMin(s1, student, 5) == 0f){
			System.out.format("Minimum Amount of Servings of Vegetables: %12s%n", "NaN");
		}else {
			System.out.format("Minimum Amount of Servings of Vegetables: %12.2f%n", weeklyMin(s1, student, 5));
		}
		if (weeklyMin(s1, student, 6) == 0f){
			System.out.format("Minimum Amount of Caffeinated Drinks: %16s%n", "NaN");
		}else {
			System.out.format("Minimum Amount of Caffeinated Drinks: %16.2f%n", weeklyMin(s1, student, 6));
		}
		if (weeklyMin(s1, student, 7) == 0f){
			System.out.format("Minimum Minutes of Strength Training: %16s%n", "NaN");
		}else {
			System.out.format("Minimum Minutes of Strength Training: %16.2f%n", weeklyMin(s1, student, 7));
		}
		if (weeklyMin(s1, student, 8) == 0f){
			System.out.format("Minimum Minutes of Moderate Intensity Training: %6s%n", "NaN");
		}else {
			System.out.format("Minimum Minutes of Moderate Intensity Training: %6.2f%n", weeklyMin(s1, student, 8));
		}
		if (weeklyMin(s1, student, 9) == 0f){
			System.out.format("Minimum Minutes of High Intensity Training: %10s%n", "NaN");
		}else {
			System.out.format("Minimum Minutes of High Intensity Training: %10.2f%n", weeklyMin(s1, student, 9));
		}
		if (weeklyMin(s1, student, 10) == 0f){
			System.out.format("Minimum Amount of Steps: %29s%n","NaN");
		}else {
			System.out.format("Minimum Amount of Steps: %29.2f%n",weeklyMin(s1, student, 10));
		}
		System.out.format("------------------------------------------------------%n");
	}
	public void weeklyMinCategory(float minimum){
		if (minSelection == 1) {
			System.out.format("Student %d: Minimum Minutes of Sleep was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		} else if (minSelection == 2) {
			System.out.format("Student %d: Minimum Number of Sugary Drinks was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}else if (minSelection == 3) {
			System.out.format("Student %d: Minimum Minutes on Their Phone was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}else if (minSelection == 4) {
			System.out.format("Student %d: Minimum Servings of Fruit was %.2f Over the Week%n",s1.students.get(student).getId(),minimum);
		}else if (minSelection == 5) {
			System.out.format("Student %d: Minimum Servings of Vegetables was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}else if (minSelection == 6) {
			System.out.format("Student %d: Minimum Number of Caffeinated Drinks was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}else if (minSelection == 7) {
			System.out.format("Student %d: Minimum Minutes of Strength Training was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}else if (minSelection == 8) {
			System.out.format("Student %d: Minimum Minutes of Moderate Intense Training was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}else if (minSelection == 9) {
			System.out.format("Student %d: Minimum Minutes of High Intense Training was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}else if (minSelection == 10) {
			System.out.format("Student %d Minimum Steps Taken was %.2f Over the Week%n",s1.students.get(student).getId(), minimum);
		}
	}

	//Max
	public float weeklyMax(students s1, int student, int maxSelection) {
		float max = 0;
		if (maxSelection == 1) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getSleep() > max) {
					max = s1.students.get(student).getDays().get(i).getSleep();
				}
			}
		} else if (maxSelection == 2) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getSugar() > max) {
					max = s1.students.get(student).getDays().get(i).getSugar();
				}
			}
		} else if (maxSelection == 3) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getPhone() > max) {
					max = s1.students.get(student).getDays().get(i).getPhone();
				}
			}
		} else if (maxSelection == 4) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getFruit() > max) {
					max = s1.students.get(student).getDays().get(i).getFruit();
				}
			}
		} else if (maxSelection == 5) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getVegetables() > max) {
					max = s1.students.get(student).getDays().get(i).getVegetables();
				}
			}
		} else if (maxSelection == 6) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getCaffeine() > max) {
					max = s1.students.get(student).getDays().get(i).getCaffeine();
				}
			}
		} else if (maxSelection == 7) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getStrength() > max) {
					max = s1.students.get(student).getDays().get(i).getStrength();
				}
			}
		} else if (maxSelection == 8) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getModerate() > max) {
					max = s1.students.get(student).getDays().get(i).getModerate();
				}
			}
		} else if (maxSelection == 9) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getHigh() > max) {
					max = s1.students.get(student).getDays().get(i).getHigh();
				}
			}
		} else if (maxSelection == 10) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				if (s1.students.get(student).getDays().get(i).getSteps() > max) {
					max = s1.students.get(student).getDays().get(i).getSteps();
				}
			}
		}
		return max;
	}
	public void weeklyMaxTable(students s1, int student) {
		System.out.format("Student: %d%n", s1.students.get(student).getId());
		System.out.format("------------------------------------------------------%n");
		if (weeklyMax(s1, student, 1) == 0) {
			System.out.format("Maximum Minutes of Sleep: %28s%n", "NaN");
		} else {
			System.out.format("Maximum Minutes of Sleep: %28.2f%n", weeklyMax(s1, student, 1));
		}
		if (weeklyMax(s1, student, 2) == 0) {
			System.out.format("Maximum Amount of Sugary Drinks: %21s%n", "NaN");
		} else {
			System.out.format("Maximum Amount of Sugary Drinks: %21.2f%n", weeklyMax(s1, student, 2));
		}
		if (weeklyMax(s1, student, 3) == 0) {
			System.out.format("Maximum Amount of Minutes on Phone: %18s%n", "NaN");
		} else {
			System.out.format("Maximum Amount of Minutes on Phone: %18.2f%n", weeklyMax(s1, student, 3));
		}
		if (weeklyMax(s1, student, 4) == 0) {
			System.out.format("Maximum Amount of Servings of Fruit: %17s%n", "NaN");
		} else {
			System.out.format("Maximum Amount of Servings of Fruit: %17.2f%n", weeklyMax(s1, student, 4));
		}
		if (weeklyMax(s1, student, 5) == 0) {
			System.out.format("Maximum Amount of Servings of Vegetables: %12s%n", "NaN");
		} else {
			System.out.format("Maximum Amount of Servings of Vegetables: %12.2f%n", weeklyMax(s1, student, 5));
		}
		if (weeklyMax(s1, student, 6) == 0) {
			System.out.format("Maximum Amount of Caffeinated Drinks: %16s%n", "NaN");
		} else {
			System.out.format("Maximum Amount of Caffeinated Drinks: %16.2f%n", weeklyMax(s1, student, 6));
		}
		if (weeklyMax(s1, student, 7) == 0) {
			System.out.format("Maximum Minutes of Strength Training: %16s%n", "NaN");
		} else {
			System.out.format("Maximum Minutes of Strength Training: %16.2f%n", weeklyMax(s1, student, 7));
		}
		if (weeklyMax(s1, student, 8) == 0) {
			System.out.format("Maximum Minutes of Moderate Intensity Training: %6s%n", "NaN");
		} else {
			System.out.format("Maximum Minutes of Moderate Intensity Training: %6.2f%n", weeklyMax(s1, student, 8));
		}
		if (weeklyMax(s1, student, 9) == 0) {
			System.out.format("Maximum Minutes of High Intensity Training: %10s%n", "NaN");
		} else {
			System.out.format("Maximum Minutes of High Intensity Training: %10.2f%n", weeklyMax(s1, student, 9));
		}
		if (weeklyMax(s1, student, 10) == 0) {
			System.out.format("Maximum Amount of Steps: %29s%n", "NaN");
		} else {
			System.out.format("Maximum Amount of Steps: %29.2f%n", weeklyMax(s1, student, 10));
		}
		System.out.format("------------------------------------------------------%n");
	}
	public void weeklyMaxCategory(float maximum){
		if (maxSelection == 1) {
			System.out.format("Student %d: Maximum Minutes of Sleep was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		} else if (maxSelection == 2) {
			System.out.format("Student %d: Maximum Number of Sugary Drinks was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}else if (maxSelection == 3) {
			System.out.format("Student %d: Maximum Minutes on Their Phone was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}else if (maxSelection == 4) {
			System.out.format("Student %d: Maximum Servings of Fruit was %.2f Over the Week%n",s1.students.get(student).getId(),maximum);
		}else if (maxSelection == 5) {
			System.out.format("Student %d: Maximum Servings of Vegetables was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}else if (maxSelection == 6) {
			System.out.format("Student %d: Maximum Number of Caffeinated Drinks was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}else if (maxSelection == 7) {
			System.out.format("Student %d: Maximum Minutes of Strength Training was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}else if (maxSelection == 8) {
			System.out.format("Student %d: Maximum Minutes of Moderate Intense Training was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}else if (maxSelection == 9) {
			System.out.format("Student %d: Maximum Minutes of High Intense Training was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}else if (maxSelection == 10) {
			System.out.format("Student %d: Maximum Steps Taken was %.2f Over the Week%n",s1.students.get(student).getId(), maximum);
		}
	}

	//Range
	public float weeklyRange(students s1, int student, int rangeSelection) {
		float range = 0;
		if (rangeSelection == 1) {
			range = weeklyMax(s1, student, 1) - weeklyMin(s1,student,1);
		} else if (rangeSelection == 2) {
			range = weeklyMax(s1, student, 2) - weeklyMin(s1,student,2);
		} else if (rangeSelection == 3) {
			range = weeklyMax(s1, student, 3) - weeklyMin(s1,student,3);
		} else if (rangeSelection == 4) {
			range = weeklyMax(s1, student, 4) - weeklyMin(s1,student,4);
		} else if (rangeSelection == 5) {
			range = weeklyMax(s1, student, 5) - weeklyMin(s1,student,5);
		} else if (rangeSelection == 6) {
			range = weeklyMax(s1, student, 6) - weeklyMin(s1,student,6);
		} else if (rangeSelection == 7) {
			range = weeklyMax(s1, student, 7) - weeklyMin(s1,student,7);
		} else if (rangeSelection == 8) {
			range = weeklyMax(s1, student, 8) - weeklyMin(s1,student,8);
		} else if (rangeSelection == 9) {
			range = weeklyMax(s1, student, 9) - weeklyMin(s1,student,9);
		} else if(rangeSelection == 10) {
			range = weeklyMax(s1, student, 10) - weeklyMin(s1,student,10);
		}
		return range;
	}
	public void weeklyRangeTable(students s1, int student) {
		System.out.format("Student: %d%n", s1.students.get(student).getId());
		System.out.format("-----------------------------------------------------%n");
		System.out.format("Range: Minutes of Sleep: %28.2f%n", weeklyRange(s1, student, 1));
		System.out.format("Range: Sugary Drinks Consumed: %22.2f%n", weeklyRange(s1, student, 2));
		System.out.format("Range: Minutes on Phone: %28.2f%n", weeklyRange(s1, student, 3));
		System.out.format("Range: Servings of Fruit: %27.2f%n", weeklyRange(s1, student, 4));
		System.out.format("Range: Servings of Vegetables: %22.2f%n", weeklyRange(s1, student, 5));
		System.out.format("Range: Caffeinated Drinks Consumed: %17.2f%n", weeklyRange(s1, student, 6));
		System.out.format("Range: Minutes of Strength Training: %16.2f%n", weeklyRange(s1, student, 7));
		System.out.format("Range: Minutes of Moderate Intensity Training: %6.2f%n", weeklyRange(s1, student, 8));
		System.out.format("Range: Minutes of High Intensity Training %11.2f%n", weeklyRange(s1, student, 9));
		System.out.format("Range: Number of Steps: %29.2f%n", weeklyRange(s1, student, 10));
		System.out.format("-----------------------------------------------------%n");

	}
	public void weeklyRangeCategory(float range) {
		if (rangeSelection == 1) {
			System.out.format("Student %d: Minutes of Sleep: Max <%.2f> - Min <%.2f> == Range <%.2f>%n", s1.students.get(student).getId(), weeklyMax(s1, student, 1), weeklyMin(s1,student,1), range);
		} else if (rangeSelection == 2) {
			System.out.format("Student %d: Amount of Sugary Drinks: Max <%.2f> - Min <%.2f> == Range <%.2f>%n", s1.students.get(student).getId(),weeklyMax(s1, student, 2), weeklyMin(s1,student,2), range);
		}else if (rangeSelection == 3) {
			System.out.format("Student %d: Minutes of Time Using Phone: Max <%.2f> - Min <%.2f> == Range <%.2f>%n",s1.students.get(student).getId(), weeklyMax(s1, student, 3), weeklyMin(s1,student,3), range);
		}else if (rangeSelection == 4) {
			System.out.format("Student %d: Servings of Fruit: Max <%.2f> - Min <%.2f> == Range <%.2f>%n", s1.students.get(student).getId(),weeklyMax(s1, student, 4), weeklyMin(s1,student,4), range);
		}else if (rangeSelection == 5) {
			System.out.format("Student %d: Servings of Vegetables: Max <%.2f> - Min <%.2f> == Range <%.2f>%n",s1.students.get(student).getId(), weeklyMax(s1, student, 5), weeklyMin(s1,student,5), range);
		}else if (rangeSelection == 6) {
			System.out.format("Student %d: Amount of Caffeinated Drinks: Max <%.2f> - Min <%.2f> == Range <%.2f>%n",s1.students.get(student).getId(), weeklyMax(s1, student, 6), weeklyMin(s1,student,6), range);
		}else if (rangeSelection == 7) {
			System.out.format("Student %d: Minutes of Strength Training: Max <%.2f> - Min <%.2f> == Range <%.2f>%n", s1.students.get(student).getId() ,weeklyMax(s1, student, 7), weeklyMin(s1,student,7), range);
		}else if (rangeSelection == 8) {
			System.out.format("Student %d: Minutes of Moderate Intensity Training: Max <%.2f> - Min <%.2f> == Range <%.2f>%n",s1.students.get(student).getId(), weeklyMax(s1, student, 8), weeklyMin(s1,student,8), range);
		}else if (rangeSelection == 9) {
			System.out.format("Student %d: Minutes of High Intensity Training: Max <%.2f> - Min <%.2f> == Range <%.2f>%n",s1.students.get(student).getId(), weeklyMax(s1, student, 9), weeklyMin(s1,student,9), range);
		}else if (rangeSelection == 10) {
			System.out.format("Student %d: Amount of Steps: Max <%.2f> - Min <%.2f> == Range <%.2f>%n",s1.students.get(student).getId(), weeklyMax(s1, student, 10), weeklyMin(s1,student,10), range);
		}
	}

	//Health
	public void healthCheck(students s1, int student, int healthSelection) {
		if (healthSelection == 1) {
			if (weeklyAvg(s1, student, 1) > 540f) {
				System.out.format("Student %d is above the recommended amount of sleep per night. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 1), 540f );
			} else if (weeklyAvg(s1, student, 1) < 540f){
				System.out.format("Student %d is below the recommended amount of sleep per night. %.2f < %.2f%n", student + 1,weeklyAvg(s1, student, 1), 540f );
			}else if (weeklyAvg(s1, student, 1) == 540f){
				System.out.format("Student %d is equal the recommended amount of sleep per night. %.2f < %.2f%n", student + 1,weeklyAvg(s1, student, 1), 540f );
			}
		} else if (healthSelection == 2) {
			if (weeklyAvg(s1, student, 2) > 2f) {
				System.out.format("Student %d is above the recommended amount of sugary drink drank per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 2), 2f );
			} else if (weeklyAvg(s1, student, 2) < 2f){
				System.out.format("Student %d is below the recommended amount of sugary drink drank per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 2), 2f );
			}else if (weeklyAvg(s1, student, 2) == 2f){
				System.out.format("Student %d is equal the recommended amount of sugary drink drank per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 2), 2f );
			}
		}else if (healthSelection == 3) {
			if (weeklyAvg(s1, student, 3) > 120f) {
				System.out.format("Student %d is above the recommended amount of phone time per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 3), 120f );
			} else if (weeklyAvg(s1, student, 3) < 120f){
				System.out.format("Student %d is below the recommended amount of phone time per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 3), 120f );
			}else if (weeklyAvg(s1, student, 3) == 120f){
				System.out.format("Student %d is equal the recommended amount of phone time per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 3), 120f );
			}
		}else if (healthSelection == 4) {
			if (weeklyAvg(s1, student, 4) > 4f) {
				System.out.format("Student %d is above the recommended amount of fruit servings per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 4), 4f);
			} else if (weeklyAvg(s1, student, 4) < 4f){
				System.out.format("Student %d is below the recommended amount of fruit servings per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 4), 4f );
			}else if (weeklyAvg(s1, student, 4) == 4f){
				System.out.format("Student %d is equal the recommended amount of fruit servings per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 4), 4f );
			}
		}else if (healthSelection == 5) {
			if (weeklyAvg(s1, student, 5) > 5f) {
				System.out.format("Student %d is above the recommended amount of vegetable servings per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 5), 5f );
			} else if (weeklyAvg(s1, student, 5) < 5f){
				System.out.format("Student %d is below the recommended amount of vegetable servings per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 5), 5f);
			} else if (weeklyAvg(s1, student, 5) == 5f){
				System.out.format("Student %d is equal the recommended amount of vegetable servings per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 5), 5f );
			}
		}else if (healthSelection == 6) {
			if (weeklyAvg(s1, student, 6) > 4f) {
				System.out.format("Student %d is above the recommended amount of caffeinated drinks per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 6), 4f );
			} else if (weeklyAvg(s1, student, 6) < 4f){
				System.out.format("Student %d is below the recommended amount of caffeinated drinks per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 6), 4f );
			}else if (weeklyAvg(s1, student, 6) == 4f){
				System.out.format("Student %d is equal the recommended amount of caffeinated drinks per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 6), 4f );
			}
		}else if (healthSelection == 7) {
			if (weeklyAvg(s1, student, 7) > 50f) {
				System.out.format("Student %d is above the recommended amount of minutes of strength training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 7), 50f );
			} else if (weeklyAvg(s1, student, 7) < 50f){
				System.out.format("Student %d is below the recommended amount of minutes of strength training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 7), 50f );
			}else if (weeklyAvg(s1, student, 7) == 50f){
				System.out.format("Student %d is equal the recommended amount of minutes of strength training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 7), 50f );
			}
		}else if (healthSelection == 8) {
			if (weeklyAvg(s1, student, 8) > 30f) {
				System.out.format("Student %d is above the recommended amount of minutes of moderate intensity training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 8), 30f );
			} else if (weeklyAvg(s1, student, 8) < 30f){
				System.out.format("Student %d is below the recommended amount of minutes of moderate intensity training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 8), 30f );
			}else if (weeklyAvg(s1, student, 8) == 30f){
				System.out.format("Student %d is equal the recommended amount of minutes of moderate intensity training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 8), 30f );
			}
		}else if (healthSelection == 9) {
			if (weeklyAvg(s1, student, 9) > 20f) {
				System.out.format("Student %d is above the recommended amount of minutes of high intensity training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 9), 20f );
			} else if (weeklyAvg(s1, student, 9) < 20f){
				System.out.format("Student %d is below the recommended amount of minutes of high intensity training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 9), 20f );
			}else if (weeklyAvg(s1, student, 9) == 20f){
				System.out.format("Student %d is equal the recommended amount of minutes of high intensity training per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 9), 20f );
			}
		}else if (healthSelection == 10) {
			if (weeklyAvg(s1, student, 10) > 10000f) {
				System.out.format("Student %d is above the recommended amount of steps taken per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 10), 10000f );
			} else if (weeklyAvg(s1, student, 10) < 10000f){
				System.out.format("Student %d is below the recommended amount of steps taken per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 10), 10000f );
			}else if (weeklyAvg(s1, student, 10) == 10000f){
				System.out.format("Student %d is equal the recommended amount of steps taken per day. %.2f > %.2f%n", student + 1,weeklyAvg(s1, student, 10), 10000f );
			}
		}
	}

	//Variance
	public float varianceValue(students s1, int student, int varianceSelection) {
		double v1 = 0;
		float v2 = 0;
		float variance = 0;
		if (varianceSelection == 1) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getSleep() - weeklyAvg(s1, student, 1));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 2) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getSugar() - weeklyAvg(s1, student, 2));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 3) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getPhone() - weeklyAvg(s1, student, 3));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 4) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getFruit() - weeklyAvg(s1, student, 4));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 5) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getVegetables() - weeklyAvg(s1, student, 5));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 6) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getCaffeine() - weeklyAvg(s1, student, 6));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 7) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getStrength() - weeklyAvg(s1, student, 7));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 8) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getModerate() - weeklyAvg(s1, student, 8));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 9) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getHigh() - weeklyAvg(s1, student, 9));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		} else if (varianceSelection == 10) {
			for (int i = 0; i < s1.students.get(student).getDays().size(); i++) {
				v1 = (s1.students.get(student).getDays().get(i).getSteps() - weeklyAvg(s1, student, 10));
				v1 = Math.pow(v1, 2);
				v2 += v1;
				variance = v2 / s1.students.get(student).getDays().size();
				if (variance == 0) {
					variance += 1;
				}
			}
		}
		return variance;
	}
	public void varianceTable(students s1, int student) {
		System.out.format("Student: %d%n", s1.students.get(student).getId());
		System.out.format("------------------------------------------------------%n");
		if (varianceValue(s1, student, 1) == 0f) {
			System.out.format("The Variance for Sleep: %29s%n", "NaN");
		}else {
			System.out.format("The Variance for Sleep: %29.2f%n", varianceValue(s1, student, 1));
		}
		if (varianceValue(s1, student, 2) == 0f) {
			System.out.format("The Variance for Sugary Drinks: %21s%n", "NaN");
		}else {
			System.out.format("The Variance for Sugary Drinks: %21.2f%n", varianceValue(s1, student, 2));
		}
		if (varianceValue(s1, student, 3) == 0f) {
			System.out.format("The Variance for Minutes on Phone: %18s%n", "NaN");
		}else {
			System.out.format("The Variance for Minutes on Phone: %18.2f%n", varianceValue(s1, student, 3));
		}
		if (varianceValue(s1, student, 4) == 0f) {
			System.out.format("The Variance for Servings of Fruit: %17s%n", "NaN");
		}else {
			System.out.format("The Variance for Servings of Fruit: %17.2f%n", varianceValue(s1, student, 4));
		}
		if (varianceValue(s1, student, 5) == 0f) {
			System.out.format("The Variance for Servings of Vegetables: %12s%n", "NaN");
		}else {
			System.out.format("The Variance for Servings of Vegetables: %12.2f%n", varianceValue(s1, student, 5));
		}
		if (varianceValue(s1, student, 6) == 0f) {
			System.out.format("The Variance for Caffeinated Drinks: %16s%n", "NaN");
		}else {
			System.out.format("The Variance for Caffeinated Drinks: %16.2f%n", varianceValue(s1, student, 6));
		}
		if (varianceValue(s1, student, 7) == 0f) {
			System.out.format("The Variance for Strength Training: %17s%n", "NaN");
		}else {
			System.out.format("The Variance for Strength Training: %17.2f%n", varianceValue(s1, student, 7));
		}
		if (varianceValue(s1, student, 8) == 0f) {
			System.out.format("The Variance for Moderate Intensity Training: %7s%n", "NaN");
		}else {
			System.out.format("The Variance for Moderate Intensity Training: %7.2f%n", varianceValue(s1, student, 8));
		}
		if (varianceValue(s1, student, 9) == 0f) {
			System.out.format("The Variance for High Intensity Training: %11s%n", "NaN");
		}else {
			System.out.format("The Variance for High Intensity Training: %11.2f%n", varianceValue(s1, student, 9));
		}
		if (varianceValue(s1, student, 10) == 0f) {
			System.out.format("The Variance for Steps: %29s%n", "NaN");
		}else {
			System.out.format("The Variance for Steps: %29.2f%n", varianceValue(s1, student, 10));
		}
		System.out.format("------------------------------------------------------%n");
	}

	//Standard Deviation
	public float deviationValue(students s1, int student, int deviationSelection) {
		float deviation = 0;
		if (deviationSelection == 1) {
			deviation = (float) Math.pow(varianceValue(s1, student, 1), .5);
		} else if (deviationSelection == 2) {
			deviation = (float) Math.pow(varianceValue(s1, student, 2), .5);
		} else if (deviationSelection == 3) {
			deviation = (float) Math.pow(varianceValue(s1, student, 3), .5);
		}else if (deviationSelection == 4) {
			deviation = (float) Math.pow(varianceValue(s1, student, 4), .5);
		}else if (deviationSelection == 5) {
			deviation = (float) Math.pow(varianceValue(s1, student, 5), .5);
		}else if (deviationSelection == 6) {
			deviation = (float) Math.pow(varianceValue(s1, student, 6), .5);
		}else if (deviationSelection == 7) {
			deviation = (float) Math.pow(varianceValue(s1, student, 7), .5);
		}else if (deviationSelection == 8) {
			deviation = (float) Math.pow(varianceValue(s1, student, 8), .5);
		}else if (deviationSelection == 9) {
			deviation = (float) Math.pow(varianceValue(s1, student, 9), .5);
		}else if (deviationSelection == 10) {
			deviation = (float) Math.pow(varianceValue(s1, student, 10), .5);
		}
		return deviation;
	}
	public void deviationTable(students s1, int student) {
		System.out.format("Student: %d%n", s1.students.get(student).getId());
		System.out.format("---------------------------------------------------------------%n");
		if (varianceValue(s1, student, 1) == 0f) {
			System.out.format("The Standard Deviation for Sleep: %29s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Sleep: %29.2f%n", deviationValue(s1, student, 1));
		}
		if (varianceValue(s1, student, 2) == 0f) {
			System.out.format("The Standard Deviation for Sugary Drinks: %21s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Sugary Drinks: %21.2f%n", deviationValue(s1, student, 2));
		}
		if (varianceValue(s1, student, 3) == 0f) {
			System.out.format("The Standard Deviation for Minutes on Phone: %18s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Minutes on Phone: %18.2f%n", deviationValue(s1, student, 3));
		}
		if (varianceValue(s1, student, 4) == 0f) {
			System.out.format("The Standard Deviation for Servings of Fruit: %17s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Servings of Fruit: %17.2f%n", deviationValue(s1, student, 4));
		}
		if (varianceValue(s1, student, 5) == 0f) {
			System.out.format("The Standard Deviation for Servings of Vegetables: %12s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Servings of Vegetables: %12.2f%n", deviationValue(s1, student, 5));
		}
		if (varianceValue(s1, student, 6) == 0f) {
			System.out.format("The Standard Deviation for Caffeinated Drinks: %16s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Caffeinated Drinks: %16.2f%n", deviationValue(s1, student, 6));
		}
		if (varianceValue(s1, student, 7) == 0f) {
			System.out.format("The Standard Deviation for Strength Training: %17s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Strength Training: %17.2f%n", deviationValue(s1, student, 7));
		}
		if (varianceValue(s1, student, 8) == 0f) {
			System.out.format("The Standard Deviation for Moderate Intensity Training: %7s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Moderate Intensity Training: %7.2f%n", deviationValue(s1, student, 8));
		}
		if (varianceValue(s1, student, 9) == 0f) {
			System.out.format("The Standard Deviation for High Intensity Training: %11s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for High Intensity Training: %11.2f%n", deviationValue(s1, student, 9));
		}
		if (varianceValue(s1, student, 10) == 0f) {
			System.out.format("The Standard Deviation for Steps: %29s%n", "NaN");
		}else {
			System.out.format("The Standard Deviation for Steps: %29.2f%n", deviationValue(s1, student, 10));
		}
		System.out.format("---------------------------------------------------------------%n");
	}

	//Compare
	public void compareStudentsDay(students s1, int student, int student2, int day) {
		System.out.format("--------------------------------------------------------------%n");
		System.out.format("Student (Day %d) %26s %5d %3s %5d %2s %n",day + 1,"|", s1.students.get(student).getId(),"|", s1.students.get(student2).getId(), "|");
		System.out.format("--------------------------------------------------------------%n");
		if (s1.students.get(student).getDays().get(day).getSleep() == 0f) {
			System.out.format("Minutes of Sleep %25s %7s | %7.2f |%n","|", "NaN", s1.students.get(student2).getDays().get(day).getSleep());
		} else if (s1.students.get(student2).getDays().get(day).getSleep() == 0f) {
			System.out.format("Minutes of Sleep %25s %7.2f | %7s |%n","|", s1.students.get(student).getDays().get(day).getSleep(), "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getSleep() == 0f && s1.students.get(student).getDays().get(day).getSleep() == 0f) {
			System.out.format("Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", "NaN");
		}else {
			System.out.format("Minutes of Sleep %25s %7.2f | %7.2f |%n","|", s1.students.get(student).getDays().get(day).getSleep(), s1.students.get(student2).getDays().get(day).getSleep());
		}
		if (s1.students.get(student2).getDays().get(day).getSugar() == 0f && s1.students.get(student).getDays().get(day).getSugar() == 0f) {
			System.out.format("Amount of Sugary Drinks %18s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getSugar() == 0f) {
			System.out.format("Amount of Sugary Drinks %18s %7.2f | %7s |%n","|", s1.students.get(student).getDays().get(day).getSugar(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getSugar() == 0f) {
			System.out.format("Amount of Sugary Drinks %18s %7s | %7.2f |%n","|", "NaN", s1.students.get(student2).getDays().get(day).getSugar());
		}else {
			System.out.format("Amount of Sugary Drinks %18s %7.2f | %7.2f |%n","|", s1.students.get(student).getDays().get(day).getSugar(), s1.students.get(student2).getDays().get(day).getSugar());
		}
		if (s1.students.get(student2).getDays().get(day).getPhone() == 0f && s1.students.get(student).getDays().get(day).getPhone() == 0f) {
			System.out.format("Minutes on Phone %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getPhone() == 0f) {
			System.out.format("Minutes on Phone %25s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getPhone(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getPhone() == 0f) {
			System.out.format("Minutes on Phone %25s %7s | %7.2f |%n", "|","NaN", s1.students.get(student2).getDays().get(day).getPhone());
		}else {
			System.out.format("Minutes on Phone %25s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getPhone(), s1.students.get(student2).getDays().get(day).getPhone());
		}
		if (s1.students.get(student2).getDays().get(day).getFruit() == 0f && s1.students.get(student).getDays().get(day).getFruit() == 0f) {
			System.out.format("Servings of Fruit %24s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getFruit() == 0f) {
			System.out.format("Servings of Fruit %24s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getFruit(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getFruit() == 0f) {
			System.out.format("Servings of Fruit %24s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getFruit());
		}else {
			System.out.format("Servings of Fruit %24s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getFruit(), s1.students.get(student2).getDays().get(day).getFruit());
		}
		if (s1.students.get(student2).getDays().get(day).getVegetables() == 0f && s1.students.get(student).getDays().get(day).getVegetables() == 0f) {
			System.out.format("Servings of Vegetables %19s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getVegetables() == 0f) {
			System.out.format("Servings of Vegetables %19s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getVegetables(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getVegetables() == 0f) {
			System.out.format("Servings of Vegetables %19s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getVegetables());
		}else {
			System.out.format("Servings of Vegetables %19s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getVegetables(), s1.students.get(student2).getDays().get(day).getVegetables());
		}
		if (s1.students.get(student2).getDays().get(day).getCaffeine() == 0f && s1.students.get(student).getDays().get(day).getCaffeine() == 0f) {
			System.out.format("Amount of Caffeinated Drinks %13s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getCaffeine() == 0f) {
			System.out.format("Amount of Caffeinated Drinks %13s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getCaffeine(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getCaffeine() == 0f) {
			System.out.format("Amount of Caffeinated Drinks %13s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getCaffeine());
		}else {
			System.out.format("Amount of Caffeinated Drinks %13s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getCaffeine(), s1.students.get(student2).getDays().get(day).getCaffeine());
		}
		if (s1.students.get(student2).getDays().get(day).getStrength() == 0f && s1.students.get(student).getDays().get(day).getStrength() == 0f) {
			System.out.format("Minutes of Strength Training %13s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getStrength() == 0f) {
			System.out.format("Minutes of Strength Training %13s %7.2f | %7s |%n","|", s1.students.get(student).getDays().get(day).getStrength(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getStrength() == 0f) {
			System.out.format("Minutes of Strength Training %13s %7s | %7.2f |%n","|", "NaN", s1.students.get(student2).getDays().get(day).getStrength());
		}else {
			System.out.format("Minutes of Strength Training %13s %7.2f | %7.2f |%n","|", s1.students.get(student).getDays().get(day).getStrength(), s1.students.get(student2).getDays().get(day).getStrength());
		}
		if (s1.students.get(student2).getDays().get(day).getModerate() == 0f && s1.students.get(student).getDays().get(day).getModerate() == 0f) {
			System.out.format("Minutes of Moderate Intensity Training %3s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getModerate() == 0f) {
			System.out.format("Minutes of Moderate Intensity Training %3s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getModerate(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getModerate() == 0f) {
			System.out.format("Minutes of Moderate Intensity Training %3s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getModerate());
		}else {
			System.out.format("Minutes of Moderate Intensity Training %3s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getModerate(), s1.students.get(student2).getDays().get(day).getModerate());
		}
		if (s1.students.get(student2).getDays().get(day).getHigh() == 0f && s1.students.get(student).getDays().get(day).getHigh() == 0f) {
			System.out.format("Minutes of High Intensity Training %7s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getHigh() == 0f) {
			System.out.format("Minutes of High Intensity Training %7s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getHigh(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getHigh() == 0f) {
			System.out.format("Minutes of High Intensity Training %7s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getHigh());
		}else {
			System.out.format("Minutes of High Intensity Training %7s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getHigh(), s1.students.get(student2).getDays().get(day).getHigh());
		}
		if (s1.students.get(student2).getDays().get(day).getSteps() == 0f && s1.students.get(student).getDays().get(day).getSteps() == 0f) {
			System.out.format("Amounts of Steps %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (s1.students.get(student2).getDays().get(day).getSteps() == 0f) {
			System.out.format("Amounts of Steps %25s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getSteps(), "NaN");
		} else if (s1.students.get(student).getDays().get(day).getSteps() == 0f) {
			System.out.format("Amounts of Steps %25s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getSteps());
		}else {
			System.out.format("Amounts of Steps %25s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getSteps(), s1.students.get(student2).getDays().get(day).getSteps());
		}
		System.out.format("--------------------------------------------------------------%n");
	}
	public void compareStudentsAllDays(students s1, int student, int student2) {
		System.out.format("--------------------------------------------------------------%n");
		System.out.format("Student %35s %5d %3s %5d %2s %n","|", s1.students.get(student).getId(),"|", s1.students.get(student2).getId(), "|");
		System.out.format("--------------------------------------------------------------%n");
		for (int day = 0; day < s1.students.get(student).getDays().size(); day++) {
			System.out.format("Day %d%n",day + 1);
			if (s1.students.get(student).getDays().get(day).getSleep() == 0f) {
				System.out.format("Minutes of Sleep %25s %7s | %7.2f |%n","|", "NaN", s1.students.get(student2).getDays().get(day).getSleep());
			} else if (s1.students.get(student2).getDays().get(day).getSleep() == 0f) {
				System.out.format("Minutes of Sleep %25s %7.2f | %7s |%n","|", s1.students.get(student).getDays().get(day).getSleep(), "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getSleep() == 0f && s1.students.get(student).getDays().get(day).getSleep() == 0f) {
				System.out.format("Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", "NaN");
			}else {
				System.out.format("Minutes of Sleep %25s %7.2f | %7.2f |%n","|", s1.students.get(student).getDays().get(day).getSleep(), s1.students.get(student2).getDays().get(day).getSleep());
			}
			if (s1.students.get(student2).getDays().get(day).getSugar() == 0f && s1.students.get(student).getDays().get(day).getSugar() == 0f) {
				System.out.format("Amount of Sugary Drinks %18s %7s | %7s |%n","|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getSugar() == 0f) {
				System.out.format("Amount of Sugary Drinks %18s %7.2f | %7s |%n","|", s1.students.get(student).getDays().get(day).getSugar(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getSugar() == 0f) {
				System.out.format("Amount of Sugary Drinks %18s %7s | %7.2f |%n","|", "NaN", s1.students.get(student2).getDays().get(day).getSugar());
			}else {
				System.out.format("Amount of Sugary Drinks %18s %7.2f | %7.2f |%n","|", s1.students.get(student).getDays().get(day).getSugar(), s1.students.get(student2).getDays().get(day).getSugar());
			}
			if (s1.students.get(student2).getDays().get(day).getPhone() == 0f && s1.students.get(student).getDays().get(day).getPhone() == 0f) {
				System.out.format("Minutes on Phone %25s %7s | %7s |%n", "|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getPhone() == 0f) {
				System.out.format("Minutes on Phone %25s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getPhone(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getPhone() == 0f) {
				System.out.format("Minutes on Phone %25s %7s | %7.2f |%n", "|","NaN", s1.students.get(student2).getDays().get(day).getPhone());
			}else {
				System.out.format("Minutes on Phone %25s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getPhone(), s1.students.get(student2).getDays().get(day).getPhone());
			}
			if (s1.students.get(student2).getDays().get(day).getFruit() == 0f && s1.students.get(student).getDays().get(day).getFruit() == 0f) {
				System.out.format("Servings of Fruit %24s %7s | %7s |%n", "|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getFruit() == 0f) {
				System.out.format("Servings of Fruit %24s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getFruit(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getFruit() == 0f) {
				System.out.format("Servings of Fruit %24s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getFruit());
			}else {
				System.out.format("Servings of Fruit %24s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getFruit(), s1.students.get(student2).getDays().get(day).getFruit());
			}
			if (s1.students.get(student2).getDays().get(day).getVegetables() == 0f && s1.students.get(student).getDays().get(day).getVegetables() == 0f) {
				System.out.format("Servings of Vegetables %19s %7s | %7s |%n", "|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getVegetables() == 0f) {
				System.out.format("Servings of Vegetables %19s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getVegetables(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getVegetables() == 0f) {
				System.out.format("Servings of Vegetables %19s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getVegetables());
			}else {
				System.out.format("Servings of Vegetables %19s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getVegetables(), s1.students.get(student2).getDays().get(day).getVegetables());
			}
			if (s1.students.get(student2).getDays().get(day).getCaffeine() == 0f && s1.students.get(student).getDays().get(day).getCaffeine() == 0f) {
				System.out.format("Amount of Caffeinated Drinks %13s %7s | %7s |%n", "|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getCaffeine() == 0f) {
				System.out.format("Amount of Caffeinated Drinks %13s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getCaffeine(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getCaffeine() == 0f) {
				System.out.format("Amount of Caffeinated Drinks %13s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getCaffeine());
			}else {
				System.out.format("Amount of Caffeinated Drinks %13s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getCaffeine(), s1.students.get(student2).getDays().get(day).getCaffeine());
			}
			if (s1.students.get(student2).getDays().get(day).getStrength() == 0f && s1.students.get(student).getDays().get(day).getStrength() == 0f) {
				System.out.format("Minutes of Strength Training %13s %7s | %7s |%n","|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getStrength() == 0f) {
				System.out.format("Minutes of Strength Training %13s %7.2f | %7s |%n","|", s1.students.get(student).getDays().get(day).getStrength(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getStrength() == 0f) {
				System.out.format("Minutes of Strength Training %13s %7s | %7.2f |%n","|", "NaN", s1.students.get(student2).getDays().get(day).getStrength());
			}else {
				System.out.format("Minutes of Strength Training %13s %7.2f | %7.2f |%n","|", s1.students.get(student).getDays().get(day).getStrength(), s1.students.get(student2).getDays().get(day).getStrength());
			}
			if (s1.students.get(student2).getDays().get(day).getModerate() == 0f && s1.students.get(student).getDays().get(day).getModerate() == 0f) {
				System.out.format("Minutes of Moderate Intensity Training %3s %7s | %7s |%n", "|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getModerate() == 0f) {
				System.out.format("Minutes of Moderate Intensity Training %3s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getModerate(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getModerate() == 0f) {
				System.out.format("Minutes of Moderate Intensity Training %3s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getModerate());
			}else {
				System.out.format("Minutes of Moderate Intensity Training %3s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getModerate(), s1.students.get(student2).getDays().get(day).getModerate());
			}
			if (s1.students.get(student2).getDays().get(day).getHigh() == 0f && s1.students.get(student).getDays().get(day).getHigh() == 0f) {
				System.out.format("Minutes of High Intensity Training %7s %7s | %7s |%n", "|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getHigh() == 0f) {
				System.out.format("Minutes of High Intensity Training %7s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getHigh(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getHigh() == 0f) {
				System.out.format("Minutes of High Intensity Training %7s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getHigh());
			}else {
				System.out.format("Minutes of High Intensity Training %7s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getHigh(), s1.students.get(student2).getDays().get(day).getHigh());
			}
			if (s1.students.get(student2).getDays().get(day).getSteps() == 0f && s1.students.get(student).getDays().get(day).getSteps() == 0f) {
				System.out.format("Amounts of Steps %25s %7s | %7s |%n", "|", "NaN", "NaN");
			} else if (s1.students.get(student2).getDays().get(day).getSteps() == 0f) {
				System.out.format("Amounts of Steps %25s %7.2f | %7s |%n", "|", s1.students.get(student).getDays().get(day).getSteps(), "NaN");
			} else if (s1.students.get(student).getDays().get(day).getSteps() == 0f) {
				System.out.format("Amounts of Steps %25s %7s | %7.2f |%n", "|", "NaN", s1.students.get(student2).getDays().get(day).getSteps());
			}else {
				System.out.format("Amounts of Steps %25s %7.2f | %7.2f |%n", "|", s1.students.get(student).getDays().get(day).getSteps(), s1.students.get(student2).getDays().get(day).getSteps());
			}
			System.out.format("--------------------------------------------------------------%n");
		}
	}
	public void compareStudentsAvg(students s1, int student, int student2){
		System.out.format("----------------------------------------------------------------------%n");
		System.out.format("Student %42s %5d %3s %5d %3s %n","|", s1.students.get(student).getId(),"|", s1.students.get(student2).getId(), "|");
		System.out.format("----------------------------------------------------------------------%n");
		if (weeklyAvg(s1, student2, 1) == 0f && weeklyAvg(s1, student, 1) == 0f) {
			System.out.format("Average Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 1) == 0f) {
			System.out.format("Average Minutes of Sleep %25s %7.2f | %7s |%n","|", weeklyAvg(s1, student, 1), "NaN");
		} else if (weeklyAvg(s1, student, 1) == 0f) {
			System.out.format("Average Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", weeklyAvg(s1, student2, 1));
		}else {
			System.out.format("Average Minutes of Sleep %25s %7.2f | %7.2f |%n","|", weeklyAvg(s1, student, 1), weeklyAvg(s1, student2, 1));
		}
		if (weeklyAvg(s1, student, 2) == 0f && weeklyAvg(s1, student2, 2) == 0f) {
			System.out.format("Average Amount of Sugary Drinks %18s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 2) == 0f) {
			System.out.format("Average Amount of Sugary Drinks %18s %7.2f | %7s |%n","|", weeklyAvg(s1, student, 2), "NaN");
		} else if (weeklyAvg(s1, student, 2) == 0f) {
			System.out.format("Average Amount of Sugary Drinks %18s %7s | %7.2f |%n","|", "NaN", weeklyAvg(s1, student2, 2));
		}else {
			System.out.format("Average Amount of Sugary Drinks %18s %7.2f | %7.2f |%n","|", weeklyAvg(s1, student, 2), weeklyAvg(s1, student2, 2));
		}
		if (weeklyAvg(s1, student, 3) == 0f && weeklyAvg(s1, student2, 3) == 0f) {
			System.out.format("Average Minutes on Phone %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 3) == 0f) {
			System.out.format("Average Minutes on Phone %25s %7.2f | %7s |%n", "|", weeklyAvg(s1, student, 3), "NaN");
		} else if (weeklyAvg(s1, student, 3) == 0f) {
			System.out.format("Average Minutes on Phone %25s %7s | %7.2f |%n", "|","NaN", weeklyAvg(s1, student2, 3));
		}else {
			System.out.format("Average Minutes on Phone %25s %7.2f | %7.2f |%n", "|", weeklyAvg(s1, student, 3), weeklyAvg(s1, student2, 3));
		}
		if (weeklyAvg(s1, student, 4) == 0f && weeklyAvg(s1, student2, 4) == 0f) {
			System.out.format("Average Servings of Fruit %24s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 4) == 0f) {
			System.out.format("Average Servings of Fruit %24s %7.2f | %7s |%n", "|", weeklyAvg(s1, student, 4), "NaN");
		} else if (weeklyAvg(s1, student, 4)  == 0f) {
			System.out.format("Average Servings of Fruit %24s %7s | %7.2f |%n", "|", "NaN", weeklyAvg(s1, student2, 4) );
		}else {
			System.out.format("Average Servings of Fruit %24s %7.2f | %7.2f |%n", "|", weeklyAvg(s1, student, 4) , weeklyAvg(s1, student2, 4) );
		}
		if (weeklyAvg(s1, student, 5)  == 0f && weeklyAvg(s1, student2, 5)  == 0f) {
			System.out.format("Average Servings of Vegetables %19s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 5)  == 0f) {
			System.out.format("Average Servings of Vegetables %19s %7.2f | %7s |%n", "|", weeklyAvg(s1, student, 5) , "NaN");
		} else if (weeklyAvg(s1, student, 5)  == 0f) {
			System.out.format("Average Servings of Vegetables %19s %7s | %7.2f |%n", "|", "NaN", weeklyAvg(s1, student2, 5) );
		}else {
			System.out.format("Average Servings of Vegetables %19s %7.2f | %7.2f |%n", "|", weeklyAvg(s1, student, 5) , weeklyAvg(s1, student2, 5) );
		}
		if (weeklyAvg(s1, student, 6)  == 0f && weeklyAvg(s1, student2, 6) == 0f) {
			System.out.format("Average Amount of Caffeinated Drinks %13s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 6)== 0f) {
			System.out.format("Average Amount of Caffeinated Drinks %13s %7.2f | %7s |%n", "|", weeklyAvg(s1, student, 6), "NaN");
		} else if (weeklyAvg(s1, student, 6) == 0f) {
			System.out.format("Average Amount of Caffeinated Drinks %13s %7s | %7.2f |%n", "|", "NaN", weeklyAvg(s1, student2, 6));
		}else {
			System.out.format("Average Amount of Caffeinated Drinks %13s %7.2f | %7.2f |%n", "|", weeklyAvg(s1, student, 6), weeklyAvg(s1, student2, 6));
		}
		if (weeklyAvg(s1, student, 7) == 0f && weeklyAvg(s1, student2, 7)  == 0f) {
			System.out.format("Average Minutes of Strength Training %13s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 7)  == 0f) {
			System.out.format("Average Minutes of Strength Training %13s %7.2f | %7s |%n","|", weeklyAvg(s1, student, 7) , "NaN");
		} else if (weeklyAvg(s1, student, 7)  == 0f) {
			System.out.format("Average Minutes of Strength Training %13s %7s | %7.2f |%n","|", "NaN", weeklyAvg(s1, student2, 7) );
		}else {
			System.out.format("Average Minutes of Strength Training %13s %7.2f | %7.2f |%n","|", weeklyAvg(s1, student, 7) , weeklyAvg(s1, student2, 7) );
		}
		if (weeklyAvg(s1, student, 8)  == 0f && weeklyAvg(s1, student2, 8)  == 0f) {
			System.out.format("Average Minutes of Moderate Intensity Training %3s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 8)  == 0f) {
			System.out.format("Average Minutes of Moderate Intensity Training %3s %7.2f | %7s |%n", "|", weeklyAvg(s1, student, 8) , "NaN");
		} else if (weeklyAvg(s1, student, 8)  == 0f) {
			System.out.format("Average Minutes of Moderate Intensity Training %3s %7s | %7.2f |%n", "|", "NaN", weeklyAvg(s1, student2, 8) );
		}else {
			System.out.format("Average Minutes of Moderate Intensity Training %3s %7.2f | %7.2f |%n", "|", weeklyAvg(s1, student, 8) , weeklyAvg(s1, student2, 8) );
		}
		if (weeklyAvg(s1, student, 9)  == 0f && weeklyAvg(s1, student2, 9)  == 0f) {
			System.out.format("Average Minutes of High Intensity Training %7s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 9)  == 0f) {
			System.out.format("Average Minutes of High Intensity Training %7s %7.2f | %7s |%n", "|", weeklyAvg(s1, student, 9) , "NaN");
		} else if (weeklyAvg(s1, student, 9)  == 0f) {
			System.out.format("Average Minutes of High Intensity Training %7s %7s | %7.2f |%n", "|", "NaN", weeklyAvg(s1, student2, 9) );
		}else {
			System.out.format("Average Minutes of High Intensity Training %7s %7.2f | %7.2f |%n", "|", weeklyAvg(s1, student, 9) , weeklyAvg(s1, student2, 9) );
		}
		if (weeklyAvg(s1, student, 10)  == 0f && weeklyAvg(s1, student2, 10) == 0f) {
			System.out.format("Average Amounts of Steps %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyAvg(s1, student2, 10) == 0f) {
			System.out.format("Average Amounts of Steps %25s %7.2f | %7s |%n", "|", weeklyAvg(s1, student, 10), "NaN");
		} else if (weeklyAvg(s1, student, 10) == 0f) {
			System.out.format("Average Amounts of Steps %25s %7s | %7.2f |%n", "|", "NaN", weeklyAvg(s1, student2, 10));
		}else {
			System.out.format("Average Amounts of Steps %25s %7.2f | %7.2f |%n", "|",weeklyAvg(s1, student, 10), weeklyAvg(s1, student2, 10));
		}
		System.out.format("----------------------------------------------------------------------%n");
	}
	public void compareStudentsMin(students s1, int student, int student2){

		System.out.format("----------------------------------------------------------------------%n");
		System.out.format("Student %42s %5d %3s %5d %3s %n","|", s1.students.get(student).getId(),"|", s1.students.get(student2).getId(), "|");
		System.out.format("----------------------------------------------------------------------%n");
		if (weeklyMin(s1, student2, 1) == 0f && weeklyMin(s1, student, 1) == 0f) {
			System.out.format("Minimum Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 1) == 0f) {
			System.out.format("Minutes of Sleep %25s %7.2f | %7s |%n","|", weeklyMin(s1, student, 1), "NaN");
		} else if (weeklyMin(s1, student, 1) == 0f) {
			System.out.format("Minimum Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", weeklyMin(s1, student2, 1));
		}else {
			System.out.format("Minimum Minutes of Sleep %25s %7.2f | %7.2f |%n","|", weeklyMin(s1, student, 1), weeklyMin(s1, student2, 1));
		}
		if (weeklyMin(s1, student, 2) == 0f && weeklyMin(s1, student2, 2) == 0f) {
			System.out.format("Minimum Amount of Sugary Drinks %18s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 2) == 0f) {
			System.out.format("Minimum Amount of Sugary Drinks %18s %7.2f | %7s |%n","|", weeklyMin(s1, student, 2), "NaN");
		} else if (weeklyMin(s1, student, 2) == 0f) {
			System.out.format("Minimum Amount of Sugary Drinks %18s %7s | %7.2f |%n","|", "NaN", weeklyMin(s1, student2, 2));
		}else {
			System.out.format("Minimum Amount of Sugary Drinks %18s %7.2f | %7.2f |%n","|", weeklyMin(s1, student, 2), weeklyMin(s1, student2, 2));
		}
		if (weeklyMin(s1, student, 3) == 0f && weeklyMin(s1, student2, 3) == 0f) {
			System.out.format("Minimum Minutes on Phone %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 3) == 0f) {
			System.out.format("Minimum Minutes on Phone %25s %7.2f | %7s |%n", "|", weeklyMin(s1, student, 3), "NaN");
		} else if (weeklyMin(s1, student, 3) == 0f) {
			System.out.format("Minimum Minutes on Phone %25s %7s | %7.2f |%n", "|","NaN", weeklyMin(s1, student2, 3));
		}else {
			System.out.format("Minimum Minutes on Phone %25s %7.2f | %7.2f |%n", "|", weeklyMin(s1, student, 3), weeklyMin(s1, student2, 3));
		}
		if (weeklyMin(s1, student, 4) == 0f && weeklyMin(s1, student2, 4) == 0f) {
			System.out.format("Minimum Servings of Fruit %24s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 4) == 0f) {
			System.out.format("Minimum Servings of Fruit %24s %7.2f | %7s |%n", "|", weeklyMin(s1, student, 4), "NaN");
		} else if (weeklyMin(s1, student, 4)  == 0f) {
			System.out.format("Minimum Servings of Fruit %24s %7s | %7.2f |%n", "|", "NaN", weeklyMin(s1, student2, 4) );
		}else {
			System.out.format("Minimum Servings of Fruit %24s %7.2f | %7.2f |%n", "|", weeklyMin(s1, student, 4) , weeklyMin(s1, student2, 4) );
		}
		if (weeklyMin(s1, student, 5)  == 0f && weeklyMin(s1, student2, 5)  == 0f) {
			System.out.format("Minimum Servings of Vegetables %19s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 5)  == 0f) {
			System.out.format("Minimum Servings of Vegetables %19s %7.2f | %7s |%n", "|", weeklyMin(s1, student, 5) , "NaN");
		} else if (weeklyMin(s1, student, 5)  == 0f) {
			System.out.format("Minimum Servings of Vegetables %19s %7s | %7.2f |%n", "|", "NaN", weeklyMin(s1, student2, 5) );
		}else {
			System.out.format("Minimum Servings of Vegetables %19s %7.2f | %7.2f |%n", "|", weeklyMin(s1, student, 5) , weeklyMin(s1, student2, 5) );
		}
		if (weeklyMin(s1, student, 6)  == 0f && weeklyMin(s1, student2, 6) == 0f) {
			System.out.format("Minimum Amount of Caffeinated Drinks %13s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 6)== 0f) {
			System.out.format("Minimum Amount of Caffeinated Drinks %13s %7.2f | %7s |%n", "|", weeklyMin(s1, student, 6), "NaN");
		} else if (weeklyMin(s1, student, 6) == 0f) {
			System.out.format("Minimum Amount of Caffeinated Drinks %13s %7s | %7.2f |%n", "|", "NaN", weeklyMin(s1, student2, 6));
		}else {
			System.out.format("Minimum Amount of Caffeinated Drinks %13s %7.2f | %7.2f |%n", "|", weeklyMin(s1, student, 6), weeklyMin(s1, student2, 6));
		}
		if (weeklyMin(s1, student, 7) == 0f && weeklyMin(s1, student2, 7)  == 0f) {
			System.out.format("Minimum Minutes of Strength Training %13s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 7)  == 0f) {
			System.out.format("Minimum Minutes of Strength Training %13s %7.2f | %7s |%n","|", weeklyMin(s1, student, 7) , "NaN");
		} else if (weeklyMin(s1, student, 7)  == 0f) {
			System.out.format("Minimum Minutes of Strength Training %13s %7s | %7.2f |%n","|", "NaN", weeklyMin(s1, student2, 7) );
		}else {
			System.out.format("Minimum Minutes of Strength Training %13s %7.2f | %7.2f |%n","|", weeklyMin(s1, student, 7) , weeklyMin(s1, student2, 7) );
		}
		if (weeklyMin(s1, student, 8)  == 0f && weeklyMin(s1, student2, 8)  == 0f) {
			System.out.format("Minimum Minutes of Moderate Intensity Training %3s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 8)  == 0f) {
			System.out.format("Minimum Minutes of Moderate Intensity Training %3s %7.2f | %7s |%n", "|", weeklyMin(s1, student, 8) , "NaN");
		} else if (weeklyMin(s1, student, 8)  == 0f) {
			System.out.format("Minimum Minutes of Moderate Intensity Training %3s %7s | %7.2f |%n", "|", "NaN", weeklyMin(s1, student2, 8) );
		}else {
			System.out.format("Minimum Minutes of Moderate Intensity Training %3s %7.2f | %7.2f |%n", "|", weeklyMin(s1, student, 8) , weeklyMin(s1, student2, 8) );
		}
		if (weeklyMin(s1, student, 9)  == 0f && weeklyMin(s1, student2, 9)  == 0f) {
			System.out.format("Minimum Minutes of High Intensity Training %7s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 9)  == 0f) {
			System.out.format("Minimum Minutes of High Intensity Training %7s %7.2f | %7s |%n", "|", weeklyMin(s1, student, 9) , "NaN");
		} else if (weeklyMin(s1, student, 9)  == 0f) {
			System.out.format("Minimum Minutes of High Intensity Training %7s %7s | %7.2f |%n", "|", "NaN", weeklyMin(s1, student2, 9) );
		}else {
			System.out.format("Minimum Minutes of High Intensity Training %7s %7.2f | %7.2f |%n", "|", weeklyMin(s1, student, 9) , weeklyMin(s1, student2, 9) );
		}
		if (weeklyMin(s1, student, 10)  == 0f && weeklyMin(s1, student2, 10) == 0f) {
			System.out.format("Minimum Amounts of Steps %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMin(s1, student2, 10) == 0f) {
			System.out.format("Minimum Amounts of Steps %25s %7.2f | %7s |%n", "|", weeklyMin(s1, student, 10), "NaN");
		} else if (weeklyMin(s1, student, 10) == 0f) {
			System.out.format("Minimum Amounts of Steps %25s %7s | %7.2f |%n", "|", "NaN", weeklyMin(s1, student2, 10));
		}else {
			System.out.format("Minimum Amounts of Steps %25s %7.2f | %7.2f |%n", "|",weeklyMin(s1, student, 10), weeklyMin(s1, student2, 10));
		}
		System.out.format("----------------------------------------------------------------------%n");
	}
	public void compareStudentsMax(students s1, int student, int student2){
		System.out.format("----------------------------------------------------------------------%n");
		System.out.format("Student %35s %5d %3s %5d %2s %n","|", s1.students.get(student).getId(),"|", s1.students.get(student2).getId(), "|");
		System.out.format("----------------------------------------------------------------------%n");
		if (weeklyMax(s1, student2, 1) == 0f && weeklyMax(s1, student, 1) == 0f) {
			System.out.format("Maximum Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 1) == 0f) {
			System.out.format("Maximum of Sleep %25s %7.2f | %7s |%n","|", weeklyMax(s1, student, 1), "NaN");
		} else if (weeklyMax(s1, student, 1) == 0f) {
			System.out.format("Maximum Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", weeklyMax(s1, student2, 1));
		}else {
			System.out.format("Maximum Minutes of Sleep %25s %7.2f | %7.2f |%n","|", weeklyMax(s1, student, 1), weeklyMax(s1, student2, 1));
		}
		if (weeklyMax(s1, student, 2) == 0f && weeklyMax(s1, student2, 2) == 0f) {
			System.out.format("Maximum Amount of Sugary Drinks %18s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 2) == 0f) {
			System.out.format("Maximum Amount of Sugary Drinks %18s %7.2f | %7s |%n","|", weeklyMax(s1, student, 2), "NaN");
		} else if (weeklyMax(s1, student, 2) == 0f) {
			System.out.format("Maximum Amount of Sugary Drinks %18s %7s | %7.2f |%n","|", "NaN", weeklyMax(s1, student2, 2));
		}else {
			System.out.format("Maximum Amount of Sugary Drinks %18s %7.2f | %7.2f |%n","|", weeklyMax(s1, student, 2), weeklyMax(s1, student2, 2));
		}
		if (weeklyMax(s1, student, 3) == 0f && weeklyMax(s1, student2, 3) == 0f) {
			System.out.format("Maximum Minutes on Phone %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 3) == 0f) {
			System.out.format("Maximum Minutes on Phone %25s %7.2f | %7s |%n", "|", weeklyMax(s1, student, 3), "NaN");
		} else if (weeklyMax(s1, student, 3) == 0f) {
			System.out.format("Maximum Minutes on Phone %25s %7s | %7.2f |%n", "|","NaN", weeklyMax(s1, student2, 3));
		}else {
			System.out.format("Maximum Minutes on Phone %25s %7.2f | %7.2f |%n", "|", weeklyMax(s1, student, 3), weeklyMax(s1, student2, 3));
		}
		if (weeklyMax(s1, student, 4) == 0f && weeklyMax(s1, student2, 4) == 0f) {
			System.out.format("Maximum Servings of Fruit %24s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 4) == 0f) {
			System.out.format("Maximum Servings of Fruit %24s %7.2f | %7s |%n", "|", weeklyMax(s1, student, 4), "NaN");
		} else if (weeklyMax(s1, student, 4)  == 0f) {
			System.out.format("Maximum Servings of Fruit %24s %7s | %7.2f |%n", "|", "NaN", weeklyMax(s1, student2, 4) );
		}else {
			System.out.format("Maximum Servings of Fruit %24s %7.2f | %7.2f |%n", "|", weeklyMax(s1, student, 4) , weeklyMax(s1, student2, 4) );
		}
		if (weeklyMax(s1, student, 5)  == 0f && weeklyMax(s1, student2, 5)  == 0f) {
			System.out.format("Maximum Servings of Vegetables %19s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 5)  == 0f) {
			System.out.format("Maximum Servings of Vegetables %19s %7.2f | %7s |%n", "|", weeklyMax(s1, student, 5) , "NaN");
		} else if (weeklyMax(s1, student, 5)  == 0f) {
			System.out.format("Maximum Servings of Vegetables %19s %7s | %7.2f |%n", "|", "NaN", weeklyMax(s1, student2, 5) );
		}else {
			System.out.format("Maximum Servings of Vegetables %19s %7.2f | %7.2f |%n", "|", weeklyMax(s1, student, 5) , weeklyMax(s1, student2, 5) );
		}
		if (weeklyMax(s1, student, 6)  == 0f && weeklyMax(s1, student2, 6) == 0f) {
			System.out.format("Maximum Amount of Caffeinated Drinks %13s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 6)== 0f) {
			System.out.format("Maximum Amount of Caffeinated Drinks %13s %7.2f | %7s |%n", "|", weeklyMax(s1, student, 6), "NaN");
		} else if (weeklyMax(s1, student, 6) == 0f) {
			System.out.format("Maximum Amount of Caffeinated Drinks %13s %7s | %7.2f |%n", "|", "NaN", weeklyMax(s1, student2, 6));
		}else {
			System.out.format("Maximum Amount of Caffeinated Drinks %13s %7.2f | %7.2f |%n", "|", weeklyMax(s1, student, 6), weeklyMax(s1, student2, 6));
		}
		if (weeklyMax(s1, student, 7) == 0f && weeklyMax(s1, student2, 7)  == 0f) {
			System.out.format("Maximum Minutes of Strength Training %13s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 7)  == 0f) {
			System.out.format("Maximum Minutes of Strength Training %13s %7.2f | %7s |%n","|", weeklyMax(s1, student, 7) , "NaN");
		} else if (weeklyMax(s1, student, 7)  == 0f) {
			System.out.format("Maximum Minutes of Strength Training %13s %7s | %7.2f |%n","|", "NaN", weeklyMax(s1, student2, 7) );
		}else {
			System.out.format("Maximum Minutes of Strength Training %13s %7.2f | %7.2f |%n","|", weeklyMax(s1, student, 7) , weeklyMax(s1, student2, 7) );
		}
		if (weeklyMax(s1, student, 8)  == 0f && weeklyMax(s1, student2, 8)  == 0f) {
			System.out.format("Maximum Minutes of Moderate Intensity Training %3s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 8)  == 0f) {
			System.out.format("Maximum Minutes of Moderate Intensity Training %3s %7.2f | %7s |%n", "|", weeklyMax(s1, student, 8) , "NaN");
		} else if (weeklyMax(s1, student, 8)  == 0f) {
			System.out.format("Maximum Minutes of Moderate Intensity Training %3s %7s | %7.2f |%n", "|", "NaN", weeklyMax(s1, student2, 8) );
		}else {
			System.out.format("Maximum Minutes of Moderate Intensity Training %3s %7.2f | %7.2f |%n", "|", weeklyMax(s1, student, 8) , weeklyMax(s1, student2, 8) );
		}
		if (weeklyMax(s1, student, 9)  == 0f && weeklyMax(s1, student2, 9)  == 0f) {
			System.out.format("Maximum Minutes of High Intensity Training %7s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 9)  == 0f) {
			System.out.format("Maximum Minutes of High Intensity Training %7s %7.2f | %7s |%n", "|", weeklyMax(s1, student, 9) , "NaN");
		} else if (weeklyMax(s1, student, 9)  == 0f) {
			System.out.format("Maximum Minutes of High Intensity Training %7s %7s | %7.2f |%n", "|", "NaN", weeklyMax(s1, student2, 9) );
		}else {
			System.out.format("Maximum Minutes of High Intensity Training %7s %7.2f | %7.2f |%n", "|", weeklyMax(s1, student, 9) , weeklyMax(s1, student2, 9) );
		}
		if (weeklyMax(s1, student, 10)  == 0f && weeklyMax(s1, student2, 10) == 0f) {
			System.out.format("Maximum Amounts of Steps %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (weeklyMax(s1, student2, 10) == 0f) {
			System.out.format("Maximum Amounts of Steps %25s %7.2f | %7s |%n", "|", weeklyMax(s1, student, 10), "NaN");
		} else if (weeklyMax(s1, student, 10) == 0f) {
			System.out.format("Maximum Amounts of Steps %25s %7s | %7.2f |%n", "|", "NaN", weeklyMax(s1, student2, 10));
		}else {
			System.out.format("Maximum Amounts of Steps %25s %7.2f | %7.2f |%n", "|",weeklyMax(s1, student, 10), weeklyMax(s1, student2, 10));
		}
		System.out.format("----------------------------------------------------------------------%n");
	}
	public void compareStudentsVariance(students s1, int student, int student2){
		System.out.format("-----------------------------------------------------------------------------%n");
		System.out.format("Student %43s %8d %3s %9d %2s %n","|", s1.students.get(student).getId(),"|", s1.students.get(student2).getId(), "|");
		System.out.format("-----------------------------------------------------------------------------%n");
		if (varianceValue(s1, student2, 1) == 0f && varianceValue(s1, student, 1) == 0f) {
			System.out.format("Variance Minutes of Sleep %25s %10s | %10s |%n","|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 1) == 0f) {
			System.out.format("Variance of Sleep %25s %10.2f | %10s |%n","|", varianceValue(s1, student, 1), "NaN");
		} else if (varianceValue(s1, student, 1) == 0f) {
			System.out.format("Variance Minutes of Sleep %25s %10s | %10s |%n","|", "NaN", varianceValue(s1, student2, 1));
		}else {
			System.out.format("Variance Minutes of Sleep %25s %10.2f | %10.2f |%n","|", varianceValue(s1, student, 1), varianceValue(s1, student2, 1));
		}
		if (varianceValue(s1, student, 2) == 0f && varianceValue(s1, student2, 2) == 0f) {
			System.out.format("Variance Amount of Sugary Drinks %18s %10s | %10s |%n","|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 2) == 0f) {
			System.out.format("Variance Amount of Sugary Drinks %18s %10.2f | %10s |%n","|", varianceValue(s1, student, 2), "NaN");
		} else if (varianceValue(s1, student, 2) == 0f) {
			System.out.format("Variance Amount of Sugary Drinks %18s %10s | %10.2f |%n","|", "NaN", varianceValue(s1, student2, 2));
		}else {
			System.out.format("Variance Amount of Sugary Drinks %18s %10.2f | %10.2f |%n","|", varianceValue(s1, student, 2), varianceValue(s1, student2, 2));
		}
		if (varianceValue(s1, student, 3) == 0f && varianceValue(s1, student2, 3) == 0f) {
			System.out.format("Variance Minutes on Phone %25s %10s | %10s |%n", "|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 3) == 0f) {
			System.out.format("Variance Minutes on Phone %25s %10.2f | %10s |%n", "|", varianceValue(s1, student, 3), "NaN");
		} else if (varianceValue(s1, student, 3) == 0f) {
			System.out.format("Variance Minutes on Phone %25s %10s | %10.2f |%n", "|","NaN", varianceValue(s1, student2, 3));
		}else {
			System.out.format("Variance Minutes on Phone %25s %10.2f | %10.2f |%n", "|", varianceValue(s1, student, 3), varianceValue(s1, student2, 3));
		}
		if (varianceValue(s1, student, 4) == 0f && varianceValue(s1, student2, 4) == 0f) {
			System.out.format("Variance Servings of Fruit %24s %10s | %10s |%n", "|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 4) == 0f) {
			System.out.format("Variance Servings of Fruit %24s %10.2f | %10s |%n", "|", varianceValue(s1, student, 4), "NaN");
		} else if (varianceValue(s1, student, 4)  == 0f) {
			System.out.format("Variance Servings of Fruit %24s %10s | %10.2f |%n", "|", "NaN", varianceValue(s1, student2, 4) );
		}else {
			System.out.format("Variance Servings of Fruit %24s %10.2f | %10.2f |%n", "|", varianceValue(s1, student, 4) , varianceValue(s1, student2, 4) );
		}
		if (varianceValue(s1, student, 5)  == 0f && varianceValue(s1, student2, 5)  == 0f) {
			System.out.format("Variance Servings of Vegetables %19s %10s | %10s |%n", "|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 5)  == 0f) {
			System.out.format("Variance Servings of Vegetables %19s %10.2f | %10s |%n", "|", varianceValue(s1, student, 5) , "NaN");
		} else if (varianceValue(s1, student, 5)  == 0f) {
			System.out.format("Variance Servings of Vegetables %19s %10s | %10.2f |%n", "|", "NaN", varianceValue(s1, student2, 5) );
		}else {
			System.out.format("Variance Servings of Vegetables %19s %10.2f | %10.2f |%n", "|", varianceValue(s1, student, 5) , varianceValue(s1, student2, 5) );
		}
		if (varianceValue(s1, student, 6)  == 0f && varianceValue(s1, student2, 6) == 0f) {
			System.out.format("Variance Amount of Caffeinated Drinks %13s %10s | %10s |%n", "|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 6)== 0f) {
			System.out.format("Variance Amount of Caffeinated Drinks %13s %10.2f | %10s |%n", "|", varianceValue(s1, student, 6), "NaN");
		} else if (varianceValue(s1, student, 6) == 0f) {
			System.out.format("Variance Amount of Caffeinated Drinks %13s %10s | %10.2f |%n", "|", "NaN", varianceValue(s1, student2, 6));
		}else {
			System.out.format("Variance Amount of Caffeinated Drinks %13s %10.2f | %10.2f |%n", "|", varianceValue(s1, student, 6), varianceValue(s1, student2, 6));
		}
		if (varianceValue(s1, student, 7) == 0f && varianceValue(s1, student2, 7)  == 0f) {
			System.out.format("Variance Minutes of Strength Training %13s %10s | %10s |%n","|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 7)  == 0f) {
			System.out.format("Variance Minutes of Strength Training %13s %10.2f | %10s |%n","|", varianceValue(s1, student, 7) , "NaN");
		} else if (varianceValue(s1, student, 7)  == 0f) {
			System.out.format("Variance Minutes of Strength Training %13s %10s | %10.2f |%n","|", "NaN", varianceValue(s1, student2, 7) );
		}else {
			System.out.format("Variance Minutes of Strength Training %13s %10.2f | %10.2f |%n","|", varianceValue(s1, student, 7) , varianceValue(s1, student2, 7) );
		}
		if (varianceValue(s1, student, 8)  == 0f && varianceValue(s1, student2, 8)  == 0f) {
			System.out.format("Variance Minutes of Moderate Intensity Training %3s %10s | %10s |%n", "|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 8)  == 0f) {
			System.out.format("Variance Minutes of Moderate Intensity Training %3s %10.2f | %10s |%n", "|", varianceValue(s1, student, 8) , "NaN");
		} else if (varianceValue(s1, student, 8)  == 0f) {
			System.out.format("Variance Minutes of Moderate Intensity Training %3s %10s | %10.2f |%n", "|", "NaN", varianceValue(s1, student2, 8) );
		}else {
			System.out.format("Variance Minutes of Moderate Intensity Training %3s %10.2f | %10.2f |%n", "|", varianceValue(s1, student, 8) , varianceValue(s1, student2, 8) );
		}
		if (varianceValue(s1, student, 9)  == 0f && varianceValue(s1, student2, 9)  == 0f) {
			System.out.format("Variance Minutes of High Intensity Training %7s %10s | %10s |%n", "|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 9)  == 0f) {
			System.out.format("Variance Minutes of High Intensity Training %7s %10.2f | %10s |%n", "|", varianceValue(s1, student, 9) , "NaN");
		} else if (varianceValue(s1, student, 9)  == 0f) {
			System.out.format("Variance Minutes of High Intensity Training %7s %10s | %10.2f |%n", "|", "NaN", varianceValue(s1, student2, 9) );
		}else {
			System.out.format("Variance Minutes of High Intensity Training %7s %10.2f | %10.2f |%n", "|", varianceValue(s1, student, 9) , varianceValue(s1, student2, 9) );
		}
		if (varianceValue(s1, student, 10)  == 0f && varianceValue(s1, student2, 10) == 0f) {
			System.out.format("Variance Amounts of Steps %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (varianceValue(s1, student2, 10) == 0f) {
			System.out.format("Variance Amounts of Steps %25s %7.2f | %7s |%n", "|", varianceValue(s1, student, 10), "NaN");
		} else if (varianceValue(s1, student, 10) == 0f) {
			System.out.format("Variance Amounts of Steps %25s %7s | %7.2f |%n", "|", "NaN", varianceValue(s1, student2, 10));
		}else {
			System.out.format("Variance Amounts of Steps %25s %7.2f | %7.2f |%n", "|",varianceValue(s1, student, 10), varianceValue(s1, student2, 10));
		}
		System.out.format("-----------------------------------------------------------------------------%n");
	}
	public void compareStudentsDeviation(students s1, int student, int student2){
		System.out.format("---------------------------------------------------------------------------------%n");
		System.out.format("Student %53s %5d %3s %5d %3s %n","|", s1.students.get(student).getId(),"|", s1.students.get(student2).getId(), "|");
		System.out.format("---------------------------------------------------------------------------------%n");
		if (deviationValue(s1, student2, 1) == 0f && deviationValue(s1, student, 1) == 0f) {
			System.out.format("Standard Deviation Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 1) == 0f) {
			System.out.format("Standard Deviation of Sleep %25s %7.2f | %7s |%n","|", deviationValue(s1, student, 1), "NaN");
		} else if (deviationValue(s1, student, 1) == 0f) {
			System.out.format("Standard Deviation Minutes of Sleep %25s %7s | %7s |%n","|", "NaN", deviationValue(s1, student2, 1));
		}else {
			System.out.format("Standard Deviation Minutes of Sleep %25s %7.2f | %7.2f |%n","|", deviationValue(s1, student, 1), deviationValue(s1, student2, 1));
		}
		if (deviationValue(s1, student, 2) == 0f && deviationValue(s1, student2, 2) == 0f) {
			System.out.format("Standard Deviation Amount of Sugary Drinks %18s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 2) == 0f) {
			System.out.format("Standard Deviation Amount of Sugary Drinks %18s %7.2f | %7s |%n","|", deviationValue(s1, student, 2), "NaN");
		} else if (deviationValue(s1, student, 2) == 0f) {
			System.out.format("Standard Deviation Amount of Sugary Drinks %18s %7s | %7.2f |%n","|", "NaN", deviationValue(s1, student2, 2));
		}else {
			System.out.format("Standard Deviation Amount of Sugary Drinks %18s %7.2f | %7.2f |%n","|", deviationValue(s1, student, 2), deviationValue(s1, student2, 2));
		}
		if (deviationValue(s1, student, 3) == 0f && deviationValue(s1, student2, 3) == 0f) {
			System.out.format("Standard Deviation Minutes on Phone %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 3) == 0f) {
			System.out.format("Standard Deviation Minutes on Phone %25s %7.2f | %7s |%n", "|", deviationValue(s1, student, 3), "NaN");
		} else if (deviationValue(s1, student, 3) == 0f) {
			System.out.format("Standard Deviation Minutes on Phone %25s %7s | %7.2f |%n", "|","NaN", deviationValue(s1, student2, 3));
		}else {
			System.out.format("Standard Deviation Minutes on Phone %25s %7.2f | %7.2f |%n", "|", deviationValue(s1, student, 3), deviationValue(s1, student2, 3));
		}
		if (deviationValue(s1, student, 4) == 0f && deviationValue(s1, student2, 4) == 0f) {
			System.out.format("Standard Deviation Servings of Fruit %24s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 4) == 0f) {
			System.out.format("Standard Deviation Servings of Fruit %24s %7.2f | %7s |%n", "|", deviationValue(s1, student, 4), "NaN");
		} else if (deviationValue(s1, student, 4)  == 0f) {
			System.out.format("Standard Deviation Servings of Fruit %24s %7s | %7.2f |%n", "|", "NaN", deviationValue(s1, student2, 4) );
		}else {
			System.out.format("Standard Deviation Servings of Fruit %24s %7.2f | %7.2f |%n", "|", deviationValue(s1, student, 4) , deviationValue(s1, student2, 4) );
		}
		if (deviationValue(s1, student, 5)  == 0f && deviationValue(s1, student2, 5)  == 0f) {
			System.out.format("Standard Deviation Servings of Vegetables %19s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 5)  == 0f) {
			System.out.format("Standard Deviation Servings of Vegetables %19s %7.2f | %7s |%n", "|", deviationValue(s1, student, 5) , "NaN");
		} else if (deviationValue(s1, student, 5)  == 0f) {
			System.out.format("Standard Deviation Servings of Vegetables %19s %7s | %7.2f |%n", "|", "NaN", deviationValue(s1, student2, 5) );
		}else {
			System.out.format("Standard Deviation Servings of Vegetables %19s %7.2f | %7.2f |%n", "|", deviationValue(s1, student, 5) , deviationValue(s1, student2, 5) );
		}
		if (deviationValue(s1, student, 6)  == 0f && deviationValue(s1, student2, 6) == 0f) {
			System.out.format("Standard Deviation Amount of Caffeinated Drinks %13s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 6)== 0f) {
			System.out.format("Standard Deviation Amount of Caffeinated Drinks %13s %7.2f | %7s |%n", "|", deviationValue(s1, student, 6), "NaN");
		} else if (deviationValue(s1, student, 6) == 0f) {
			System.out.format("Standard Deviation Amount of Caffeinated Drinks %13s %7s | %7.2f |%n", "|", "NaN", deviationValue(s1, student2, 6));
		}else {
			System.out.format("Standard Deviation Amount of Caffeinated Drinks %13s %7.2f | %7.2f |%n", "|", deviationValue(s1, student, 6), deviationValue(s1, student2, 6));
		}
		if (deviationValue(s1, student, 7) == 0f && deviationValue(s1, student2, 7)  == 0f) {
			System.out.format("Standard Deviation Minutes of Strength Training %13s %7s | %7s |%n","|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 7)  == 0f) {
			System.out.format("Standard Deviation Minutes of Strength Training %13s %7.2f | %7s |%n","|", deviationValue(s1, student, 7) , "NaN");
		} else if (deviationValue(s1, student, 7)  == 0f) {
			System.out.format("Standard Deviation Minutes of Strength Training %13s %7s | %7.2f |%n","|", "NaN", deviationValue(s1, student2, 7) );
		}else {
			System.out.format("Standard Deviation Minutes of Strength Training %13s %7.2f | %7.2f |%n","|", deviationValue(s1, student, 7) , deviationValue(s1, student2, 7) );
		}
		if (deviationValue(s1, student, 8)  == 0f && deviationValue(s1, student2, 8)  == 0f) {
			System.out.format("Standard Deviation Minutes of Moderate Intensity Training %3s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 8)  == 0f) {
			System.out.format("Standard Deviation Minutes of Moderate Intensity Training %3s %7.2f | %7s |%n", "|", deviationValue(s1, student, 8) , "NaN");
		} else if (deviationValue(s1, student, 8)  == 0f) {
			System.out.format("Standard Deviation Minutes of Moderate Intensity Training %3s %7s | %7.2f |%n", "|", "NaN", deviationValue(s1, student2, 8) );
		}else {
			System.out.format("Standard Deviation Minutes of Moderate Intensity Training %3s %7.2f | %7.2f |%n", "|", deviationValue(s1, student, 8) , deviationValue(s1, student2, 8) );
		}
		if (deviationValue(s1, student, 9)  == 0f && deviationValue(s1, student2, 9)  == 0f) {
			System.out.format("Standard Deviation Minutes of High Intensity Training %7s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 9)  == 0f) {
			System.out.format("Standard Deviation Minutes of High Intensity Training %7s %7.2f | %7s |%n", "|", deviationValue(s1, student, 9) , "NaN");
		} else if (deviationValue(s1, student, 9)  == 0f) {
			System.out.format("Standard Deviation Minutes of High Intensity Training %7s %7s | %7.2f |%n", "|", "NaN", deviationValue(s1, student2, 9) );
		}else {
			System.out.format("Standard Deviation Minutes of High Intensity Training %7s %7.2f | %7.2f |%n", "|", deviationValue(s1, student, 9) , deviationValue(s1, student2, 9) );
		}
		if (deviationValue(s1, student, 10)  == 0f && deviationValue(s1, student2, 10) == 0f) {
			System.out.format("Standard Deviation Amounts of Steps %25s %7s | %7s |%n", "|", "NaN", "NaN");
		} else if (deviationValue(s1, student2, 10) == 0f) {
			System.out.format("Standard Deviation Amounts of Steps %25s %7.2f | %7s |%n", "|", deviationValue(s1, student, 10), "NaN");
		} else if (deviationValue(s1, student, 10) == 0f) {
			System.out.format("Standard Deviation Amounts of Steps %25s %7s | %7.2f |%n", "|", "NaN", deviationValue(s1, student2, 10));
		}else {
			System.out.format("Standard Deviation Amounts of Steps %25s %7.2f | %7.2f |%n", "|",deviationValue(s1, student, 10), deviationValue(s1, student2, 10));
		}
		System.out.format("---------------------------------------------------------------------------------%n");
	}
}
