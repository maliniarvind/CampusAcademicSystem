import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static AcademicSystem system = new AcademicSystem();

    public static void main(String[] args) {

        addSampleData();

        while (true) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("   CAMPUS ACADEMIC MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Teacher Portal");
            System.out.println("2. Student Portal");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            int choice = getInt();

            switch (choice) {

                case 1:
                    teacherMenu();
                    break;

                case 2:
                    studentMenu();
                    break;

                case 3:
                    System.out.println("Thank you for using the system!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add sample data for demonstration
    public static void addSampleData() {

        Student student = new Student(
                101,
                "Rahul Sharma",
                "rahul@gmail.com",
                "B.Tech CSE AI/ML",
                3
        );

        Teacher teacher = new Teacher(
                201,
                "Dr. Priya Singh",
                "priya@gmail.com",
                "Computer Science",
                "Java Programming"
        );

        Subject java = new Subject(1, "Java Programming", 100);
        Subject os = new Subject(2, "Operating Systems", 100);
        Subject ai = new Subject(3, "Artificial Intelligence", 100);

        system.addStudent(student);
        system.addTeacher(teacher);

        system.addSubject(java);
        system.addSubject(os);
        system.addSubject(ai);

        system.addMarks(new Marks(student, java, 88));
        system.addMarks(new Marks(student, os, 79));
        system.addMarks(new Marks(student, ai, 92));

        system.addAttendance(new Attendance(student, 40, 34));
    }

    // Teacher menu
    public static void teacherMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== TEACHER PORTAL ==========");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. View All Teachers");
            System.out.println("4. Generate Student Report");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");

            int choice = getInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = getInt();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Semester: ");
                    int semester = getInt();

                    Student newStudent = new Student(
                            id,
                            name,
                            email,
                            course,
                            semester
                    );

                    system.addStudent(newStudent);

                    break;

                case 2:
                    system.displayAllStudents();
                    break;

                case 3:
                    system.displayAllTeachers();
                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int studentId = getInt();

                    system.generateStudentReport(studentId);

                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Student menu
    public static void studentMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== STUDENT PORTAL ==========");
            System.out.println("1. View My Details");
            System.out.println("2. View My Performance Report");
            System.out.println("3. Back to Main Menu");

            System.out.print("Enter your choice: ");

            int choice = getInt();

            // If student chooses Back, return immediately
            if (choice == 3) {
                return;
            }

            // Ask for Student ID only for Student Portal features
            System.out.print("Enter Student ID: ");
            int studentId = getInt();

            Student student = system.findStudent(studentId);

            // Check whether student exists
            if (student == null) {
                System.out.println("Student not found.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.println();
                    student.displayDetails();

                    break;

                case 2:

                    system.generateStudentReport(studentId);

                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Safe integer input
    public static int getInt() {

        while (true) {

            try {

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.print("Please enter a valid number: ");
            }
        }
    }
}