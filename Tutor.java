public class Tutor extends Teacher{
    //attributes of tutor
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;
    
    //constructor of class tutor
    public Tutor( int teacherId, String teacherName, String address, String workingType, String employmentStatus, int workingHours, double salary, String specialization,
                        String academicQualification,int performanceIndex ){
                            
     //calling superclass constructor with 5 parameters
     super(teacherName, teacherId, address, workingType, employmentStatus);
     
     super.setWorkingHours(workingHours); // calling setter method in superclass
     
     //setting attributes of tutor with parameter values
      this.salary = salary;
      this.specialization = specialization;
      this.academicQualification = academicQualification;
      this.performanceIndex = performanceIndex;
      this.isCertified = false; //initialized to false
        
    }
    //accessor method for each attributes of tutor
    
    public double getSalary(){
        return this.salary;
    }
    
    public String getSpecialization(){
        return this.specialization;
    }
    
     public String getAcademicQualification(){
       return this.academicQualification;
    }
    
     public int getPerformanceIndex(){
        return this.performanceIndex;
    }
    
     public boolean getIsCertified(){
        return this.isCertified;
    }
    
    // setter method to set the salary
    
    public void setSalary(double Salary, int newPerformanceIndex){
        
        if(isCertified && newPerformanceIndex > 5 && super.getWorkingHours()>20){
            double appraisal=0;
            if(performanceIndex >= 5 && newPerformanceIndex <= 7){
                appraisal=0.05;
            }
            else if(newPerformanceIndex >= 8 && newPerformanceIndex <= 9){
                appraisal = 0.1;
            }
            else if(newPerformanceIndex >= 10){
                appraisal = 0.2;
            }
            double salaryIncrease = appraisal * salary;
            this.salary = salary + salaryIncrease;
            this.isCertified = true;
            System.out.println("Salary approved");
        }
        else{
            System.out.println("Unable to approve salary");
        }
        }
        //new method to remove tutor
    public void removeTutor(){
        if(isCertified){
            this.salary = 0;
            this.specialization = "";
            this.academicQualification = "";
            this.performanceIndex= 0;
            this.isCertified = false;
            
            System.out.println("The tutor is removed");
        }
            else{
                System.out.println("The tutor is not removed");
                
            }
            
        }
        
     public void display(){
         if(this.isCertified==false){
             super.display();
             
            }else{
                super.display();
                System.out.println("The salary of the tutor is:"+ " "+getSalary());
                System.out.println("The specialization of the tutor is:"+ " "+getSpecialization());
                System.out.println("The academic qualification of the tutor is:"+ " "+getAcademicQualification());
                System.out.println("The performance index of the tutor is:"+ " "+getPerformanceIndex());
                
            }
            
        
        }
            
        }
        
        
        
    
    
    
     
    
    
