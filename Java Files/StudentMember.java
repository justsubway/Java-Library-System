public class StudentMember extends Member {
    private String AM;
    private String Department;

    public static final int MAX_STUDENT_LOANS = 6;

    // Constructor
    public StudentMember(String id, String name, String email, String AM, String Department){
        super(id, name, email);
        setAM(AM);
        setDepartment(Department);
        this.maxLoanNumber = MAX_STUDENT_LOANS;
    }

    // Setters
    public void setAM(String AM){
        if(!AM.isEmpty()){
            this.AM = AM;
        } else {
            System.out.println("Ο αριθμός μητρώου δεν μπορεί να είναι κενός");
        }
    }
    public void setDepartment(String Department){
        if(!Department.isEmpty()){
            this.Department = Department;
        } else {
            System.out.println("Το τμήμα του φοιτητή δεν μπορεί να είναι κενό");
        }
    }

    @Override
    public String getDescription(){
        return "Φοιτητής: " + getName() + " | Μητρώο: " + getAM() + " | Τμήμα: " + getDepartment();
    }
    // Getters
    public String getAM(){ return AM;}
    public String getDepartment(){ return Department;}
}
