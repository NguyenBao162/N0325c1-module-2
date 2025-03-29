package ss3_Bai1;

public class Student {

    int id;
    String name;
    double score;
    static int studentCount;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        studentCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void setStudentCount(int studentCount) {
        Student.studentCount = studentCount;
    }

    public static int result() {
        return studentCount;
    }
}

