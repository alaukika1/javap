public class Teacher{
    private String teacherName;
    private int teacherId;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;

    public Teacher(String teacherName, int teacherId, String address, String workingType, String employmentStatus){
        //initializing attributes with parameter values
        this.teacherName = teacherName;
        this.teacherId = teacherId;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }
    
    //accessor method for all attributes

    public String getTeacherName(){
        return this.teacherName;
    }

    public int getTeacherId(){
        return this.teacherId;
    }

    public String getAddress(){
        return this.address;
    }

    public String getWorkingType(){
        return this.workingType;
    }

    public String getEmploymentStatus(){
        return this.employmentStatus;
    }
    
    public int getWorkingHours(){
        return this.workingHours;
    }
    
    
    
    //setter method to set new working hour
    
    public void setWorkingHours(int newWorkingHours){
        
        this.workingHours=newWorkingHours;

    }
    //method to display 
    public void display(){
        System.out.println("Teacher ID: " + getTeacherId());
        System.out.println("Teacher Name: " + getTeacherName());
        System.out.println("Teacher Address: " + getAddress());
        System.out.println("Teacher Working Type: " + getWorkingType());
        System.out.println("Teacher Employment Status: " + getEmploymentStatus());
       
        
         if(workingHours==0){
            System.out.println("Working Hours : Not assigned");
        }
        else{
            System.out.println("Working Hours :" + getWorkingHours());
        }
         
        
        
        

        
    }
}
