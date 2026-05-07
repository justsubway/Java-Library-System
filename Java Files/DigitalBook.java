public class DigitalBook extends LibraryItem{
    private int fileSize;
    private String fileType;

    public DigitalBook(String code, String title, int yearPublished, int fileSize, String fileType){
        super(code, title, yearPublished);
        setFileSize(fileSize);
        setFileType(fileType);
    }

    public void setFileSize(int fileSize){
        if(fileSize > 0){
            this.fileSize = fileSize;
        } else {
            System.out.println("Το μέγεθος του αρχείου δεν μπορεί να είναι κενό");
        }
    }

    public void setFileType(String fileType){
        if(!fileType.isEmpty()){
            this.fileType = fileType;
        } else {
            System.out.println("Το είδος του αρχείου δεν μπορεί να είναι κενό");
        }
    }

    public int getFileSize(){return fileSize;}
    public String getFileType(){return fileType;}

    @Override
    public String getDescription(){
        return "Digital Book: " + getTitle() + " | Μέγεθος Αρχείου: " + getFileSize() + " | Είδος Αρχείου: " + getFileType();
    }
}
