import java.util.ArrayList;
import java.util.List;

public class Library implements Searchable{
    private List<LibraryItem> items;
    private List<Member> members;
    private List<Loan> loans;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void addItem(LibraryItem item){items.add(item);}

    public void addMember(Member member){members.add(member);}

    public LibraryItem findItemByCode(String code){
        for (LibraryItem item : items) {
            if(item.getCode().equals(code)){
                return item;
            }
        }
        return null;
    }

    public Member findMemberById(String id){
        for (Member member : members){
            if(member.getId().equals(id)){
                return member;
            }
        }
        return null;
    }

    public void borrowItem(String memberId, String itemCode){
        Member member = findMemberById(memberId);
        LibraryItem item = findItemByCode(itemCode);

        if(item == null || member == null){
            System.out.println("Κάτι πήγε λάθος προσπάθησε ξανά");
            return;
        }

        boolean success = item.borrowTo(member);

        if(success){
            Loan newLoan = new Loan(item, member);
            loans.add(newLoan);
            System.out.println("Το υλικό δανείστηκε");
        } else {
            System.out.println("Το υλικό είναι ήδη δανεισμένο.");
        }
    }

    public void returnItem(String itemCode) {
        LibraryItem item = findItemByCode(itemCode);

        if (item == null) {
            System.out.println("Κάτι πήγε λάθος προσπάθησε ξανά");
            return;
        }

        item.returnItem();

        for (Loan loan : loans) {
            if (loan.getItem().getCode().equals(itemCode) && loan.getReturnDate() == null) {
                loan.returnItem();
                System.out.println("Η επιστροφή ολοκληρώθηκε με επιτυχία!");
                break;
            }
        }
    }

    public void printAllItems() {
        ReportGenerator.printAllItems(this.items);
    }

    public void printActiveLoans() {
        ReportGenerator.printActiveLoans(this.loans);
    }

    public void printStatistics(){
        int activeLoans = 0;
        for(Loan loan : loans){
            if(loan.getReturnDate() == null){
                activeLoans ++;
            }
        }

        System.out.println("Συνολικό Υλικό: " + items.size());
        System.out.println("Συνολικά άτομα: "+ members.size());
        System.out.println("Συνολικοί Δανεισμοί:" + activeLoans);
    }
}
