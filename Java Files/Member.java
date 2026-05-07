public abstract class Member {
    private String id;
    private String name;
    private String email;
    protected int maxLoanNumber;

    // Constructor
    public Member(String id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }

    // Setters
    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Το ID δεν μπορεί να είναι κενό.");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Το email πρέπει να περιέχει το σύμβολο '@'.");
        }
    }

    public void setName(String name) {this.name = name;}
    public void setMaxLoanNumber(int maxLoanNumber) {this.maxLoanNumber = maxLoanNumber;}

    // Getters
    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public int getMaxLoanNumber() { return this.maxLoanNumber; }

    public abstract String getDescription();
}