public class Magazine extends LibraryItem{
    private String copyNumber;

    public Magazine(String code, String title, int yearPublished, String copyNumber){
        super(code, title, yearPublished);
        setCopyNumber(copyNumber);
    }

    public void setCopyNumber(String copyNumber){
        if(!copyNumber.isEmpty()){
            this.copyNumber = copyNumber;
        } else {
            System.out.println("Ο αριθμός τεύχους δεν μπορεί να είναι κενός");
        }
    }

    public String getCopyNumber(){return copyNumber;}

    @Override
    public String getDescription(){
        return "Περιοδικό: " + getTitle() +  " | Αριθμός Τεύχους: " + getCopyNumber();
    }
}
