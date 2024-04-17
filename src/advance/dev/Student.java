package advance.dev;

class Student extends Person {
    double diemToan;
    double diemLy;
    double diemHoa;
    String maSV;
    String lop;

    // Constructor
    public Student(String name, int age, String phoneNumber, double diemToan, double diemLy, double diemHoa, String maSV, String lop) {
        super(name, age, phoneNumber);
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        this.maSV = maSV;
        this.lop = lop;
    }

    // Hàm tính điểm trung bình
    public double diemTrungBinh() {
        return (diemToan + diemLy + diemHoa) / 3;
    }
}
