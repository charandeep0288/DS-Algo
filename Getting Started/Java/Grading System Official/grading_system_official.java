import java.util.*;
  public class grading_system_official{
  
  public static Scanner scn = new Scanner(System.in);
  
  public static void gradingSystem( int marks )
  {
      
      if(marks > 90)
      {
          System.out.println("excellent");
      }
      else if( marks > 80 )
      {
          System.out.println("good");
      }
      else if( marks > 70 )
      {
          System.out.println("fair");
      }
      else if( marks > 60 )
      {
          System.out.println("meets expectations");
      }
      else 
      {
          System.out.println("below par");
      }
  }
  
  public static void main(String[] args) {
      // input - don't change this code
      int marks = scn.nextInt();
      
      // input - don't change this code
      
      // code here      
      gradingSystem(marks);
  
   }
  }

  // javac grading_system_official.java && java grading_system_official