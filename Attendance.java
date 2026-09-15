public class Attendance {

    private Student student;
    private int totalClasses;
    private int attendedClasses;

    // Constructor
    public Attendance(Student student, int totalClasses, int attendedClasses) {

        if (totalClasses <= 0) {
            throw new IllegalArgumentException(
                "Total classes must be greater than 0."
            );
        }

        if (attendedClasses < 0 || attendedClasses > totalClasses) {
            throw new IllegalArgumentException(
                "Attended classes must be between 0 and total classes."
            );
        }

        this.student = student;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    // Get student
    public Student getStudent() {
        return student;
    }

    // Calculate attendance percentage
    public double calculatePercentage() {
        return ((double) attendedClasses / totalClasses) * 100;
    }

    // Check attendance status
    public String getStatus() {

        if (calculatePercentage() >= 75) {
            return "Eligible";
        } else {
            return "Short Attendance";
        }
    }

    // Display attendance
    public void displayAttendance() {

        System.out.println("----- ATTENDANCE -----");
        System.out.println("Student: " + student.getName());
        System.out.println("Total Classes: " + totalClasses);
        System.out.println("Attended Classes: " + attendedClasses);
        System.out.println("Attendance: " +
                           calculatePercentage() + "%");
        System.out.println("Status: " + getStatus());
    }
}