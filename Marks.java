public class Marks {

    private Student student;
    private Subject subject;
    private double marksObtained;

    // Constructor
    public Marks(Student student, Subject subject, double marksObtained) {

        if (marksObtained < 0 || marksObtained > subject.getMaxMarks()) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and " + subject.getMaxMarks()
            );
        }

        this.student = student;
        this.subject = subject;
        this.marksObtained = marksObtained;
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    // Calculate percentage
    public double calculatePercentage() {

        return (marksObtained / subject.getMaxMarks()) * 100;
    }

    // Display marks
    public void displayMarks() {

        System.out.println("Student: " + student.getName());
        System.out.println("Subject: " + subject.getSubjectName());
        System.out.println("Marks: " + marksObtained +
                           "/" + subject.getMaxMarks());
        System.out.println("Percentage: " +
                           calculatePercentage() + "%");
    }
}