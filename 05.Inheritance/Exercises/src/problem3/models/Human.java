package problem3.models;

public abstract class Human {

    private final int MIN_LENGTH_FIRSTNAME = 4;
    private final int MIN_LENGTH_LASTNAME = 3;
    private String firstName;
    private String lastName;

    protected Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s", this.firstName));
        sb.append(System.lineSeparator());
        sb.append(String.format("Last Name: %s", this.lastName));

        return sb.toString();
    }

    protected void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < MIN_LENGTH_FIRSTNAME) {
            throw new IllegalArgumentException(String.format("Expected length at least %d symbols!Argument: firstName", MIN_LENGTH_FIRSTNAME));
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter! Argument: lastName");
        }
        if (lastName.length() < MIN_LENGTH_LASTNAME) {
            throw new IllegalArgumentException(String.format("Expected length at least %d symbols!Argument: lastName", MIN_LENGTH_LASTNAME));
        }
        this.lastName = lastName;
    }

}
