package lab5;

public class Student extends Person {
    private int StudentID;
    private String department;
    private double gpa;

    public Student(int studentID, String name, int age, String gender, String department, double gpa) {
        super(name, age, gender);
        this.StudentID = studentID;
        this.department = department;
        this.gpa = gpa;
    }

    public double getGpa() {return gpa;}
    public void setGpa(double gpa) {this.gpa = gpa;}

    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}

    public int getStudentID() {return StudentID;}
    public void setStudentID(int studentID) {StudentID = studentID;}

    @Override
    public String toString(){
          return "ID: " + StudentID + ", Name: " + getName() + ", Age: " + getAge() +
                ", Gender: " + getGender() + ", Dept: " + department + ", GPA: " + gpa;
    }
}
