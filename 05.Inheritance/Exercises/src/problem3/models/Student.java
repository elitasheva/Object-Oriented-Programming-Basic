package problem3.models;

public class Student extends Human{

    private final int MIN_LENGTH_FACULTY_NUMBER = 5;
    private final int MAX_LENGTH_FACULTY_NUMBER = 10;
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Faculty number: %s", this.facultyNumber));

        return sb.toString();
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < MIN_LENGTH_FACULTY_NUMBER ||
                facultyNumber.length() > MAX_LENGTH_FACULTY_NUMBER || !isValid(facultyNumber)){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    private boolean isValid(String facultyNumber){
        boolean isValid = true;
        for (int i = 0; i < facultyNumber.length(); i++) {

            if (!Character.isDigit(facultyNumber.charAt(i)) && !Character.isLetter(facultyNumber.charAt(i))){
                isValid = false;
                break;
            }

        }
        return isValid;
    }

}
