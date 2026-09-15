public class Teacher extends User {

    private String department;
    private String subject;

    // Constructor
    public Teacher(int userId, String name, String email,
                   String department, String subject) {

        super(userId, name, email);

        this.department = department;
        this.subject = subject;
    }

    // Getters
    public String getDepartment() {
        return department;
    }

    public String getSubject() {
        return subject;
    }

    // Overriding displayDetails()
    @Override
    public void displayDetails() {

        System.out.println("----- TEACHER DETAILS -----");

        super.displayDetails();

        System.out.println("Department: " + department);
        System.out.println("Subject: " + subject);
    }
}