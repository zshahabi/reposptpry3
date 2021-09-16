package ir.maktab;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Library library = new Library();
        Main main = new Main();//Challenge for define non-static method
        boolean canContinue = true;


        do {
            System.out.println("Enter your operation: 1-addBook or 2-addMember 3-" +
                    "getBook  4-returnBook 5-displayMember  6-displayBook  7-exit");
            int inputCase = main.choiceInput();

            switch (inputCase) {
                case 1://add book
                    System.out.println("Enter bookName and your  count: add commit");
                    String nameBook = input.next();
                    int count = input.nextInt();
                    library.addBook(nameBook, count);
                    System.out.println("added your book to list:");
                    break;
                case 2://add member
                    System.out.println("Enter member information name,family,birthDate");
                    String nameMember = input.next();
                    String family = input.next();
                    String birthDate = input.next();
                    library.addMember(nameMember, family, birthDate);
                    System.out.println("your member added");
                    break;

                case 3:
                    System.out.println("Enter information for get ,idOfMember,idOfBook");
                    int idOfMember = input.nextInt();
                    int idOfBook = input.nextInt();
                    library.get(idOfMember, idOfBook);
                    System.out.println("get book done");
                    break;

                case 4:
                    System.out.println("ENTER INFORMATION FOR RETURN ,idOfMember,idOfBook");
                    System.out.println("git");
                    int idOfMembers = input.nextInt();
                    int idOfBooks = input.nextInt();
                    library.returnBook(idOfMembers, idOfBooks);
                    System.out.println("returnBook done");
                    break;

                case 5:
                    System.out.println("list for member");
                    System.out.println(library.displayMember());
                    System.out.println("display member done");
                    break;

                case 6:
                    System.out.println("list for books");
                    System.out.println(library.displayBook());
                    System.out.println("display book done");
                    break;

                case 7:
                    canContinue = false;
                    System.out.println("you exit ");
                    break;

                default:
                    System.out.println("you enter not eny operation");
                    break;

            }


        }
        while (canContinue);

    }

    public int choiceInput() {//Challenge for define non-static method
        Scanner input = new Scanner(System.in);
        String inputCase = input.next();
        boolean choice = inputCase.matches("[1-7]*");
        while (choice == false) {
            System.out.println("You must enter digit:");
            inputCase = input.next();
            choice = inputCase.matches("[1-7]*");
        }
        int choiceInt = Integer.parseInt(inputCase);
        return choiceInt;

    }
}


