import java.util.ArrayList;

public class ReportGenerator {

    // Generate individual student report
    public void generateStudentReport(
            Student student,
            ArrayList<Marks> marksList,
            Attendance attendance) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       STUDENT PERFORMANCE REPORT");
        System.out.println("======================================");

        student.displayDetails();

        System.out.println();
        System.out.println("----- SUBJECT MARKS -----");

        double total = 0;

        for (Marks marks : marksList) {
            if (marks.getStudent() == student) {
                marks.displayMarks();
                total += marks.getMarksObtained();
            }
        }

        double average = 0;

        if (!marksList.isEmpty()) {
            int count = 0;

            for (Marks marks : marksList) {
                if (marks.getStudent() == student) {
                    count++;
                }
            }

            if (count > 0) {
                average = total / count;
            }
        }

        Result result = new Result(student, total, average);

        System.out.println();
        result.displayResult();

        System.out.println();
        attendance.displayAttendance();

        System.out.println("======================================");
    }
}