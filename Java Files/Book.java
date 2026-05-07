public class Book extends LibraryItem{
    private String author;
    private String isbn;

    public Book(String code, String title, int yearPublished, String author, String isbn){
        super(code, title, yearPublished);
        setAuthor(author);
        setIsbn(isbn);
    }

    public void setAuthor(String author){
        if(!author.isEmpty()){
            this.author = author;
        } else {
            System.out.println("Ο συγγραφέας δεν μπορεί να είναι κενός");
        }
    }

    public void setIsbn(String isbn){
        if(!isbn.isEmpty()){
            this.isbn = isbn;
        } else {
            System.out.println("Το ISBN δεν μπορεί να είναι κενό");
        }
    }

    public String getIsbn(){return isbn;}
    public String getAuthor(){return author;}

    @Override
    public String getDescription(){
        return "Βιβλίο: " + getTitle() + " | Συγγραφέας: " + getAuthor() + " | ISBN: " + getIsbn();
    }
}
