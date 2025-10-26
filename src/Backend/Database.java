package Backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    private ArrayList<Student> recordsArray;
    private String filename;

    public Database(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.recordsArray = new ArrayList<>();
        readFromFile();
    }

    public void insertRecord(Student record) throws FileNotFoundException {
        recordsArray.add(record);
        saveToFile();
    }

    public void deleteRecord(int key) throws FileNotFoundException {
        for (int i = 0; i < recordsArray.size(); i++) {
            if (getKey(recordsArray.get(i)) == key) {
                recordsArray.remove(i);
                break;
            }
        }
        saveToFile();
    }

    public void updateRecord(int ID, String name, int age, String department, double gpa,int oldID ) throws FileNotFoundException {
       for (int i = 0; i < recordsArray.size(); i++) {
            if (getKey(recordsArray.get(i)) == oldID) {
                recordsArray.get(i).setAge(age);
                recordsArray.get(i).setStudentID(ID);
                recordsArray.get(i).setDepartment(department);
                recordsArray.get(i).setGpa(gpa);
                recordsArray.get(i).setName(name);
                
                
                
                
                
                
                
                
                
                break;
            }
        }
        saveToFile();
    }

    public ArrayList<Student> returnAllRecords() {
        return recordsArray;
    }

    public String getFilename() {
        return filename;
    }

    public ArrayList<Student> getRecordsArray() {
        return recordsArray;
    }

    public void readFromFile() throws FileNotFoundException {
        File F = new File(filename);
        if (!F.exists()) {
            return;
        }

        Scanner s = new Scanner(F);
        recordsArray.clear();
        while (s.hasNextLine()) {
            String x = s.nextLine();
            recordsArray.add(createRecordFrom(x));
        }
        s.close();
    }

    public void saveToFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        for (int i = 0; i < recordsArray.size(); i++) {
            String line = recordsArray.get(i).lineRepresentation();
            writer.println(line);
        }
        writer.close();
    }

    public int getKey(Student record) {
        return record.getStudentID();
    }

    public Student searchById(int id) {
        for (Student x : recordsArray) {
            if (x.getStudentID() == id) {
                return x;
            }
        }
        return null;
    }

    public boolean contains(int id) {
        for (Student s : recordsArray) {
            if (s.getStudentID() == id) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student s : recordsArray) {
            if (s.getName().toLowerCase().startsWith(name.toLowerCase())) {
                foundStudents.add(s);
            }
        }
        if (foundStudents.isEmpty()) {
            return null;
        } else {
            return foundStudents;
        }

    }

    public Student createRecordFrom(String line) {
        String[] tokens = line.split(",");
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String gender = tokens[3];
        String dep = tokens[4];
        double gpa = Double.parseDouble(tokens[5]);
        return new Student(id, name, age, gender, dep, gpa);
    }
}
