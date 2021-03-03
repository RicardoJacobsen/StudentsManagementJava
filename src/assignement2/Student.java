/**
 * Title: Client Change
 * @author Ricardo Laner Jacobsen Teixeira
 * Date: 30/10/2020
 * File name: Assignment 2
 * Purpose: This program was created with the intuition of helping the user on manage data about work course and research students.
 * 
 */

package assignement2;

import java.io.Serializable;

public class Student {
    private String  titleOfStudent;
    private String firstName;
    private String lastName;
    private long studentNumber;
    private int day;
    private int month;
    private int year;
    
 
    
    
    
    public Student(){
    titleOfStudent= this.titleOfStudent;
    firstName = this.firstName;
    lastName = this.lastName;
    studentNumber=this.studentNumber;
    day= this.day;
    month= this.month;
    year= this.year;
    }
    
    public Student(String ts, String fn, String ln, long sn, int day, int month, int year){
    
   this. titleOfStudent= ts;
   this.firstName = fn;
   this.lastName = ln;
   this.studentNumber=sn;
   this.day= day;
   this.month= month;
   this.year= year;
    }

    public String getTitleOfStudent() {
        return titleOfStudent;
    }

    public void setTitleOfStudent(String titleOfStudent) {
        this.titleOfStudent = titleOfStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

       public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    

   
     public boolean isEqual (CourseWorkStudent cws, ResearchStudent rs){
  boolean flag= false;    
           
   if((cws.getFirstName().equalsIgnoreCase(rs.getFirstName())) && (cws.getLastName().equalsIgnoreCase(rs.getLastName())) && (cws.getDay()==rs.getDay()) && (cws.getMonth()==rs.getMonth()) && (cws.getYear())==rs.getYear()){
   flag = true;
   }
   return flag;
     
       
     }
    

 
    
    
    
    
    
    
}


