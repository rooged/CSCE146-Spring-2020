//written by Timothy Gedney
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Student {
	
	//attributes
	private double labSum;
	private double labCount;
	private double labRSum;
	private double labRCount;
	private double hwSum;
	private double hwCount;
	private double exam01;
	private double exam02;
	private double finalExam;
	
	//constructor
	public Student() {
		this.labSum = 0.0;
		this.labCount = 0.0;
		this.labRSum = 0.0;
		this.labRCount = 0.0;
		this.hwSum = 0.0;
		this.hwCount = 0.0;
		this.exam01 = 0.0;
		this.exam02 = 0.0;
		this.finalExam = 0.0;
	}
	
	//accessors
	public double getLabAverage() {
		return this.labSum / this.labCount;
	}
	
	public double getLabReportAverage() {
		return this.labRSum / this.labRCount;
	}
	
	public double getHomeworkAverage() {
		return this.hwSum / this.hwCount;
	}
	
	public double getExam01() {
		return this.exam01;
	}
	
	public double getExam02() {
		return this.exam02;
	}
	
	public double getFinal() {
		return this.finalExam;
	}
	
	//compares the section name to find the correct variables to add the grade to
	public void addGrade(String section, int grade) {
		if (section.compareToIgnoreCase("Lab") == 0) {
			this.labSum += grade;
			this.labCount++;
		} else if (section.compareToIgnoreCase("Lab Report") == 0) {
			this.labRSum += grade;
			this.labRCount++;
		} else if (section.compareToIgnoreCase("Homework") == 0) {
			this.hwSum += grade;
			this.hwCount++;
		} else if (section.compareToIgnoreCase("Exam 1") == 0) {
			this.exam01 = grade;
		} else if (section.compareToIgnoreCase("Exam 2") == 0) {
			this.exam02 = grade;
		} else {
			this.finalExam = grade;
		}
	}
	
	//multiplies each section grade by their respective value
	public double getGradeNumeric() {
		//finds the highest two test grades using if/else to replace when needed
		double first = this.exam01;
		double second = this.exam02;
		if (this.exam01 < this.exam02) {
			first = this.exam02;
			second = this.exam01;
		}
		if (this.finalExam > first) {
			second = first;
			first = this.finalExam;
		} else if (this.finalExam > second) {
			second = this.finalExam;
		}
		return (this.getLabAverage() * .1) + (this.getLabReportAverage() * .1) + (this.getHomeworkAverage() * .2) + (first * .3) + (second * .3);
	}
	
	//uses the Math class .ceil method to get the rounded up whole number grade
	public double getGradeRounded() {
		return Math.ceil(this.getGradeNumeric());
	}
	
	//if/else statement to get the letter grade from the rounded grade
	public String getGradeLetter() {
		if (this.getGradeRounded() >= 90) {
			return "A";
		} else if (this.getGradeRounded() >= 85) {
			return "B+";
		} else if (this.getGradeRounded() >= 80) {
			return "B";
		} else if (this.getGradeRounded() >= 75) {
			return "C+";
		} else if (this.getGradeRounded() >= 70) {
			return "C";
		} else if (this.getGradeRounded() >= 65) {
			return "D+";
		} else if (this.getGradeRounded() >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	
	//reads a file and adds each line into their section grade
	public void readGradeFile(String file) {
		try {
			//initiates scanner to read the file and return the length of the file
			Scanner fileCount = new Scanner(new File(file));
			int size = 0;
			while (fileCount.hasNextLine()) {
				fileCount.nextLine();
				size++;
			}
			if (size <= 0) {
				System.out.println("The file is empty.");
				fileCount.close();
			}
			fileCount.close();
			//initiates a second scanner to read through the file and get each line
			Scanner fileScanner = new Scanner(new File(file));
			//for loop to read each line and split the line into a String & int variable
			for (int i = 0; i < size; i++) {
				if (!fileScanner.hasNextLine()) {
					break;
				}
				//once the line is split the addGrade method is called and section and grade are entered
				String line = fileScanner.nextLine();
				int index = line.indexOf("\t");
				String section = line.substring(0, index);
				int grade = Integer.parseInt(line.substring(index + 1));
				addGrade(section, grade);
			}
			fileScanner.close();
		}
		//catch blocks for any exceptions
		catch(IOException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	//toString for the print out
	public String toString() {
		return "Lab Average: " + this.getLabAverage() + "\nLab Report Average: " + this.getLabReportAverage() +
				"\nHomework Average: " + this.getHomeworkAverage() + "\nExam 01: " + this.getExam01() +
				"\nExam 02: " + this.getExam02() + "\nFinal Exam: " + this.getFinal() + "\nRaw Total: " + 
				this.getGradeNumeric() + "\nAdjusted: " + this.getGradeRounded() + "\nGrade: " + this.getGradeLetter();
	}

}
