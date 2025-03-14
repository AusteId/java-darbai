

public class Student implements Comparable {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public int compareTo(Student student) {
        return name.compareTo(student.getName());
    }
}
