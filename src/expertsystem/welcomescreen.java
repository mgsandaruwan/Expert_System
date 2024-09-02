package expertsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jpl7.Query;
import org.jpl7.Term;

public class welcomescreen extends JFrame {

    public welcomescreen() {
        setTitle("AI MediCare");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(670, 360);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Create a panel with background color
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the background color
                g.setColor(new Color(30, 3, 66)); // Dodger Blue color
                g.fillRect(0, 0, getWidth(), getHeight()); // Fill the entire panel with the background color
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Create a label for the title
        JLabel titleLabel = new JLabel("AI MediCare");
        titleLabel.setFont(new Font("Gagalin", Font.BOLD, 50));
        titleLabel.setForeground(new Color(14, 70, 163)); // Set text color to custom color
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        // Add padding between title and description
        backgroundPanel.add(Box.createVerticalStrut(20), BorderLayout.CENTER);

        // Create a text area for the system description
        JTextArea descriptionTextArea = new JTextArea("Welcome to AI MediCare! Your trusted health companion powered by Prolog. Get instant, personalized medical guidance tailored just for you."
                + "Let's embark on your journey to better health together.");
        descriptionTextArea.setFont(new Font("Patua one", Font.BOLD, 15));
        descriptionTextArea.setForeground(new Color(225, 247, 245));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setBackground(new Color(0, 0, 0, 0)); // Set background color with some transparency
        descriptionTextArea.setForeground(Color.WHITE); // Set text color to white
        descriptionTextArea.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20)); // Add padding
        backgroundPanel.add(descriptionTextArea, BorderLayout.CENTER); // Add the text area on top of the background color

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false); // Make the panel transparent

        // Create the first button
        JButton button1 = new JButton("Common Disease");
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setForeground(Color.WHITE); // Set text color to white
        button1.setBackground(new Color(14, 70, 163)); // Custom color
        button1.setFocusPainted(false); // Remove the border when focused
        button1.setBorderPainted(false); // Remove the border
        button1.setOpaque(true); // Make the button opaque
        button1.setPreferredSize(new Dimension(230, 70)); // Set button size
        button1.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add padding
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertsystem.Expertsystem.createAndShowGUI();
                dispose();
            }
        });
        buttonPanel.add(button1);

        // Create the second button
        JButton button2 = new JButton("Cancer Staus");
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.setForeground(Color.WHITE); // Set text color to white
        button2.setBackground(new Color(14, 70, 163)); // Custom color
        button2.setFocusPainted(false); // Remove the border when focused
        button2.setBorderPainted(false); // Remove the border
        button2.setOpaque(true); // Make the button opaque
        button2.setPreferredSize(new Dimension(230, 70)); // Set button size
        button2.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add padding
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertsystem.expertsystem2.createAndShowGUI2();
                dispose();
            }
        });
        buttonPanel.add(button2);

        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH); // Add the button panel on top of the background color

        // Add the backgroundPanel to the frame
        add(backgroundPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the WelcomeScreen GUI
        Query q1 = new Query("consult", new Term[]{new org.jpl7.Atom("expertsystem.pl")});
        System.out.println("Prolog consult " + (q1.hasSolution() ? "succeeded." : "failed."));
        
        Query q2 = new Query("consult", new Term[]{new org.jpl7.Atom("expertsystem2.pl")});
        System.out.println("Prolog consult " + (q2.hasSolution() ? "succeeded." : "failed."));
        
        new welcomescreen();
    }
}
