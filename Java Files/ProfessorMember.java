public class ProfessorMember extends Member {
    private String Specialty;
    private String Department;

    // Constructor
    public ProfessorMember(String id, String name, String email, String Specialty, String Department){
        super(id, name, email);
        setSpecialty(Specialty);
        setDepartment(Department);
        this.maxLoanNumber = 15;
    }

    // Setters
    public void setSpecialty(String Specialty){
        if(!Specialty.isEmpty()){
            this.Specialty = Specialty;
        } else {
            System.out.println("Η ειδικότητα δεν μπορεί να είναι κενή");
        }
    }
    public void setDepartment(String Department){
        if(!Department.isEmpty()){
            this.Department = Department;
        } else {
            System.out.println("Το τμήμα του καθηγητή δεν μπορεί να είναι κενό");
        }
    }

    @Override
    public String getDescription(){
        return "Καθηγητής: " + getName() + " | Ειδικότητα: " + getSpecialty() + " | Τμήμα: " + getDepartment();
    }
    // Getters
    public String getSpecialty(){ return Specialty;}
    public String getDepartment(){ return Department;}
}
