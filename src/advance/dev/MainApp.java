package advance.dev;

import java.util.Scanner;

public class MainApp {
    // Hàm nhập thông tin các Person vào mảng persons
    public static void input(Person[] persons) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < persons.length; i++) {
            if (i < 4) {
                // Nếu là giáo viên
                System.out.println("Nhập thông tin giáo viên thứ " + (i + 1) + ":");
                System.out.print("Tên: ");
                String name = scanner.nextLine();

                System.out.print("Tuổi: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                System.out.print("Số điện thoại: ");
                String phoneNumber = scanner.nextLine();

                System.out.print("Mã giáo viên: ");
                String maGV = scanner.nextLine();

                System.out.print("Hệ số lương: ");
                double heSoLuong = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character

                persons[i] = new Teacher(name, age, phoneNumber, maGV, heSoLuong);
            } else {
                // Nếu là sinh viên
                System.out.println("Nhập thông tin sinh viên thứ " + (i - 3) + ":");
                System.out.print("Tên: ");
                String name = scanner.nextLine();

                System.out.print("Tuổi: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                System.out.print("Số điện thoại: ");
                String phoneNumber = scanner.nextLine();

                System.out.print("Điểm Toán: ");
                double diemToan = scanner.nextDouble();

                System.out.print("Điểm Lý: ");
                double diemLy = scanner.nextDouble();

                System.out.print("Điểm Hóa: ");
                double diemHoa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character

                System.out.print("Mã sinh viên: ");
                String maSV = scanner.nextLine();

                System.out.print("Lớp: ");
                String lop = scanner.nextLine();

                persons[i] = new Student(name, age, phoneNumber, diemToan, diemLy, diemHoa, maSV, lop);
            }
        }
    }

    // Hàm xuất thông tin các Person
    public static void print(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] instanceof Teacher) {
                Teacher teacher = (Teacher) persons[i];
                System.out.println("Thông tin giáo viên:");
                System.out.println("Tên: " + teacher.name);
                System.out.println("Tuổi: " + teacher.age);
                System.out.println("Số điện thoại: " + teacher.phoneNumber);
                System.out.println("Mã giáo viên: " + teacher.maGV);
                System.out.println("Hệ số lương: " + teacher.heSoLuong);
                System.out.println("Lương: " + teacher.tinhLuong());
            } else if (persons[i] instanceof Student) {
                Student student = (Student) persons[i];
                System.out.println("Thông tin sinh viên:");
                System.out.println("Tên: " + student.name);
                System.out.println("Tuổi: " + student.age);
                System.out.println("Số điện thoại: " + student.phoneNumber);
                System.out.println("Điểm Toán: " + student.diemToan);
                System.out.println("Điểm Lý: " + student.diemLy);
                System.out.println("Điểm Hóa: " + student.diemHoa);
                System.out.println("Mã sinh viên: " + student.maSV);
                System.out.println("Lớp: " + student.lop);
                System.out.println("Điểm trung bình: " + student.diemTrungBinh());
            }
            System.out.println();
        }
    }

    // Hàm tìm giáo viên có lương cao nhất
    public static Teacher findTeacher(Person[] persons) {
        Teacher highestPaidTeacher = null;
        double maxSalary = Double.MIN_VALUE;

        for (Person person : persons) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                double salary = teacher.tinhLuong();
                if (salary > maxSalary) {
                    maxSalary = salary;
                    highestPaidTeacher = teacher;
                }
            }
        }

        return highestPaidTeacher;
    }

    // Hàm tìm sinh viên có điểm trung bình cao nhất
    public static Student findTopStudent(Person[] persons) {
        Student topStudent = null;
        double maxAverageScore = Double.MIN_VALUE;

        for (Person person : persons) {
            if (person instanceof Student) {
                Student student = (Student) person;
                double averageScore = student.diemTrungBinh();
                if (averageScore > maxAverageScore) {
                    maxAverageScore = averageScore;
                    topStudent = student;
                }
            }
        }

        return topStudent;
    }

    public static void main(String[] args) {
        Person[] persons = new Person[10];
        input(persons);

        System.out.println("Danh sách thông tin các person:");
        print(persons);

        Teacher highestPaidTeacher = findTeacher(persons);
        if (highestPaidTeacher != null) {
            System.out.println("Thông tin giáo viên có lương cao nhất:");
            System.out.println("Tên: " + highestPaidTeacher.name);
            System.out.println("Tuổi: " + highestPaidTeacher.age);
            System.out.println("Số điện thoại: " + highestPaidTeacher.phoneNumber);
            System.out.println("Mã giáo viên: " + highestPaidTeacher.maGV);
            System.out.println("Hệ số lương: " + highestPaidTeacher.heSoLuong);
            System.out.println("Lương: " + highestPaidTeacher.tinhLuong());
        }

        Student topStudent = findTopStudent(persons);
        if (topStudent != null) {
            System.out.println("Thông tin sinh viên có điểm trung bình cao nhất:");
            System.out.println("Tên: " + topStudent.name);
            System.out.println("Tuổi: " + topStudent.age);
            System.out.println("Số điện thoại: " + topStudent.phoneNumber);
            System.out.println("Điểm trung bình: " + topStudent.diemTrungBinh());
        }
    }
}