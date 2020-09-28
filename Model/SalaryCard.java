package Model;

public class SalaryCard {
    private int salary;
    private int tax;

    /**
     * This generates a salary card
     * @param s the salary value of the card
     * @param t the tax value of the card
     */
    public SalaryCard (int s, int t) {
        this.salary = s;
        this.tax = t;                                                      
    }

    /**
     * This gets the salary value of the card
     * @return the salary value of the card
     */
    public int getSalary() {
        return salary;
    }

    /**
     * This gets the tax value of the card
     * @return the tax value of the card
     */
    public int getTax() {
        return tax;
    }

    /**
     * This sets the salary value of the card
     * @param salary the new salary value to be assigned to the card
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * This sets the tax value of the card
     * @param tax the new tax value to be assigned to the card
     */
    public void setTax(int tax) {
        this.tax = tax;
    }

    /**
     * Computes the total salary value of the card
     * @return the final value of the card
     */
    public int computeSalary() {
        return (this.salary - this.tax);
    }

    /**
     * Formats the salary card
     * @return the formatted string of the salary card
     */
    @Override
    public String toString() {
        return salary + " [Tax: " + tax + "]";
    }
}