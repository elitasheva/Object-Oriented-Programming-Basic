package problem6.models;

public abstract class Animal {

    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {

        if (!gender.toLowerCase().equals("female") && !gender.toLowerCase().equals("male")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public abstract String produceSound();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(System.lineSeparator());
        sb.append(String.format("%s %d %s",this.name,this.age,this.gender));
        return sb.toString();
    }
}
