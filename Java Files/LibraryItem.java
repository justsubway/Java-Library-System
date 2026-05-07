public abstract class LibraryItem implements Borrowable{
    private String code;
    private String title;
    private int yearPublished;
    protected boolean isAvailable;

    //Constructor
    public LibraryItem(String code, String title, int yearPublished){
        setCode(code);
        setTitle(title);
        setYearPublished(yearPublished);
        setIsAvailable(true);
    }

    boolean isValidCode(String code) {
        return code != null && !code.isEmpty();
    }

    // Setters
    public void setCode(String code){
        if(isValidCode(code)){
            this.code = code;
        } else {
            System.out.println("Ο κωδικός δεν μπορεί να είναι κενός");
        }
    }

    public void setTitle(String title){
        if(!title.isEmpty()){
            this.title = title;
        } else {
            System.out.println("Ο τίτλος δεν μπορεί να είναι κενός");
        }
    }

    public void setYearPublished(int yearPublished){
        if(yearPublished >=0 && yearPublished<=2026){
        this.yearPublished = yearPublished;} else {
            System.out.println("Λάθος έτος!");
        }
    }

    public void setIsAvailable(boolean isAvailable){ this.isAvailable = isAvailable;}

    // Getters
    public String getCode(){return code;}
    public String getTitle(){return title;}
    public int getYearPublished(){return yearPublished;}
    public boolean isAvailable(){return isAvailable;}
    public abstract String getDescription();

    @Override
    public boolean returnItem(){
        this.isAvailable = true;
        return true;
    }
    @Override
    public boolean borrowTo(Member member){
        if(this.isAvailable){
            this.isAvailable = false;
            return true;
        }
        return false;
    }
}
