package Models;

import java.util.Objects;

public class Student {
    private int id;
    private String Name;

    public Student(int id, String name) {
        this.id = id;
        Name = name;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(Name, student.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name);
    }
}
