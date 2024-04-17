package advance.dev;

class Teacher extends Person {
    String maGV;
    double heSoLuong;

    // Constructor
    public Teacher(String name, int age, String phoneNumber, String maGV, double heSoLuong) {
        super(name, age, phoneNumber);
        this.maGV = maGV;
        this.heSoLuong = heSoLuong;
    }

    // Hàm tính lương
    public double tinhLuong() {
        // Giả sử mức lương cơ bản là 10 triệu
        double luongCoBan = 10000000;
        return luongCoBan * heSoLuong;
    }
}
