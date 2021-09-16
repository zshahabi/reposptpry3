package ir.maktab;

import java.util.Arrays;

public class Library {
    private Member[] members = new Member[0];
    private Book[] books = new Book[0];
    //An array that is parallel to the book array and holds the number of each book. Length equal to the book list array
    private int[] countBooksCurrent = new int[0];

    private int bookId = 1000;
    private int memberId = 20;

    public String displayBook() {

        String bookState = "";
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            bookState += book.toString() + "count of book" + "[" + countBooksCurrent[i] + "]";

        }
        return bookState;

    }

    public String displayMember() {
        String memberState = "";
        for (Member member : members) {
            String bookStateMember = "";
            for (int i = 0; i < member.getBooksForMember().length; i++) {
                Book book = books[i];
                bookStateMember += book.toString();
            }

            memberState += member.toString() + "book stateMember is:"+"[" + bookStateMember + "]" + "\n";

        }
        return memberState;
    }

    public void addBook(String name, int count) {
        books = Arrays.copyOf(books, books.length + 1);
        countBooksCurrent = Arrays.copyOf(countBooksCurrent, countBooksCurrent.length + 1);

        Book book = new Book(bookId, name);
        bookId++;

        books[books.length - 1] = book;
        countBooksCurrent[countBooksCurrent.length - 1] = count;

    }

    public void addMember(String name, String family, String birthDate) {
        members = Arrays.copyOf(members, members.length + 1);

        Member member = new Member(memberId, name, family, birthDate);
        memberId++;

        members[members.length - 1] = member;
    }

    //Borrow one Book to User
    public void get(int memberId, int bookId) {
        Book book = null;
        int indexOfMember = 0;
        int indexOfBook = 0;
        int indexOfBookCount = 0;

        //find member and memberIndex for ger book
        for (int i = 0; i < members.length; i++) {
            if (members[i].getMemberId() == memberId) {
                indexOfMember = i;
                break;
            }
        }
        //find book for borrow to member
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookId() == bookId) {
                book = books[i];
                indexOfBook = i;
                indexOfBookCount = i;
                break;
            }
        }

        Book[] listBook = members[indexOfMember].getBooksForMember();//list books that have member now
        listBook = Arrays.copyOf(listBook, listBook.length + 1);
        listBook[listBook.length - 1] = book;
        if (listBook.length >= 5) {
            System.out.println("MaxReached :" + members[indexOfMember].getMemberId() + "," + members[indexOfMember].getName());
            return;
        }
        if (countBooksCurrent[indexOfBookCount] < 1) {
            System.out.println("NotAvailable :" + books[indexOfBook].getBookId() + "," + books[indexOfBook].getName());
            return;
        }

        members[indexOfMember].setBooksForMember(listBook);
        countBooksCurrent[indexOfBookCount] = countBooksCurrent[indexOfBookCount] - 1;


    }

    public void returnBook(int memberId, int bookId) {
        Book book = null;
        int indexOfMember = 0;
        int indexOfBook = 0;
        int indexOfBookCount = 0;

        //find member and memberIndex for return book
        for (int i = 0; i < members.length; i++) {
            if (members[i].getMemberId() == memberId) {
                indexOfMember = i;
                break;
            }
        }
        //find book for return book
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookId() == bookId) {
                book = books[i];
                indexOfBook = i;
                indexOfBookCount = i;
                break;
            }
        }

        Book[] listBook = members[indexOfMember].getBooksForMember();
        Book[] newListBook = new Book[listBook.length - 1];
        int counterNewListBook = 0;
        for (int i = 0; i < listBook.length; i++) {
            if (indexOfBook != i) {
                newListBook[counterNewListBook++] = listBook[i];

            }
        }
        members[indexOfMember].setBooksForMember(newListBook);
        countBooksCurrent[indexOfBookCount] = countBooksCurrent[indexOfBookCount] + 1;


    }

//    @Override
//    public String toString() {
//        return "[" +
//                "countBooksCurrent=" + Arrays.toString(countBooksCurrent) +
//                ']';
//    }
}
