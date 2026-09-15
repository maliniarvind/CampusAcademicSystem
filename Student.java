public class Student extends User {

    private String course;
    private int semester;

    // Constructor
    public Student(int userId, String name, String email,
                   String course, int semester) {

        super(userId, name, email);

        this.course = course;
        this.semester = semester;
    }

    // Getters
    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    // Overriding displayDetails()
    @Override
    public void displayDetails() {

        System.out.println("----- STUDENT DETAILS -----");

        super.displayDetails();

        System.out.println("Course: " + course);
        System.out.println("Semester: " + semester);
    }
}