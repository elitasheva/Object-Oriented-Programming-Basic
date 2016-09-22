package problem3.models;

public class Worker extends Human {

    private final double MIN_WEEK_SALARY = 10;
    private final int MIN_WORK_HOURS = 1;
    private final int MAX_WORK_HOURS = 12;
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Week Salary: %.2f", this.weekSalary));
        sb.append(System.lineSeparator());
        sb.append(String.format("Hours per day: %.2f", this.workHoursPerDay));
        sb.append(System.lineSeparator());
        sb.append(String.format("Salary per hour: %.2f", this.calculateSalaryPerHour()));

        return sb.toString();
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < MIN_WEEK_SALARY){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < MIN_WORK_HOURS || workHoursPerDay > MAX_WORK_HOURS){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double calculateSalaryPerHour(){
        return this.weekSalary / (this.workHoursPerDay * 7.0);
    }
}
