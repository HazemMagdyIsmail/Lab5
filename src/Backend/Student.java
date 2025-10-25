package Backend;

public class Student {
        private String name;
    private int age;
    private String gender;
    private int StudentID;
    private String department;
    private double gpa;


    public Student(int studentID, String name, int age, String gender, String department, double gpa) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getSearchKey() {
        return Integer.toString(StudentID);
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}


     public String lineRepresentation() {
        return StudentID + "," + getName() + "," + getAge() + "," +
                getGender() + "," + department + "," + gpa;
    }

    @Override
    public String toString(){
        return "ID: " + StudentID + ", Name: " + getName() + ", Age: " + getAge() +
                ", Gender: " + getGender() + ", Dept: " + department + ", GPA: " + gpa;
    }
}
