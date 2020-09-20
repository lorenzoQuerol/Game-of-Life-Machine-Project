public class SalaryCard {
    private int salary;
    private int tax;

    public SalaryCard (int s, int t) {
        this.salary = s;
        this.tax = t;                                                      
    }

    public int getSalary() {
        return salary;
    }
    
    public int getTax() {
        return tax;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setTax(int tax) {
        this.tax = tax;
    }

    public int computeSalary (int salary, int tax) {
        return (salary-tax);
    }

    @Override
    public String toString() {
        return "Salary: " + salary + "\n" + 
               "Tax: " + tax + "\n";
    }
}