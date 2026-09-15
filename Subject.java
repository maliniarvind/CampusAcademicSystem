public class Subject {

    private int subjectId;
    private String subjectName;
    private int maxMarks;

    // Constructor
    public Subject(int subjectId, String subjectName, int maxMarks) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
    }

    // Getters
    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    // Display subject details
    public void displaySubject() {

        System.out.println("Subject ID: " + subjectId);
        System.out.println("Subject Name: " + subjectName);
        System.out.println("Maximum Marks: " + maxMarks);
    }
}