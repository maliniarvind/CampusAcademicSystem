public class Result {

    private Student student;
    private double totalMarks;
    private double averageMarks;

    // Constructor
    public Result(Student student, double totalMarks, double averageMarks) {
        this.student = student;
        this.totalMarks = totalMarks;
        this.averageMarks = averageMarks;
    }

    // Calculate grade
    public String calculateGrade() {

        if (averageMarks >= 90) {
            return "A+";
        } else if (averageMarks >= 80) {
            return "A";
        } else if (averageMarks >= 70) {
            return "B";
        } else if (averageMarks >= 60) {
            return "C";
        } else if (averageMarks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Check pass/fail
    public String getStatus() {

        if (averageMarks >= 50) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    // Display result
    public void displayResult() {

        System.out.println("----- ACADEMIC RESULT -----");
        System.out.println("Student: " + student.getName());
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Status: " + getStatus());
    }
}