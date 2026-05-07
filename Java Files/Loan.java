import java.time.LocalDate;

public class Loan {
    private Member member;
    private LibraryItem item;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(LibraryItem item, Member member){
        this.member = member;
        this.item = item;
        this.loanDate = LocalDate.now();
        this.returnDate = null;
    }

    public void returnItem() {
        this.returnDate = LocalDate.now();
    }

    // Getters
    public Member getMember(){ return member; }
    public LibraryItem getItem(){ return item; }
    public LocalDate getLoanDate(){ return loanDate; }
    public LocalDate getReturnDate(){ return returnDate; }
}