//import javax.swing.*;
//import java.awt.*;
//
//class TeacherGUI {
//
//  // Initialize components
//  JFrame welcomeFrameScreen = new JFrame("Teacher Management System");
//  JPanel mainPanel = new JPanel();
//  JLabel welcomeLabel = new JLabel("Welcome");
//  JLabel descriptionLabel = new JLabel("Please select teacher or Lecturer to Manage them");
//  JButton teacherButton = new JButton("Manage Teacher");
//  JButton lecturerButton = new JButton("Manage Lecturer");
//
//  public static void main(String[] args) {
//    new TeacherGUI();
//  }
//
//  public TeacherGUI() {
//    this.showWelcomeScreen();
//  }
//
//  public void showWelcomeScreen() {
//    welcomeFrameScreen.setSize(500, 300);
//    welcomeFrameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    welcomeFrameScreen.setLocationRelativeTo(null);  // Center the window on the screen
//
//    // Set up the main panel with BoxLayout for vertical stacking
//    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//
//    // Add the welcome label and add vertical space after it
//    welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align
//    mainPanel.add(welcomeLabel);
//    mainPanel.add(Box.createVerticalStrut(10));  // Space after welcome label
//
//    // Add the description label and add vertical space after it
//    descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align
//    mainPanel.add(descriptionLabel);
//    mainPanel.add(Box.createVerticalStrut(30));  // More space before the buttons
//
//    // Panel for buttons, using FlowLayout for natural flow and optional centering
//    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0)); // 50 pixels horizontal space between buttons
//    buttonPanel.add(teacherButton);
//    buttonPanel.add(Box.createHorizontalStrut(20));  // Optional: add some horizontal space between buttons
//    buttonPanel.add(lecturerButton);
//
//    // Add the button panel to the main panel
//    mainPanel.add(buttonPanel);
//
//    // Add main panel to the frame
//    welcomeFrameScreen.add(mainPanel);
//
//    // Display the window
//    welcomeFrameScreen.setVisible(true);
//  }
//
//}



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeacherGUI {

    private JFrame frame;
    private JTextField teacherIdField, teacherNameField, addressField, workingTypeField, employmentStatusField,workingHoursField,specializationField ,performanceIndexField ,academicQualificationsField ,salaryField, gradedScoreField, departmentField, yearsExperienceField;
    private JButton addButton, gradeButton, displayButton, clearButton, backButton;
    private ArrayList<Teacher> teachers = new ArrayList<>();



    // Initialize components
    JFrame welcomeFrameScreen = new JFrame("Teacher Management System");
    JPanel mainPanel = new JPanel();
    JLabel welcomeLabel = new JLabel("Welcome");
    JLabel descriptionLabel = new JLabel("Please select teacher or Lecturer to Manage them");
    JButton teacherButton = new JButton("Manage Tutor");
    JButton lecturerButton = new JButton("Manage Lecturer");

    public static void main(String[] args) {
        new TeacherGUI();
    }

    public TeacherGUI() {
        this.showWelcomeScreen();
    }

    public void showWelcomeScreen() {
        welcomeFrameScreen.setSize(500, 300);
        welcomeFrameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrameScreen.setLocationRelativeTo(null);  // Center the window on the screen

        // Set up the main panel with BoxLayout for vertical stacking
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add the welcome label and add vertical space after it
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align
        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createVerticalStrut(10));  // Space after welcome label

        // Add the description label and add vertical space after it
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align
        mainPanel.add(descriptionLabel);
        mainPanel.add(Box.createVerticalStrut(30));  // More space before the buttons

        // Panel for buttons, using FlowLayout for natural flow and optional centering
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0)); // 50 pixels horizontal space between buttons
        teacherButton.addActionListener(e -> displayTutor());
        buttonPanel.add(teacherButton);
        buttonPanel.add(Box.createHorizontalStrut(20));  // Optional: add some horizontal space between buttons
        lecturerButton.addActionListener(e -> initializeLecturer());
        buttonPanel.add(lecturerButton);

        // Add the button panel to the main panel
        mainPanel.add(buttonPanel);

        // Add main panel to the frame
        welcomeFrameScreen.add(mainPanel);

        // Display the window
        welcomeFrameScreen.setVisible(true);
    }
    private void displayTutor() {
        welcomeFrameScreen.dispose(); // Close the welcome screen
        frame = new JFrame("Teacher Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(0, 2));
        teacherIdField = addFormField(formPanel, "Teacher ID:");
        teacherNameField = addFormField(formPanel, "Teacher Name:");
        addressField = addFormField(formPanel, "Address:");
        workingTypeField = addFormField(formPanel, "Working Type:");
        employmentStatusField = addFormField(formPanel, "Employment Status:");
        workingHoursField = addFormField(formPanel, "Working Hours:");
        salaryField = addFormField(formPanel, "Salary:");
        specializationField = addFormField(formPanel, "Specialization:");
        academicQualificationsField = addFormField(formPanel, "Academic Qualifications:");
        performanceIndexField = addFormField(formPanel, "Performance Index:");

        JPanel buttonPanel = new JPanel();
        JButton addTutorButton = new JButton("Add Tutor");
        JButton setSalaryButton = new JButton("Set Salary");
        JButton removeTutorButton = new JButton("Remove Tutor");
        JButton displayButton = new JButton("Display Tutors");
        JButton clearButton = new JButton("Clear Fields");
        JButton backButton = new JButton("Back");

        addTutorButton.addActionListener(e -> addTutor());
        setSalaryButton.addActionListener(e -> setSalary());
        removeTutorButton.addActionListener(e -> removeTutor());
        displayButton.addActionListener(e -> displayTutors());
        clearButton.addActionListener(e -> clearTutorFields());
        backButton.addActionListener(e -> frame.dispose());

        buttonPanel.add(addTutorButton);
        buttonPanel.add(setSalaryButton);
        buttonPanel.add(removeTutorButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addTutor() {
        try {
            int id = Integer.parseInt(teacherIdField.getText());
            String name = teacherNameField.getText();
            String address = addressField.getText();
            String workingType = workingTypeField.getText();
            String employmentStatus = employmentStatusField.getText();
            int workingHours = Integer.parseInt(workingHoursField.getText());
            double salary = Double.parseDouble(salaryField.getText());
            String specialization = specializationField.getText();
            String academicQualification = academicQualificationsField.getText();
            int performanceIndex = Integer.parseInt(performanceIndexField.getText());

            Tutor newTutor = new Tutor(id, true, name, address, workingType, employmentStatus, workingHours, salary, specialization, academicQualification, performanceIndex);
            teachers.add(newTutor);
            JOptionPane.showMessageDialog(frame, "Tutor added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please check your input.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to set salary of tutor
    private void setSalary() {
        try {
            int id = Integer.parseInt(teacherIdField.getText());
            double newSalary = Double.parseDouble(salaryField.getText());
            int newPerformanceIndex = Integer.parseInt(performanceIndexField.getText());

            for (Teacher teacher : teachers) {
                if (teacher instanceof Tutor && teacher.getTeacherId() == id) {
                    Tutor tutor = (Tutor) teacher;
                    tutor.setSalary(newSalary, newPerformanceIndex);
                    JOptionPane.showMessageDialog(frame, "Salary updated successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Tutor not found!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for ID, Salary, and Performance Index.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to remove tutor
    private void removeTutor() {
        try {
            int id = Integer.parseInt(teacherIdField.getText());
            for (int i = 0; i < teachers.size(); i++) {
                Teacher teacher = teachers.get(i);
                if (teacher instanceof Tutor && teacher.getTeacherId() == id) {
                    teachers.remove(i);
                    JOptionPane.showMessageDialog(frame, "Tutor removed successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Tutor not found!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to display all tutors
    private void displayTutors() {
        String output = "";
        for (Teacher teacher : teachers) {
            if (teacher instanceof Tutor) {
                Tutor tutor = (Tutor) teacher;
                output += "ID: " + tutor.getTeacherId() + ", Name: " + tutor.getTeacherName() + "\n";
                output += "Address: " + tutor.getAddress() + ", Working Type: " + tutor.getWorkingType() + "\n";
                output += "Employement Status: " + tutor.getEmploymentStatus() + ", Working Hours: " + tutor.getWorkingHours() + "\n";
                output += "Salary: " + tutor.getSalary() + ", Specialization: " + tutor.getSpecialization() + "\n";
                output += "Academic Qualification: " + tutor.getAcademicQualification() + ", Performance Index: " + tutor.getPerformanceIndex() + "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, output.isEmpty() ? "No tutors found." : output, "All Tutors", JOptionPane.INFORMATION_MESSAGE);
    }

    // Clear form fields
    private void clearTutorFields() {
        teacherIdField.setText("");
        teacherNameField.setText("");
        addressField.setText("");
        workingTypeField.setText("");
        employmentStatusField.setText("");
        workingHoursField.setText("");
        salaryField.setText("");
        specializationField.setText("");
        academicQualificationsField.setText("");
        performanceIndexField.setText("");
    }

    private JTextField addFormField(JPanel panel, String label) {
        JLabel lbl = new JLabel(label);
        JTextField textField = new JTextField(10);
        panel.add(lbl);
        panel.add(textField);
        return textField;
    }

    private void showLecturerManagementScreen() {
        // Implement showing the lecturer management screen
    }
    private void initializeLecturer() {
        welcomeFrameScreen.dispose();
        frame = new JFrame("Teacher Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2));

        // Add fields to form panel
        teacherIdField = addFormField(formPanel, "Teacher ID:");
        teacherNameField = addFormField(formPanel, "Teacher Name:");
        addressField = addFormField(formPanel, "Address:");
        workingTypeField = addFormField(formPanel, "Working Type:");
        employmentStatusField = addFormField(formPanel, "Employment Status:");
        departmentField = addFormField(formPanel, "Department:");
        yearsExperienceField = addFormField(formPanel, "Years of Experience:");
        gradedScoreField = addFormField(formPanel, "Graded Score:");

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Lecturer");
        gradeButton = new JButton("Grade Assignment");
        displayButton = new JButton("Display Lecturers");
        clearButton = new JButton("Clear Fields");
        backButton = new JButton("Back");

        addButton.addActionListener(e -> addLecturer());
        gradeButton.addActionListener(e -> gradeAssignment());
        displayButton.addActionListener(e -> displayLecturers());
        clearButton.addActionListener(e -> clearFields());
        backButton.addActionListener(e -> {frame.dispose(); showWelcomeScreen();});

        buttonPanel.add(addButton);
        buttonPanel.add(gradeButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private JTextField addTutorFormField(JPanel panel, String label) {
        JLabel lbl = new JLabel(label);
        JTextField textField = new JTextField(10);
        panel.add(lbl);
        panel.add(textField);
        return textField;
    }

    private void addLecturer() {
        try {
            int id = Integer.parseInt(teacherIdField.getText());
            String name = teacherNameField.getText();
            String address = addressField.getText();
            String workingType = workingTypeField.getText();
            String employmentStatus = employmentStatusField.getText();
            String department = departmentField.getText();
            int yearsExperience = Integer.parseInt(yearsExperienceField.getText());
            int workingHours = 40; // Assume a standard value for demo

            Lecturer lecturer = new Lecturer(id, name, address, workingType, employmentStatus, department, yearsExperience, workingHours);
            teachers.add(lecturer);
            JOptionPane.showMessageDialog(frame, "Lecturer added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gradeAssignment() {
        try {
            int id = Integer.parseInt(teacherIdField.getText());
            int gradedScore = Integer.parseInt(gradedScoreField.getText());
            String department = departmentField.getText();
            int yearsExperience = Integer.parseInt(yearsExperienceField.getText());

            for (Teacher teacher : teachers) {
                if (teacher.getTeacherId() == id) {
                    Lecturer lecturer = (Lecturer) teacher;
                    lecturer.gradeAssignment(gradedScore, department, yearsExperience);
                    if(lecturer.getHasGraded())
                    {
                        JOptionPane.showMessageDialog(frame, "Assignments graded: " + lecturer.getGradedScore());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "Assignments Not Graded");
                    }

                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Lecturer not found.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayLecturers() {
        String output = "";
        for (Teacher teacher : teachers) {
            if (teacher instanceof Lecturer) {
                Lecturer lecturer = (Lecturer) teacher;
                output += "ID: " + lecturer.getTeacherId() +
                        ", Name: " + lecturer.getTeacherName() +
                        ", Department: " + lecturer.getDepartment() +
                        ", Years of Experience: " + lecturer.getYearsOfExperience() +
                        ", Graded Score: " + lecturer.getGradedScore() + "\n";
            }
        }
        if (!output.isEmpty()) {
            JOptionPane.showMessageDialog(frame, output, "All Lecturers", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "No lecturers found.", "All Lecturers", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void clearFields() {
        teacherIdField.setText("");
        teacherNameField.setText("");
        addressField.setText("");
        workingTypeField.setText("");
        employmentStatusField.setText("");
        departmentField.setText("");
        yearsExperienceField.setText("");
        gradedScoreField.setText("");
    }
}
