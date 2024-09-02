/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expertsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class loginscreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public loginscreen() {
        setTitle("Registration Form");
        setSize(640, 360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        getContentPane().setBackground(new Color(30, 3, 66)); // Set background color for the entire frame
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // Make the panel transparent
        JLabel titleLabel = new JLabel("Registration Form");
        titleLabel.setFont(new Font("Gagalin", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false); // Make the panel transparent
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        usernameLabel.setPreferredSize(new Dimension(150, 30)); 
        formPanel.add(usernameLabel, gbc);

        gbc.gridy++;
        usernameField = new JTextField(20);
        formPanel.add(usernameField, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE); // Set text color to white
        passwordLabel.setPreferredSize(new Dimension(150, 30)); 
        formPanel.add(passwordLabel, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        gbc.gridy++;
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (isValid(username, password)) {
                    new welcomescreen();
                    dispose();
                }
            }
        });
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setForeground(Color.WHITE); // Set text color to white
        submitButton.setBackground(new Color(14, 70, 163)); // Custom color
        submitButton.setFocusPainted(false); // Remove the border when focused
        submitButton.setBorderPainted(false); // Remove the border
        submitButton.setOpaque(true); // Make the button opaque
        submitButton.setPreferredSize(new Dimension(120, 35)); 
        formPanel.add(submitButton, gbc);

        // Add Login label
        
    }

    private boolean isValid(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                registerpage registrationForm = new registerpage();
                registrationForm.setVisible(true);
            }
        });
    }
}

