package Hcl_Assessment2_Corejava_2300320130201;

public abstract class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be positive");
        }
        this.issueNumber = issueNumber;
    }

    @Override
    public double lateFee(int daysLate) {
        return daysLate <= 0 ? 0.0 : daysLate * 1.0;
    }

    public int getIssueNumber() { return issueNumber; }

    @Override
    public String toString() {
        return "Magazine[" + super.toString() + ", Issue #" + issueNumber + "]";
    }
}