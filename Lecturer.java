public class Lecturer extends Teacher{
    
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    
    //constructor
    public Lecturer(int teacherId, String teacherName, String address, String workingType, String employmentStatus, String department,int yearsOfExperience,int workingHours){
                               
     //calling superclass constructor with 5 parameters
     super(teacherName, teacherId, address, workingType, employmentStatus );
     
     super.setWorkingHours(workingHours); // calling setter method in superclass
     
        
        this.department = department;
        this.yearsOfExperience= yearsOfExperience;
        this.gradedScore = 0; // initialized to zero
        this.hasGraded = false;  //initialized to false
        
        
    }
    
    
    
    // accessor method for all
    public String getDepartment(){
        return this.department;
    }
    
    public int getYearsOfExperience(){
        return this.yearsOfExperience;
    }
    
    public int getGradedScore(){
        return this.gradedScore;
    }
    
    public boolean getHasGraded(){
        return this.hasGraded;
        
    }
    
    
    //mutator method for attribute gradedScore
    public void setGradedScore(int gradedScore){
        this.gradedScore = gradedScore;
    }
    
    // method to grade assignments
    public void gradeAssignment(int gradedScore, String department, int yearsOfExperience){
        if(yearsOfExperience >= 5 && this.department == department){
            if(gradedScore >= 70){
                this.gradedScore = gradedScore;
                System.out.println("Assignments Graded : A");
            }
            else if(gradedScore >= 60){
                this.gradedScore = gradedScore;
                System.out.println("Assignments Graded : B");
            }
            else if(gradedScore >= 50){
                this.gradedScore = gradedScore;
                System.out.println("Assignments Graded : C");
            }
            else if(gradedScore >= 40){
                this.gradedScore = gradedScore;
                System.out.println("Assignments Graded : D");
            }
            else if(gradedScore<40){
                this.gradedScore = gradedScore;
                System.out.println("Assignments Graded : E");
                
            }
            //attribute has graded is set true
            this.hasGraded = true;
        
        }
            
            else{  
                System.out.println("Cannot grade assignments");
                
        
        }
        
            
        }
        // method to display the details of lecturer
        public void display(){
            //calling superclass display method
            super.display();
            
              //displaying attributes of lecturer
               System.out.println("Department :" + getDepartment());
               System.out.println("Years Of Experience :" + getYearsOfExperience());
               
               if(this.hasGraded==true){
                   System.out.println("Graded Score : " + getGradedScore());
                   
                }
                else{
                    System.out.println("Graded Score : Not available");
                }
            
    
        
         }
        }
         
       
       
     









