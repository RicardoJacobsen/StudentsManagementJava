/**
 * Title: Client Change
 * @author Ricardo Laner Jacobsen Teixeira
 * Date: 30/10/2020
 * File name: Assignment 2
 * Purpose: This program was created with the intuition of helping the user on manage data about work course and research students.
 * 
 */

package assignement2;

import static assignement2.Client.courseWorkArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseWorkStudent extends Student {
  public static Scanner input = new Scanner (System.in);
  
//declaring the variables     
    private int assignment1;
   private int assignment2;
   private int weeklyPracticalWork;
   private int finalExam;

   
// Default constructor 
    public CourseWorkStudent() {
        this.assignment1= assignment1;
        this.assignment2= assignment2;
        this.weeklyPracticalWork= weeklyPracticalWork;
        this.finalExam= finalExam;
        
    }
//parametrized constructor
    public CourseWorkStudent(int assignment1, int assignment2, int weeklyPracticalWork, int finalExam) {
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.weeklyPracticalWork = weeklyPracticalWork;
        this.finalExam = finalExam;
    }
//parametrized constructor with the super class attributes 
    public CourseWorkStudent(int assignment1, int assignment2, int weeklyPracticalWork, int finalExam, String ts, String fn, String ln, long sn, int day, int month, int year) {
        super(ts, fn, ln, sn, day, month, year);
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.weeklyPracticalWork = weeklyPracticalWork;
        this.finalExam = finalExam;
    }
   
 

    public int getAssignment1() {
        return assignment1;
    }

    public void setAssignment1(int assignment1) {
        this.assignment1 = assignment1;
    }

    public int getAssignment2() {
        return assignment2;
    }

    public void setAssignment2(int assignment2) {
        this.assignment2 = assignment2;
    }

    public int getWeeklyPracticalWork() {
        return weeklyPracticalWork;
    }

    public void setWeeklyPracticalWork(int weeklyPracticalWork) {
        this.weeklyPracticalWork = weeklyPracticalWork;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }
   
   public int overallMark(){
       int overall= (((this.assignment1*25)+(this.assignment2*25)+(this.weeklyPracticalWork*20)+(this.finalExam*30))/100);
       
       return overall;
   }
   
   public String finalGrade(){
  int fg = this.overallMark();
       String situation =" ";
       
       if(fg>=80){situation ="The Course Work Student " +getFirstName()+" was aproved with the OVERALL  "+overallMark()+ "%, and the GRADED AS High Distintion(HD)."; }
       else if (fg>=70 && fg<80){situation="The Course Work Student " +getFirstName()+" was aproved with the OVERALL "+overallMark()+ "%, and the GRADED AS Distintion (D)."; }
       else if (fg>=60 && fg<70){situation="The Course Work Student " +getFirstName()+" was aproved with the OVERALL "+overallMark()+ "%, and the GRADED AS Credit (C)."; }
       else if (fg>=50 && fg<60){situation="The Course Work Student " +getFirstName()+" was aproved with the OVERALL "+overallMark()+ "%, and the GRADED AS Pass (P)."; }
       else if (fg<50){situation="The Course Work Student " +getFirstName()+" was not aproved  with " + overallMark() + "%, and the GRADED AS (N)."; }
       
       
       
       return situation;
   }
   
   public static void loadCourseWorkStundent() throws FileNotFoundException{
if(Client.courseWorkArray.isEmpty()){
     File f = new File ("coursework.txt");
          
          Scanner txt = new Scanner (f);
          while(txt.hasNext()){
          String record = txt.nextLine();
          Scanner ScanRecord = new Scanner(record);
          ScanRecord.useDelimiter("#");
          String  titleOfStudent, firstName, lastName;
          long studentNumber;
          int day,month,year,assignment1, assignment2, weeklyPracticalWork, finalExam;

          // needed to be recreated because of scan order;
          titleOfStudent = ScanRecord.next();
          firstName = ScanRecord.next();
          lastName = ScanRecord.next();
          studentNumber = ScanRecord.nextLong();
          day = ScanRecord.nextInt();
          month = ScanRecord.nextInt();
          year = ScanRecord.nextInt();
          assignment1=ScanRecord.nextInt();
          assignment2=ScanRecord.nextInt();
          weeklyPracticalWork= ScanRecord.nextInt();
          finalExam= ScanRecord.nextInt();
          
           
  CourseWorkStudent cws = new CourseWorkStudent(assignment1,assignment2,weeklyPracticalWork,finalExam,titleOfStudent,firstName,lastName,studentNumber,day,month,year);
  Client.courseWorkArray.add(cws);
     } //end of if
  }//end of while loop
}//end of loading method
   
   
   public static void loadNewCourseWorkStundent() throws FileNotFoundException{
if(Client.courseWorkArray.isEmpty()){
     File f = new File ("newCourseWork.txt");
          
          Scanner txt = new Scanner (f);
          while(txt.hasNext()){
          String record = txt.nextLine();
          Scanner ScanRecord = new Scanner(record);
          ScanRecord.useDelimiter("#");
          String  titleOfStudent, firstName, lastName;
          long studentNumber;
          int day,month,year,assignment1, assignment2, weeklyPracticalWork, finalExam;

          // needed to be recreated because of scan order;
          titleOfStudent = ScanRecord.next();
          firstName = ScanRecord.next();
          lastName = ScanRecord.next();
          studentNumber = ScanRecord.nextLong();
          day = ScanRecord.nextInt();
          month = ScanRecord.nextInt();
          year = ScanRecord.nextInt();
          assignment1=ScanRecord.nextInt();
          assignment2=ScanRecord.nextInt();
          weeklyPracticalWork= ScanRecord.nextInt();
          finalExam= ScanRecord.nextInt();
          
           
  CourseWorkStudent cws = new CourseWorkStudent(assignment1,assignment2,weeklyPracticalWork,finalExam,titleOfStudent,firstName,lastName,studentNumber,day,month,year);
  Client.courseWorkArray.add(cws);
     } //end of if
  }//end of while loop
}//end of loading method
   
   
   public static int deleteCourseWorkStundent(long id){
    int position = -1;
        
        for (int i = 0; i < Client.courseWorkArray.size(); i++) {        
        if(Client.courseWorkArray.get(i).getStudentNumber()==id){
             position = i;
              System.out.println("The STUDENT ID "+id+" "+ Client.courseWorkArray.get(i).getFirstName()+" "+Client.courseWorkArray.get(i).getLastName()+" WAS FOUND");
              
              char confirmation= ' ' ;
              while(confirmation !='Y' && confirmation !='N' ){
              System.out.println("DO YOU CONFIRM THE EXCLUSION? [Y/N]");
               confirmation = input.next().toUpperCase().charAt(0);    }
              if(confirmation=='Y'){
                  position = i;
              }else {
                  position = -1;
              }
              break;   
                  }
                                    
        }         
           return position;
   
    }
 
   public static void displayAllCourseWorkStudents(){
 System.out.println("All the INFORMATION about COURSE WORK STUDENTS:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      for (int i = 0; i < Client.courseWorkArray.size(); i++) {
                System.out.println("STUDENT "+(i+1)+": ");
                System.out.println(Client.courseWorkArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.courseWorkArray.get(i).getFirstName()+" "+
                                                    Client.courseWorkArray.get(i).getLastName()+" "+
                                                    Client.courseWorkArray.get(i).getStudentNumber()+" "+
                                                    Client.courseWorkArray.get(i).getDay()+"/"+
                                                    Client.courseWorkArray.get(i).getMonth()+"/"+
                                                    Client.courseWorkArray.get(i).getYear()+" "+
                                                    "ASSIGNMENT 1: "+Client.courseWorkArray.get(i).getAssignment1()+"% "+
                                                    "ASSIGNMENT 2: "+Client.courseWorkArray.get(i).getAssignment2()+"% "+
                                                    " Weekly pract. Work: "+Client.courseWorkArray.get(i).getWeeklyPracticalWork()+"% "+
                                                    " Final Exam: "+Client.courseWorkArray.get(i).getFinalExam()+"%");
                
                String situation= Client.courseWorkArray.get(i).finalGrade();
                System.out.println(situation+"\n");
                
          }//end of for loop
    }//end of method 
   
    public static void AvarageCourseWork(){
        int counter =0;
        int overall;
        
        for (int i = 0; i < Client.courseWorkArray.size(); i++) {
            overall=Client.courseWorkArray.get(i).overallMark();
            if (overall>=50) {     
                        counter +=1;
            }
        }
   System.out.println("The system found FROM COURSE WORK STUDENTS "+counter+" STUDEND(S) which had the overall EQUAL TO OR ABOVE THE AVARAGE.");
   counter =0;//cleaning for the next loop
   
   
    for (int i = 0; i < Client.courseWorkArray.size(); i++) {
        overall=Client.courseWorkArray.get(i).overallMark();
            if (overall<50) {     
                        counter +=1;
            }
        }
    System.out.println("The system found FROM COURSE WORK STUDENTS "+counter+" STUDEND(S) which had the overall BELLOW THE AVARAGE.");   
    
    }//end of method
    
    
 public static int findID(long id ){
    int ret=0;
     for (int i = 0; i < Client.courseWorkArray.size(); i++) {
         if (Client.courseWorkArray.get(i).getStudentNumber()==id) {
             System.out.println("The ID WAS FOUND in Research student.");
             System.out.println("STUDENT INFORMATION");
             System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
             break;
              } else{
             ret=-1;
         }
        }//end of for
     
     for (int i = 0; i < Client.courseWorkArray.size(); i++) {
         if (Client.courseWorkArray.get(i).getStudentNumber()==id) {            
                System.out.println(Client.courseWorkArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.courseWorkArray.get(i).getFirstName()+" "+
                                                    Client.courseWorkArray.get(i).getLastName()+" "+
                                                    Client.courseWorkArray.get(i).getStudentNumber()+" "+
                                                    Client.courseWorkArray.get(i).getDay()+"/"+
                                                    Client.courseWorkArray.get(i).getMonth()+"/"+
                                                    Client.courseWorkArray.get(i).getYear()+" "+
                                                    "ASSIGNMENT 1: "+Client.courseWorkArray.get(i).getAssignment1()+"% "+
                                                    "ASSIGNMENT 2: "+Client.courseWorkArray.get(i).getAssignment2()+"% "+
                                                    " Weekly pract. Work: "+Client.courseWorkArray.get(i).getWeeklyPracticalWork()+"% "+
                                                    " Final Exam: "+Client.courseWorkArray.get(i).getFinalExam()+"%\n");
     
         }//end of if
     }//end of for
     return ret;
 }//end of find ID   
 
 public static int findByName(String name , String lastName){
       int ret=0;
       
       for (int i = 0; i < Client.courseWorkArray.size(); i++) {
           //to receive the name from the arrray
           String nameinarr =Client.courseWorkArray.get(i).getFirstName();
           if (nameinarr.equalsIgnoreCase(name)) {
                  nameinarr=Client.courseWorkArray.get(i).getLastName();
                   if (nameinarr.equalsIgnoreCase(lastName)) {
                       System.out.println("THE NAME WAS FOUND IN COURSE WORK ");
                         System.out.println("STUDENT INFORMATION");
                             System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                       break;
                   }
               }else {
                   ret=-1;
                   }
           }
       
       
        for (int i = 0; i < Client.courseWorkArray.size(); i++) {
           //to receive the name from the arrray
           String nameinarr =Client.courseWorkArray.get(i).getFirstName();
           if (nameinarr.equalsIgnoreCase(name)) {
                  nameinarr=Client.courseWorkArray.get(i).getLastName();
                   if (nameinarr.equalsIgnoreCase(lastName)) {     
                System.out.println(Client.courseWorkArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.courseWorkArray.get(i).getFirstName()+" "+
                                                    Client.courseWorkArray.get(i).getLastName()+" "+
                                                    Client.courseWorkArray.get(i).getStudentNumber()+" "+
                                                    Client.courseWorkArray.get(i).getDay()+"/"+
                                                    Client.courseWorkArray.get(i).getMonth()+"/"+
                                                    Client.courseWorkArray.get(i).getYear()+" "+
                                                    "ASSIGNMENT 1: "+Client.courseWorkArray.get(i).getAssignment1()+"% "+
                                                    "ASSIGNMENT 2: "+Client.courseWorkArray.get(i).getAssignment2()+"% "+
                                                    " Weekly pract. Work: "+Client.courseWorkArray.get(i).getWeeklyPracticalWork()+"% "+
                                                    " Final Exam: "+Client.courseWorkArray.get(i).getFinalExam()+"%");
     
                   }
           }
       }
       
       
       
       return ret;
   }//end of findByName
 public static void sortByID(){
ArrayList<CourseWorkStudent> temp = new ArrayList();
  
    for (int i = 0; i < Client.courseWorkArray.size(); i++) {
        
        for (int j = Client.courseWorkArray.size()- 1; j > i; j--) {
       
                if (Client.courseWorkArray.get(i).getStudentNumber()>Client.courseWorkArray.get(j).getStudentNumber()) {
                    temp.add(0, Client.courseWorkArray.get(i));
                    Client.courseWorkArray.set(i,Client.courseWorkArray.get(j));
                   Client.courseWorkArray.set(j,temp.get(0));
                }
        }
     
     }
     System.out.println("The sorted Array by ID is: ");
         for (int i = 0; i < Client.courseWorkArray.size(); i++) {
             System.out.println(   "ID: " +Client.courseWorkArray.get(i).getStudentNumber()+" Name: "+
                                                    Client.courseWorkArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.courseWorkArray.get(i).getFirstName()+" "+
                                                    Client.courseWorkArray.get(i).getLastName()+" "+
                                                    Client.courseWorkArray.get(i).getDay()+"/"+
                                                    Client.courseWorkArray.get(i).getMonth()+"/"+
                                                    Client.courseWorkArray.get(i).getYear()+" "+
                                                 "ASSIGNMENT 1: "+Client.courseWorkArray.get(i).getAssignment1()+"% "+
                                                    "ASSIGNMENT 2: "+Client.courseWorkArray.get(i).getAssignment2()+"% "+
                                                    " Weekly pract. Work: "+Client.courseWorkArray.get(i).getWeeklyPracticalWork()+"% "+
                                                    " Final Exam: "+Client.courseWorkArray.get(i).getFinalExam()+"%");
     
         }//end of if
     
     
 }//end of method
 
    public static void toCsv(){
 String fileName ="coursework.csv"; 
                  
            PrintWriter outputStream = null;
            try{
                outputStream = new PrintWriter(fileName); /* Give the name of the file as .csv format */
            }
            catch(FileNotFoundException e){ /* Error message when there is a problem opening the files */
                System.out.println("Error opening the file"+fileName);
                System.exit(0);
            }
              for(int i=0;i<Client.courseWorkArray.size();i++){
            outputStream.println(Client.courseWorkArray.get(i).getTitleOfStudent()+","+ 
                                                    Client.courseWorkArray.get(i).getFirstName()+","+
                                                    Client.courseWorkArray.get(i).getLastName()+","+
                                                    Client.courseWorkArray.get(i).getStudentNumber()+","+
                                                    Client.courseWorkArray.get(i).getDay()+"/"+
                                                    Client.courseWorkArray.get(i).getMonth()+"/"+
                                                    Client.courseWorkArray.get(i).getYear()+","+
                                                    Client.courseWorkArray.get(i).getAssignment1()+","+
                                                    Client.courseWorkArray.get(i).getAssignment2()+", "+
                                                    Client.courseWorkArray.get(i).getWeeklyPracticalWork()+","+
                                                    Client.courseWorkArray.get(i).getFinalExam()); /* Write the information into files */
          
              }
            outputStream.close(); /* Close the files */
          

}
    
}//end of class


