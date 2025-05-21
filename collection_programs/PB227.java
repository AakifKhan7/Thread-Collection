package collection_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*
 * Write a Java program that creates an ArrayList<Student> to store a name
and marks of 3 students. Then sort the ArrayList by student marks in
descending order. Then print arraylist using iterator. Add these details of
3 Students in arraylist in given sequence:
Devarsh (18.5 marks), Viraj (20.5 marks) and Nidhi (17.5 marks)
Desired Output:
Name=Viraj, Marks=20.5
Name=Devarsh, Marks=18.5
Name=Nidhi, Marks=17.5

 */

public class PB227 {
    public static void main(String[] args) {
        ArrayList<Student> al1 = new ArrayList<>();
        al1.add(new Student("viraj", 20.5));
        al1.add(new Student("Devarsh", 18.5));
        al1.add(new Student("Nidhi", 17.5));    

        Collections.sort(al1, Comparator.comparing(Student::getMarks).reversed());

        Iterator<Student> it = al1.iterator();
        while(it.hasNext()){
            Student s = it.next();
            System.out.println("Name=" + s.name + ", Marks=" + s.marks);
            
        }
    }
}

class Student{
    String name;
    double marks;

    Student(String name, double marks){
        this.name = name;
        this.marks = marks;
    }

    double getMarks(){
        return marks;
    }
}
