package ss2_Bai3;

public class StudentBaoDong {
    private int id;
    private String name;
    private double score;

    public StudentBaoDong() {
    }

    public StudentBaoDong(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().equals("")) {
            System.out.println("Lỗi: tên bắt buộc nhập");
        } else {
            this.name = name;
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score < 0 || score > 10) {
            System.out.println("Điểm không hợp lệ! ");
        } else {
            this.score = score;
        }
    }
}

