import java.util.List;

public final class ReportGenerator {
    public static void printAllItems(List<LibraryItem> items){
        for(LibraryItem item : items){
            System.out.println(item.getDescription());
        }
    }

    public static void printActiveLoans(List<Loan> loans){
        for(Loan loan : loans){
            if(loan.getReturnDate() == null){
               System.out.println("Το μέλος " + loan.getMember().getName() + " έχει δανειστεί το " + loan.getItem().getTitle());
            }
        }
    }
}
