import exception.IncorrectMoneyException;

public class StudentTuition {

    private int tuitionBalance;

    public StudentTuition() {
        tuitionBalance = 0;
    }

    public int getTuitionBalance() {
        return tuitionBalance;
    }

    public void payTuition(int i) {
        tuitionBalance -= i;
    }


    //debit balance
    public void debitMoney(int i) throws IncorrectMoneyException {
        if (i <= 0) {
            throw new IncorrectMoneyException("Please insert the correct number.");
        }
        tuitionBalance += i;
    }


}
