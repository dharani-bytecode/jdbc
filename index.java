import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserRegistration {
    private static JTextField nameField, emailField;
    private static JComboBox<String> disabilityCombo;
    private static JButton submitButton;
    private static JLabel statusLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Accessible LinkedIn Registration");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        // Form Fields
        frame.add(new JLabel("Name:"));
        nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Email:"));
        emailField = new JTextField();
        frame.add(emailField);

        frame.add(new JLabel("Disability Type:"));
        String[] disabilities = {"None", "Visual Impairment", "Hearing Impairment", "Motor Disability", "Cognitive Disability"};
        disabilityCombo = new JComboBox<>(disabilities);
        frame.add(disabilityCombo);

        submitButton = new JButton("Submit");
        frame.add(submitButton);

        statusLabel = new JLabel("Status: Waiting for input");
        frame.add(statusLabel);

        // Button ActionListener
        submitButton.addActionListener(e -> handleRegistration());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void handleRegistration() {
        String name = nameField.getText();
        String email = emailField.getText();
        String disability = (String) disabilityCombo.getSelectedItem();

        if (name.isEmpty() || email.isEmpty()) {
            statusLabel.setText("Please fill all fields!");
        } else {
            statusLabel.setText("Welcome, " + name + "! You selected: " + disability);
            applyAccessibilityFeatures(disability);
        }
    }

    private static void applyAccessibilityFeatures(String disability) {
        switch (disability) {
            case "Visual Impairment":
                System.out.println("Enabling screen reader mode...");
                // Add Text-to-Speech or high-contrast features
                break;
            case "Hearing Impairment":
                System.out.println("Enabling visual alerts...");
                // Add visual notifications instead of audio
                break;
            case "Motor Disability":
                System.out.println("Enabling keyboard shortcuts...");
                // Add voice commands or larger clickable elements
                break;
            case "Cognitive Disability":
                System.out.println("Simplifying interface...");
                // Simplify UI and add tooltips
                break;
            default:
                System.out.println("Standard accessibility mode.");
                break;
        }
    }
}
