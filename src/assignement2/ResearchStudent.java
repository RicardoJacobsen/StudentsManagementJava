/**
 * Title: Client Change
 * @author Ricardo Laner Jacobsen Teixeira
 * Date: 30/10/2020
 * File name: Assignment 2
 * Purpose: This program was created with the intuition of helping the user on manage data about work course and research students.
 * 
 */

package assignement2;

import static assignement2.Client.researchArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ResearchStudent extends Student {
public static Scanner input = new Scanner (System.in);
    //declaring the variables     
    private int proposalComponent ;
    private int finalOralPresentation ;
    private int finalThesis ;
    

    // Default constructor 
    public ResearchStudent() {
        this.proposalComponent = proposalComponent;
        this.finalOralPresentation =finalOralPresentation;
        this.finalThesis =finalThesis;
    }
//parametrized constructor
    public ResearchStudent(int proposalComponent, int finalOralPresentation, int finalThesis) {
        this.proposalComponent = proposalComponent;
        this.finalOralPresentation = finalOralPresentation;
        this.finalThesis = finalThesis;
    }
//parametrized constructor with the super class attributes 
    public ResearchStudent(int proposalComponent, int finalOralPresentation, int finalThesis, String ts, String fn, String ln, long sn,int day, int month, int year) {
        super(ts, fn, ln, sn, day, month, year);
        this.proposalComponent = proposalComponent;
        this.finalOralPresentation = finalOralPresentation;
        this.finalThesis = finalThesis;
    }

    public int getProposalComponent() {
        return proposalComponent;
    }

    public void setProposalComponent(int proposalComponent) {
        this.proposalComponent = proposalComponent;
    }

    public int getFinalOralPresentation() {
        return finalOralPresentation;
    }

    public void setFinalOralPresentation(int finalOralPresentation) {
        this.finalOralPresentation = finalOralPresentation;
    }

    public int getFinalThesis() {
        return finalThesis;
    }

    public void setFinalThesis(int finalThesis) {
        this.finalThesis = finalThesis;
    }
    
    public int overallMark(){
       int overall= (((this.proposalComponent*30)+(this.finalOralPresentation*10)+(this.finalThesis*60))/100);
       
       return overall;
   }
   
   public String finalGrade(){
       int fg = this.overallMark();
       String situation =" ";
       
       if(fg>=80){situation ="The Research Student " +getFirstName()+" was aproved with the OVERALL "+overallMark()+ "%, and the GRADED AS High Distintion(HD)."; }
       else if (fg>=70 && fg<80){situation="The Research Student " +getFirstName()+" was aproved with the OVERALL "+overallMark()+ "%, and the GRADED AS Distintion (D)."; }
       else if (fg>=60 && fg<70){situation="The Research Student " +getFirstName()+" was aproved with the OVERALL "+overallMark()+ "%, and the GRADED AS Credit (C)."; }
       else if (fg>=50 && fg<60){situation="The Research Student " +getFirstName()+" was aproved with the OVERALL "+overallMark()+ "%, and the GRADED AS Pass (P)."; }
       else if (fg<50){situation="The Research Student " +getFirstName()+"  was not aproved with the OVERALL " + overallMark() + "%, and the GRADED AS Reproved(N)."; }
       
       
       return situation;
   }
    
    public static void loadResearchStundent() throws FileNotFoundException{
if(Client.researchArray.isEmpty()){
      File f = new File ("research.txt");
          
          Scanner txt = new Scanner (f);
          while(txt.hasNext()){
          String record = txt.nextLine();
          Scanner ScanRecord = new Scanner(record);
          ScanRecord.useDelimiter("#");
          String  titleOfStudent, firstName, lastName;
          long studentNumber;
          int day, month,year, proposalComponent , finalOralPresentation, finalThesis ;

          // needed to be recreated because of scan order;
          titleOfStudent = ScanRecord.next();
          firstName = ScanRecord.next();
          lastName = ScanRecord.next();
          studentNumber = ScanRecord.nextLong();
          day = ScanRecord.nextInt();
          month = ScanRecord.nextInt();
          year = ScanRecord.nextInt();                
          proposalComponent=ScanRecord.nextInt();
          finalOralPresentation=ScanRecord.nextInt();
          finalThesis= ScanRecord.nextInt();
         
          
  ResearchStudent rs = new ResearchStudent(proposalComponent,finalOralPresentation,finalThesis,titleOfStudent,firstName,lastName,studentNumber,day,month,year);
     
             Client.researchArray.add(rs);
          }//end of while loop
     } //end of if
}//end of loading method
    
    
        public static void loadNewResearchStundent() throws FileNotFoundException{
if(Client.researchArray.isEmpty()){
      File f = new File ("newRecordsResearch.txt");
          
          Scanner txt = new Scanner (f);
          while(txt.hasNext()){
          String record = txt.nextLine();
          Scanner ScanRecord = new Scanner(record);
          ScanRecord.useDelimiter("#");
          String  titleOfStudent, firstName, lastName;
          long studentNumber;
          int day, month,year, proposalComponent , finalOralPresentation, finalThesis ;

          // needed to be recreated because of scan order;
          titleOfStudent = ScanRecord.next();
          firstName = ScanRecord.next();
          lastName = ScanRecord.next();
          studentNumber = ScanRecord.nextLong();
          day = ScanRecord.nextInt();
          month = ScanRecord.nextInt();
          year = ScanRecord.nextInt();                
          proposalComponent=ScanRecord.nextInt();
          finalOralPresentation=ScanRecord.nextInt();
          finalThesis= ScanRecord.nextInt();
         
          
  ResearchStudent rs = new ResearchStudent(proposalComponent,finalOralPresentation,finalThesis,titleOfStudent,firstName,lastName,studentNumber,day,month,year);
     
             Client.researchArray.add(rs);
          }//end of while loop
     } //end of if
}//end of loading method
    
    //delete method by ID
    public static int deleteResearchStudent(long id){
    int position = -1;
        
        for (int i = 0; i < Client.researchArray.size(); i++) {        
        if(Client.researchArray.get(i).getStudentNumber()==id){
             position = i;
              System.out.println("The STUDENT ID "+id+" "+ Client.researchArray.get(i).getFirstName()+" "+Client.researchArray.get(i).getLastName()+" WAS FOUND");
              
              char confirmation= ' ' ;
              while(confirmation !='Y' && confirmation !='N' ){
              System.out.println("DO YOU CONFIRM THE EXCLUSION? [Y/N]");
               confirmation = input.next().toUpperCase().charAt(0);
              }
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
 
    
    public static void displayAllResearchStudents(){
        System.out.println("All the INFORMATION about RESEARCH STUDENTS:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      for (int i = 0; i < Client.researchArray.size(); i++) {
                System.out.println("STUDENT "+(i+1)+": ");
                System.out.println(Client.researchArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.researchArray.get(i).getFirstName()+" "+
                                                    Client.researchArray.get(i).getLastName()+" "+
                                                    Client.researchArray.get(i).getStudentNumber()+" "+
                                                    Client.researchArray.get(i).getDay()+"/"+
                                                    Client.researchArray.get(i).getMonth()+"/"+
                                                    Client.researchArray.get(i).getYear()+" "+
                                                    "Propoal Component: "+Client.researchArray.get(i).getProposalComponent()+"% "+
                                                    " Final Oral Presentation: "+Client.researchArray.get(i).getFinalOralPresentation()+"% "+
                                                    " Final Thesis: "+Client.researchArray.get(i).getFinalThesis()+"% ");
                
                String situation= Client.researchArray.get(i).finalGrade();
                System.out.println(situation+"\n");
                
          }//end of for loop
    }//end of method 
    
    
    public static void AvarageResearch(){
        int counter =0;
        int overall;
        
        for (int i = 0; i < Client.researchArray.size(); i++) {
            overall=Client.researchArray.get(i).overallMark();
            if (overall>=50) {     
                        counter +=1;
            }   
        }
        System.out.println("The system found FROM RESEARCH STUDENTS "+counter+" STUDEND(S) which had the overall EQUAL TO OR ABOVE THE AVARAGE.");
        counter =0;//cleaning for the next loop
        
            for (int i = 0; i < Client.researchArray.size(); i++) {
            overall=Client.researchArray.get(i).overallMark();
            if (overall<50) {       
                        counter +=1;
            }
           }
        System.out.println("The system found FROM RESEARCH STUDENTS "+counter+" STUDEND(S) which had the overall BELLOW THE AVARAGE.");
    }//end of method
  
    public static int findID(long id ){
        int ret=0;
        for (int i = 0; i < Client.researchArray.size(); i++) {
         if (Client.researchArray.get(i).getStudentNumber()==id) {
             System.out.println("The ID WAS FOUND in Research student.");
             System.out.println("STUDENT INFORMATION");
             System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
             break;
              } else{
             ret=-1;
         }
        }//end of for
        
        
        for (int i = 0; i < Client.researchArray.size(); i++) {
         if (Client.researchArray.get(i).getStudentNumber()==id) {
             System.out.println(Client.researchArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.researchArray.get(i).getFirstName()+" "+
                                                    Client.researchArray.get(i).getLastName()+" "+
                                                    Client.researchArray.get(i).getStudentNumber()+" "+
                                                    Client.researchArray.get(i).getDay()+"/"+
                                                    Client.researchArray.get(i).getMonth()+"/"+
                                                    Client.researchArray.get(i).getYear()+" "+
                                                    "Propoal Component: "+Client.researchArray.get(i).getProposalComponent()+"% "+
                                                    " Final Oral Presentation: "+Client.researchArray.get(i).getFinalOralPresentation()+"% "+
                                                    " Final Thesis: "+Client.researchArray.get(i).getFinalThesis()+"% \n");
         }//end of if

     }//end of for
        return ret;
 }//end of find ID   
    
    
   public static int findByName(String name , String lastName){
       int ret=0;
       
       for (int i = 0; i < Client.researchArray.size(); i++) {
           //to receive the name from the arrray
           String nameinarr =Client.researchArray.get(i).getFirstName();
           if (nameinarr.equalsIgnoreCase(name)) {
                  nameinarr=Client.researchArray.get(i).getLastName();
                   if (nameinarr.equalsIgnoreCase(lastName)) {
                       System.out.println("THE NAME WAS FOUND IN RESEARCH ");
                         System.out.println("STUDENT INFORMATION");
                             System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                       break;
                   }
               }else {
                   ret=-1;
                   }
           }
       
       
        for (int i = 0; i < Client.researchArray.size(); i++) {
           //to receive the name from the arrray
           String nameinarr =Client.researchArray.get(i).getFirstName();
           if (nameinarr.equalsIgnoreCase(name)) {
                  nameinarr=Client.researchArray.get(i).getLastName();
                   if (nameinarr.equalsIgnoreCase(lastName)) {
                     System.out.println(Client.researchArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.researchArray.get(i).getFirstName()+" "+
                                                    Client.researchArray.get(i).getLastName()+" "+
                                                    Client.researchArray.get(i).getStudentNumber()+" "+
                                                    Client.researchArray.get(i).getDay()+"/"+
                                                    Client.researchArray.get(i).getMonth()+"/"+
                                                    Client.researchArray.get(i).getYear()+" "+
                                                    "Propoal Component: "+Client.researchArray.get(i).getProposalComponent()+"% "+
                                                    " Final Oral Presentation: "+Client.researchArray.get(i).getFinalOralPresentation()+"% "+
                                                    " Final Thesis: "+Client.researchArray.get(i).getFinalThesis()+"% ");
                   }
           }
       }
       
       
       
       return ret;
   }//end of findByName
   
   
 public static void sortByID(){
ArrayList<ResearchStudent> temp = new ArrayList();
  
    for (int i = 0; i < Client.researchArray.size(); i++) {
        
        for (int j = Client.researchArray.size()- 1; j > i; j--) {
       
                if (Client.researchArray.get(i).getStudentNumber()> Client.researchArray.get(j).getStudentNumber()) {
                    temp.add(0, Client.researchArray.get(i));
                    Client.researchArray.set(i,Client.researchArray.get(j));
                    Client.researchArray.set(j,temp.get(0));
                }
        }
     
     }
     System.out.println("The sorted Array by ID is: ");
         for (int i = 0; i < Client.researchArray.size(); i++) {
             System.out.println(   "ID: " +Client.researchArray.get(i).getStudentNumber()+" Name: "+
                                                    Client.researchArray.get(i).getTitleOfStudent()+" "+ 
                                                    Client.researchArray.get(i).getFirstName()+" "+
                                                    Client.researchArray.get(i).getLastName()+" "+
                                                    Client.researchArray.get(i).getDay()+"/"+
                                                    Client.researchArray.get(i).getMonth()+"/"+
                                                    Client.researchArray.get(i).getYear()+" "+
                                                    "Propoal Component: "+Client.researchArray.get(i).getProposalComponent()+"% "+
                                                    " Final Oral Presentation: "+Client.researchArray.get(i).getFinalOralPresentation()+"% "+
                                                    " Final Thesis: "+Client.researchArray.get(i).getFinalThesis()+"% ");
         }//end of if
     
     
 }//end of method
 
 
public static void toCsv(){
 String fileName ="research.csv"; 
                  
            PrintWriter outputStream = null;
            try{
                outputStream = new PrintWriter(fileName); /* Give the name of the file as .csv format */
            }
            catch(FileNotFoundException e){ /* Error message when there is a problem opening the files */
                System.out.println("Error opening the file"+fileName);
                System.exit(0);
            }
              for(int i=0;i<Client.researchArray.size();i++){
            outputStream.println(researchArray.get(i).getTitleOfStudent()+","+ 
                                                    Client.researchArray.get(i).getFirstName()+","+
                                                    Client.researchArray.get(i).getLastName()+","+
                                                    Client.researchArray.get(i).getStudentNumber()+", "+
                                                    Client.researchArray.get(i).getDay()+"/"+
                                                    Client.researchArray.get(i).getMonth()+"/"+
                                                    Client.researchArray.get(i).getYear()+","+
                                                    Client.researchArray.get(i).getProposalComponent()+","+
                                                    Client.researchArray.get(i).getFinalOralPresentation()+","+
                                                    Client.researchArray.get(i).getFinalThesis()); /* Write the information into files */
          
              }
            outputStream.close(); /* Close the files */
          

}
 
 
 
 
}//end of class