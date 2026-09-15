import java.util.ArrayList;

public class AcademicSystem {

    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Subject> subjects;
    private ArrayList<Marks> marksList;
    private ArrayList<Attendance> attendanceList;

    // Constructor
    public AcademicSystem() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        subjects = new ArrayList<>();
        marksList = new ArrayList<>();
        attendanceList = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Add teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("Teacher added successfully.");
    }

    // Add subject
    public void addSubject(Subject subject) {
        subjects.add(subject);
        System.out.println("Subject added successfully.");
    }

    // Add marks
    public void addMarks(Marks marks) {
        marksList.add(marks);
        System.out.println("Marks added successfully.");
    }

    // Add attendance
    public void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
        System.out.println("Attendance added successfully.");
    }

    // Display all students
    public void displayAllStudents() {

        System.out.println();
        System.out.println("========== ALL STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {
            student.displayDetails();
            System.out.println("------------------------------");
        }
    }

    // Display all teachers
    public void displayAllTeachers() {

        System.out.println();
        System.out.println("========== ALL TEACHERS ==========");

        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }

        for (Teacher teacher : teachers) {
            teacher.displayDetails();
            System.out.println("------------------------------");
        }
    }

    // Find student by ID
    public Student findStudent(int userId) {

        for (Student student : students) {

            if (student.getUserId() == userId) {
                return student;
            }
        }

        return null;
    }

    // Generate report for a student
    public void generateStudentReport(int studentId) {

        Student student = findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Attendance attendance = null;

        for (Attendance a : attendanceList) {

            if (a.getStudent() == student) {
                attendance = a;
                break;
            }
        }

        if (attendance == null) {
            System.out.println("Attendance record not found.");
            return;
        }

        ReportGenerator reportGenerator = new ReportGenerator();

        reportGenerator.generateStudentReport(
                student,
                marksList,
                attendance
        );
    }
}