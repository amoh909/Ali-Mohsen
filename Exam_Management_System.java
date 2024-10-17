import java.util.ArrayList;

class Student {
    // Attributes
    private static int Id = 202400000;
    private int StudentId;
    private String Name;

    // Constructor:
    public Student(String Name) {
        this.Name = Name;
        this.StudentId = Id;
        ++Id;
    }

    // Setters:
    public void setStudentId(int I) {
        StudentId = I;
    }

    public void setName(String N) {
        Name = N;
    }

    // Getters:
    public int getStudentId() {
        return StudentId;
    }

    public String getName() {
        return Name;
    }

    // override toString()
    public String toString() {
        return "Name: " + Name + ", Student Id: " + StudentId;
    }
}

class ExamParticipant {
    // Attributes:
    private double grade;
    private Student student;

    // Constructor:
    public ExamParticipant(Student student, double grade) {
        student.getName();
        setGrade(grade);
        setStudent(student);
    }

    // Setters:
    public void setStudent(Student s) {
        student = s;
    }

    public void setGrade(double g) {
        grade = g;
    }

    // Getters:
    public Student getStudent() {
        return student;
    }

    public double getGrade() {
        return grade;
    }

    // override toString()
    public String toString() {
        return "Student: " + student.toString() + ", Grade: " + grade;
    }
}

class Exam {
    // Attributes
    private String title;
    private ArrayList<ExamParticipant> participants = new ArrayList<>();

    // Constructor
    public Exam(String title) {
        this.title = title;

    }

    // methods
    public void addParticipant(ExamParticipant participant) {
        participants.add(participant);
    }

    public void raiseGrades(double bonusPoints) {
        for (int i = 0; i < participants.size(); i++) {
            double gr = participants.get(i).getGrade();
            gr += bonusPoints;
            participants.get(i).setGrade(gr);
        }
    }

    public double getAverageGrade() {
        double sum = 0;
        int nb = 0;
        for (int i = 0; i < participants.size(); i++) {
            sum += participants.get(i).getGrade();
            nb++;
        }
        double average = (sum / nb);
        return average;
    }

    public void displayParticipantsInfo() {
        for (int i = 0; i < participants.size(); i++) {
            System.out.println(participants.get(i));
        }
    }

    public void performRaise() {
        if (getAverageGrade() < 50) {
            for (int i = 0; i < participants.size(); i++) {
                if (participants.get(i).getGrade() < getAverageGrade()) {
                    double newgrade = participants.get(i).getGrade();
                    newgrade += (0.15 * newgrade);
                    participants.get(i).setGrade(newgrade);
                } else {
                    double newgrade = participants.get(i).getGrade();
                    newgrade += (0.1 * newgrade);
                    participants.get(i).setGrade(newgrade);
                }
            }
        } else if (getAverageGrade() < 65) {
            for (int i = 0; i < participants.size(); i++) {
                if (participants.get(i).getGrade() < getAverageGrade()) {
                    double newgrade = participants.get(i).getGrade();
                    newgrade += (0.1 * newgrade);
                    participants.get(i).setGrade(newgrade);
                } else {
                    double newgrade = participants.get(i).getGrade();
                    newgrade += (0.05 * newgrade);
                    participants.get(i).setGrade(newgrade);
                }
            }
        }
    }
}

class ExamTest {
    public static void main(String[] args) {
        Exam finalExam = new Exam(" Final Exam ");
        finalExam.addParticipant(new ExamParticipant(new Student(" David "), 78.5));
        finalExam.addParticipant(new ExamParticipant(new Student(" Eva "), 89));
        finalExam.addParticipant(new ExamParticipant(new Student(" Frank "), 95.2));
        finalExam.displayParticipantsInfo();
        System.out.println(finalExam.getAverageGrade());
        finalExam.raiseGrades(5);
        finalExam.displayParticipantsInfo();
        finalExam.performRaise();
        finalExam.displayParticipantsInfo();
    }
}