package characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Create a class called Student. Write a student manager program to
manipulate the student information from files by using the
BufferedReader and BufferedWriter.
 */

public class PB354 {
    public static void main(String[] args) throws IOException{
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        String line;
        List<Student> students = new ArrayList<>();

        while ((line = br.readLine()) != null)  {
            String[] data = line.split(",");
            if (data.length == 3) {
                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());
                String rollNo = data[2];
                students.add(new Student(name, age, rollNo));
            }
        }

        for(Student s: students){
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();

        for (Student student : students) {
            System.out.println(student);
        }
        br.close();
    }
}

class Student {
    String name;
    int age;
    String rollNo;

    Student(String name, int age, String rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Roll Number: " + rollNo;
    }
}