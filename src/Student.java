public class Student {
    private int id;
    private String name;
    private int marks1;
    private int marks2;
    private int marks3;

    public Student(int id, String name, int marks1, int marks2, int marks3) {
        this.id = id;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return marks1 + marks2 + marks3;
    }

    public double getPercentage() {
        return getTotal() / 3.0;
    }

    public String getGrade() {
        double percentage = getPercentage();
        if (percentage >= 85) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 50) return "C";
        else return "Fail";
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Total: " + getTotal() +
                ", Percentage: " + String.format("%.2f", getPercentage()) +
                "%, Grade: " + getGrade();
    }
}
