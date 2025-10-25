package lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database<T extends Record> {
    private ArrayList<T> recordsArray;
    private String filename;

    public Database(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.recordsArray = new ArrayList<>();
        readFromFile();
    }

    public void insertRecord(T record) throws FileNotFoundException {
        recordsArray.add(record);
        saveToFile();
    }

    public void deleteRecord(String key) throws FileNotFoundException {
        for (int i = 0; i < recordsArray.size(); i++) {
            if (key.equals(getKey(recordsArray.get(i)))) {
                recordsArray.remove(i);
                break;
            }
        }
        saveToFile();
    }

    public ArrayList<T> returnAllRecords() {
        return recordsArray;
    }

    public String getFilename() {
        return filename;
    }

    public ArrayList<T> getRecordsArray() {
        return recordsArray;
    }

    public void readFromFile() throws FileNotFoundException {
        File F = new File(filename);
        if (!F.exists()) return;

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

    abstract String getKey(T record);
    abstract T createRecordFrom(String line);
}