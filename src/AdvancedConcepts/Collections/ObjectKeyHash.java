package AdvancedConcepts.Collections;

import java.util.HashSet;
import java.util.Objects;

class Student {
    String name;
    int id;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return this.name.equals(s.name) && this.id == s.id;
        // return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{id="+id+", name="+name+"}";
    }
}

public class ObjectKeyHash {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Nithin");
        Student s2 = new Student(1, "Nithin");
        System.out.println(s1 == s2); // == Always checks object reference
        System.out.println(s1.equals(s2)); // If equals method is not overridden returns object reference check
        System.out.println(s1.equals(new Student(1, "Nithin")));
        HashSet<Student> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(new Student(1, "Nithin"));
        System.out.println(studentSet); // prints the set with object address when toString() is not overridden
        // else prints the set with object using overridden toString method
        System.out.println(studentSet.size()); // can store duplicates unless equals method is overridden
        // For objects to be equal their hash must be same but not vice versa
        // i.e. same hash doesn't mean objects are same

        System.out.println(studentSet.contains(new Student(1, "Nithin")));
    }
}
