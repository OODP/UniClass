package app;

import java.util.ArrayList;
import java.util.List;

//singleton pattern 구현
public class UserManager {
    private static final UserManager instance = new UserManager();
    private final List<Student> students = new ArrayList<>();
    private final List<Professor> professors = new ArrayList<>();
    private final List<Staff> staffs = new ArrayList<>();
    private final List<Manager> managers = new ArrayList<>();


    private UserManager() {}

    public static UserManager getInstance() {
        return instance;
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Professor findProfessorById(String id) {
        for (Professor professor : professors) {
            if (professor.getId().equals(id)) {
                return professor;
            }
        }
        return null;
    }

    public Staff findStaffById(String id) {
        for (Staff staff : staffs) {
            if (staff.getId().equals(id)) {
                return staff;
            }
        }
        return null;
    }

    public Manager findManagerById(String id) {
        for (Manager manager : managers) {
            if (manager.getId().equals(id)) {
                return manager;
            }
        }
        return null;
    }

    public List<Student> findAllStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addStaff(Staff staff) {
        Auth.StaffList.add(new StaffContext(staff));
    }

    public void addManager(Manager manager) {
        managers.add(manager);
    }
}
