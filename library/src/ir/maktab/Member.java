package ir.maktab;

public class Member {
    private int memberId;
    private String name;
    private String family;
    private String birthYear;
    private Book[] booksForMember=new  Book[0];

    public Member(int memberId, String name, String family, String birthYear) {
        this.memberId = memberId;
        this.name = name;
        this.family = family;
        this.birthYear = birthYear;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public Book[] getBooksForMember() {
        return booksForMember;
    }

    public void setBooksForMember(Book[] booksForMember) {
        this.booksForMember = booksForMember;
    }

    @Override
    public String toString() {
        return "Member[" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ']';
    }
}
