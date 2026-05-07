import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("=== University Library ===");
            System.out.println("1. Προσθήκη υλικού βιβλιοθήκης");
            System.out.println("2. Προσθήκη μέλους");
            System.out.println("3. Αναζήτηση υλικού βιβλιοθήκης");
            System.out.println("4. Δανεισμός υλικού βιβλιοθήκης");
            System.out.println("5. Επιστροφή υλικού βιβλιοθήκης");
            System.out.println("6. Εμφάνιση ενεργών δανεισμών");
            System.out.println("7. Στατιστικά βιβλιοθήκης");
            System.out.println("0. Έξοδος");
            System.out.println("Επιλογή: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Τι θέλετε να προσθέσετε; (1: Βιβλίο, 2: Περιοδικό, 3: Digital Book): ");
                    int itemType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Κωδικός: ");
                    String code = scanner.nextLine();
                    System.out.print("Τίτλος: ");
                    String title = scanner.nextLine();
                    System.out.print("Έτος Έκδοσης: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    if (itemType == 1) {
                        System.out.print("Συγγραφέας: ");
                        String author = scanner.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        myLibrary.addItem(new Book(code, title, year, author, isbn));
                        System.out.println("Το βιβλίο προστέθηκε!");
                    }
                    else if (itemType == 2) {
                        System.out.print("Αριθμός Τεύχους: ");
                        String copyNum = scanner.nextLine();
                        myLibrary.addItem(new Magazine(code, title, year, copyNum));
                        System.out.println("Το περιοδικό προστέθηκε!");
                    }
                    else if (itemType == 3) {
                        System.out.print("Μέγεθος Αρχείου: ");
                        int size = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Τύπος Αρχείου: ");
                        String type = scanner.nextLine();
                        myLibrary.addItem(new DigitalBook(code, title, year, size, type));
                        System.out.println("Το Digital Book προστέθηκε!");
                    }
                    break;
                case 2:
                    System.out.println("Τι είδους μέλος θέλεις να προσθέσεις; (1 για Φοιτητή, 2 για Καθηγητή): ");
                    int memberType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Δώσε το id: ");
                    String id = scanner.nextLine();
                    System.out.println("Δώσε το όνομα: ");
                    String name = scanner.nextLine();
                    System.out.println("Δώσε το email: ");
                    String email = scanner.nextLine();

                    if (memberType == 1) {
                        System.out.print("Δώσε AM: ");
                        String am = scanner.nextLine();
                        System.out.print("Δώσε Τμήμα: ");
                        String department = scanner.nextLine();
                        StudentMember newStudent = new StudentMember(id, name, email, am, department);
                        myLibrary.addMember(newStudent);
                        System.out.println("Ο μαθητής προστέθηκε!");

                    } else if (memberType == 2) {
                        System.out.print("Δώσε Ειδικότητα: ");
                        String specialty = scanner.nextLine();
                        System.out.print("Δώσε Τμήμα: ");
                        String department = scanner.nextLine();
                        ProfessorMember newProf = new ProfessorMember(id, name, email, specialty, department);
                        myLibrary.addMember(newProf);
                        System.out.println("Ο καθηγητής προστέθηκε!");

                    } else {
                        System.out.println("Λάθος επιλογή τύπου μέλους.");
                    }
                    break;
                case 3:
                    System.out.print("Δώσε τον κωδικό του αντικειμένου: ");
                    String searchCode = scanner.nextLine();
                    LibraryItem foundItem = myLibrary.findItemByCode(searchCode);
                    if (foundItem != null) {
                        System.out.println(foundItem.getDescription());
                    } else {
                        System.out.println("Το αντικείμενο δεν βρέθηκε");
                    }
                    break;
                case 4:
                    System.out.println("Δώσε το id του μέλους: ");
                    String memberId = scanner.nextLine();
                    System.out.println("Δώσε τον κωδικό του βιβλίου: ");
                    String bookCode = scanner.nextLine();
                    myLibrary.borrowItem(memberId, bookCode);
                    break;
                case 5:
                    System.out.println("Δώσε το id του βιβλίου: ");
                    String bookId = scanner.nextLine();
                    myLibrary.returnItem(bookId);
                    break;
                case 6:
                    myLibrary.printActiveLoans();
                    break;
                case 7:
                    myLibrary.printStatistics();
                    break;
                case 0:
                    running = false;
                    System.out.println("Έξοδος από το σύστημα");
                    break;
            }
        }
    }
}