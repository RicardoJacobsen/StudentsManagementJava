/**
 * Title: Client Change
 * @author Ricardo Laner Jacobsen Teixeira
 * Date: 30/10/2020
 * File name: Assignment 2
 * Purpose: This program was created with the intuition of helping the user on manage data about work course and research students.
 * 
 */


package assignement2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

    public static Scanner input = new Scanner(System.in);
    //Arrays to store the objects cws and rs
    public static ArrayList<CourseWorkStudent> courseWorkArray = new ArrayList();
    public static ArrayList<ResearchStudent> researchArray = new ArrayList();

    public static void main(String[] args) throws IOException {

        int courseworkOrResearch = 0;

        StudentInfo();

        int menu;
        //stores the return from the try catch in the Verify class
        boolean res;
        do {
           displayMenu();
           Verify.tryInt();
           menu=Verify.integer;  
           
            if (menu>=1 || menu<=11) {
                
           
            switch (menu) {

                case 1:
                    System.out.println("\nYou QUIT, thank you for using this program.\nBye!");
                    System.exit(0);

                    break;

                case 2:
                    do {
                        System.out.println("Would you like to manage the COURSE WORK STUDENTS (ENTER 1) or RESEARCH STUDENTS (ENTER 2)? ");

                          Verify.tryInt();
                          courseworkOrResearch=Verify.integer;
                            if (courseworkOrResearch == 1) {
                                CourseWorkStudent.loadCourseWorkStundent();
                                System.out.println("\nOverall Determined!");
                            } else if (courseworkOrResearch == 2) {
                                ResearchStudent.loadResearchStundent();
                                System.out.println("\nOverall Determined!");
                            }
                             } while (courseworkOrResearch != 1 && courseworkOrResearch != 2);

                    break;

                case 3:
                    do {
                        System.out.println("Would you like to manage the COURSE WORK STUDENTS (ENTER 1) or RESEARCH STUDENTS (ENTER 2)? ");

                        Verify.tryInt();
                          courseworkOrResearch=Verify.integer;
                            if (courseworkOrResearch == 1) {
                                CourseWorkStudent.loadCourseWorkStundent();
                                System.out.println("ENTER THE STUDENT ID: ");
                                long id = input.nextLong();
                                int position = CourseWorkStudent.deleteCourseWorkStundent(id);
                                if (position == -1) {
                                    System.out.println("The EXCLUSION WAS ABORTED OR NOT FOUND.\n");
                                } else {
                                    courseWorkArray.remove(position);
                                    System.out.println(" The STUDENT NOW IS DELETED.\n");
                                }
                            } else if (courseworkOrResearch == 2) {
                                ResearchStudent.loadResearchStundent();
                                System.out.println("ENTER THE STUDENT ID: ");
                                long id = input.nextLong();
                                int position = ResearchStudent.deleteResearchStudent(id);
                                if (position == -1) {
                                    System.out.println("The EXCLUSION WAS ABORTED.\n");
                                } else {
                                    researchArray.remove(position);
                                    System.out.println(" The STUDENT NOW IS DELETED.\n");
                                }
                            }
                        

                    } while (courseworkOrResearch != 1 && courseworkOrResearch != 2);
                    break;

                case 4:

                    CourseWorkStudent.loadCourseWorkStundent();
                    ResearchStudent.loadResearchStundent();
                    CourseWorkStudent.displayAllCourseWorkStudents();
                    ResearchStudent.displayAllResearchStudents();
                    break;

                case 5:
                    do {
                        System.out.println("Would you like to manage the COURSE WORK STUDENTS (ENTER 1) or RESEARCH STUDENTS (ENTER 2)? ");

                        

                            Verify.tryInt();
                          courseworkOrResearch=Verify.integer;
                            if (courseworkOrResearch == 1) {
                                CourseWorkStudent.loadCourseWorkStundent();
                                for (int i = 0; i < courseWorkArray.size(); i++) {
                                    System.out.println("STUDENT " + (i + 1));
                                    System.out.println(courseWorkArray.get(i).getFirstName() + " " + courseWorkArray.get(i).getLastName() + " " + courseWorkArray.get(i).finalGrade());
                                }

                            } else if (courseworkOrResearch == 2) {
                                ResearchStudent.loadResearchStundent();
                                for (int i = 0; i < researchArray.size(); i++) {
                                    System.out.println("STUDENT " + (i + 1));
                                    System.out.println(researchArray.get(i).getFirstName() + " " + researchArray.get(i).getLastName() + " " + researchArray.get(i).finalGrade());
                                }
                            }
                        
                    } while (courseworkOrResearch != 1 && courseworkOrResearch != 2);

                    break;
                case 6:
                    CourseWorkStudent.loadCourseWorkStundent();
                    CourseWorkStudent.AvarageCourseWork();
                    ResearchStudent.loadResearchStundent();
                    ResearchStudent.AvarageResearch();

                    break;

                case 7:

                    int ret = 0;

                    do {
                        System.out.println("ENTER THE ID TO BE FOUND:  ");
                        try {

                            long id = input.nextLong();
                            CourseWorkStudent.loadCourseWorkStundent();
                            ret = CourseWorkStudent.findID(id);
                            if (ret == -1) {
                                System.out.println("ID NOT FOUND IN COURSE WORK!");
                            }

                            ret = 0;// cleaning the return

                            ResearchStudent.loadResearchStundent();
                            ret = ResearchStudent.findID(id);
                            if (ret == -1) {
                                System.out.println("ID NOT FOUND IN RESEARCH!");
                            }
                            ret = 0;// cleaning the return
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("This is not a number. TRY AGAIN!");
                            menu = 0;
                            input.next();

                        }
                    } while (true);
                    break;

                case 8:

                    input.nextLine();//cleaning the input 

                    do {

                        try {

                            System.out.println("ENTER THE FIRST NAME:  ");
                            String name = input.nextLine();

                            System.out.println("ENTER THE LAST NAME:  ");

                            String lastName = input.nextLine();

                            CourseWorkStudent.loadCourseWorkStundent();
                            ret = CourseWorkStudent.findByName(name, lastName);
                            if (ret == -1) {
                                System.out.println("THE FULNAME GIVEN WAS NOT FOUND IN COURSE WORK!");
                            }

                            ret = 0;// cleaning the return

                            ResearchStudent.loadResearchStundent();

                            ret = ResearchStudent.findByName(name, lastName);
                            if (ret == -1) {
                                System.out.println("THE FULNAME GIVEN WAS NOT FOUND IN RESEARCH!");
                            }
                            ret = 0;// cleaning the return
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("This is not a number. TRY AGAIN!");
                            menu = 0;
                            input.next();

                        }
                    } while (true);
                    break;
                case 9:
                    do {
                        System.out.println("Would you like to manage the COURSE WORK STUDENTS (ENTER 1) or RESEARCH STUDENTS (ENTER 2)? ");

                     Verify.tryInt();
                          courseworkOrResearch=Verify.integer;
                            courseworkOrResearch = input.nextInt();
                            if (courseworkOrResearch == 1) {
                                CourseWorkStudent.loadCourseWorkStundent();
                                CourseWorkStudent.sortByID();
                            } else if (courseworkOrResearch == 2) {
                                ResearchStudent.loadResearchStundent();
                                ResearchStudent.sortByID();

                            }
                      
                    } while (courseworkOrResearch != 1 && courseworkOrResearch != 2);

                    break;

                case 10:
                    do {
                        System.out.println("Would you like to manage the COURSE WORK STUDENTS (ENTER 1) or RESEARCH STUDENTS (ENTER 2)? ");
                          Verify.tryInt();
                          courseworkOrResearch=Verify.integer;
                            if (courseworkOrResearch == 1) {
                                CourseWorkStudent.loadCourseWorkStundent();
                                CourseWorkStudent.sortByID();
                                CourseWorkStudent.toCsv();

                                System.out.println("Csv created!");
                            } else if (courseworkOrResearch == 2) {
                                ResearchStudent.loadResearchStundent();
                                ResearchStudent.sortByID();
                                ResearchStudent.toCsv();
                                System.out.println("Csv created!");
                            }

                       
                    } while (courseworkOrResearch != 1 && courseworkOrResearch != 2);
                    break;
                    
                    //ADDED TO THE EXAM
                     case 11:
                    do {
                        System.out.println("Would you like to ADD THE NEW STUDENTS IN THE COURSE WORK STUDENTS (ENTER 1) or RESEARCH STUDENTS (ENTER 2)? ");

                    Verify.tryInt();
                          courseworkOrResearch=Verify.integer;
                            if (courseworkOrResearch == 1) {
                                CourseWorkStudent.loadNewCourseWorkStundent();
                             System.out.println("NEW STUDENTS ADDED!");
                     
                            } else if (courseworkOrResearch == 2) {
                                ResearchStudent.loadNewResearchStundent();
                                System.out.println("NEW STUDENTS ADDED!");
                            }

                      
                    } while (courseworkOrResearch != 1 && courseworkOrResearch != 2);
            }//End of Switch
 }//end of if menu in range
        } while (true);

    }
//method to display menu
    public static void displayMenu() {
        System.out.println("========================================MENU========================================");
        System.out.println(" ");

        System.out.println("1. QUIT PROGRAM.\n"
                + "2. DETERMINE THE STUDENT'S OVERALL MARK AND GRADE.\n"
                + "3. REMOVE A STUDENT INFORMATION .\n"
                + "4. DISPLAY ALL THE INFORMATION ABOUT OF ALL STUDENTS.\n"
                + "5. COMPUTE AND DISPLARY THE OVERALL MARK AND GRADE FOR ALL STUDENTS.\n"
                + "6. DISPLAY HOW MANY STUDENTS HAD (EUQUAL TO OR ABOVE ) OR BELOW THE AVARAGE.\n"
                + "7. DISPLAY INFORMATION BY SUTDENT ID.\n"
                + "8. DISPLAY INFORMATION BY NAME AND LAST NAME.\n"
                + "9. SORT AND DISPLAY THE STUDENT BY ID.\n"
                + "10. CREATE A CSV FILE FROM THE SORTED STUDENTS.\n "
                   //Created for the EXAM
                + "11. ADD NEW STUDENTS. "
                );
             
                
        
        System.out.println("WHAT IS YOUR OPTION: : ");

    }
//method to display the student information
    public static void StudentInfo() {
        System.out.println("Name: Ricardo Laner Jacobsen Teixeira");
        System.out.println("Student Number: 34031229");
        System.out.println("Mode of enrolment: Internal ");
        System.out.println("Tutor: Upeka Somaratne");
        System.out.println("Tutorial: Thursday 3:30 pm\n\n");
    }

}
