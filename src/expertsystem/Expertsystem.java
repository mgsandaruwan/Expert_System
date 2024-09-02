/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package expertsystem;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jpl7.Query;
import org.jpl7.Term;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.Border;

public class Expertsystem {

    private static JFrame frame;
    private static List<String> patientSymptoms = new ArrayList<>();
    private static String[] allSymptoms = {"fever", "cough", "headache", "nausea", "sneezing", "sore_throat", "vomiting", "diarrhea","chest_pain","runny_nose",
    "difficulty_swallowing","ear_pain","hearing_loss","abdominal_pain","shortness_of_breath","sweating"};
    private static int currentSymptomIndex = 0;

    public static void main(String[] args) {
        // Initialize Prolog
        Query q1 = new Query("consult", new Term[]{new org.jpl7.Atom("expertsystem.pl")});
        System.out.println("Prolog consult " + (q1.hasSolution() ? "succeeded." : "failed."));
        
        Query q2 = new Query("consult", new Term[]{new org.jpl7.Atom("expertsystem2.pl")});
        System.out.println("Prolog consult " + (q2.hasSolution() ? "succeeded." : "failed."));

        javax.swing.SwingUtilities.invokeLater(Expertsystem::createAndShowGUI);
    }

public static void createAndShowGUI() {
    frame = new JFrame("Medical Expert System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Set the frame size to match the image size
    frame.setSize(670, 360);

    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Load the background image
            g.setColor(new Color(30, 3, 66)); // Dodger Blue color
                g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    panel.setLayout(new BorderLayout()); // Set BorderLayout to allow centering of components
    frame.add(panel);
    layoutComponents(panel);

    frame.setVisible(true);
}


private static void layoutComponents(JPanel panel) {
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(Color.BLACK);
    
    JLabel nameLabel1 = new JLabel("<html><center>AI MediCare</center></html");
    nameLabel1.setFont(new Font("Gagalin", Font.BOLD, 50));
    nameLabel1.setForeground(new Color(14, 70, 163)); // Set text color to custom color
    nameLabel1.setHorizontalAlignment(JLabel.CENTER);
    nameLabel1.setVerticalAlignment(SwingConstants.CENTER);

    JLabel descriptionLabel = new JLabel("<html><center><font face='Comic Sans MS' size='4'>This medical expert system defines a simple symptom and disease matching system. "
            + "It starts with a list of symptoms and diseases with their associated symptoms. It then provides predictions to check whether a set of symptoms "
            + "exactly matches a particular disease, and to identify a list of patient symptoms by finding matching diseases.\n" +
"Symptoms for these diseases (flu, common cold, stomach bug, pneumonia, tonsillitis, ear infection, appendicitis, heart attack) have been presented here.</font></center></html>");
    descriptionLabel.setForeground(Color.WHITE);
    
    JLabel nameLabel = new JLabel("<html><b>What is your Name</b></html>");
    nameLabel.setForeground(Color.white); // Changing text color
    nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
    
    JTextField nameField = new JTextField();
    JButton startButton = new JButton("start diagnosing");
    startButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15)); // Changing text size
    startButton.setForeground(Color.WHITE); // Set text color to white
    startButton.setBackground(new Color(14, 70, 163)); // Change button color to red
    startButton.setPreferredSize(new Dimension(250, 20)); // Set preferred size for button

    
    // Set preferred size for the text field
    nameField.setMaximumSize(new Dimension(500, nameField.getPreferredSize().height));
    
    panel.add(nameLabel1);
    panel.add(Box.createVerticalStrut(10)); // Adding vertical space
    panel.add(descriptionLabel);
    panel.add(Box.createVerticalStrut(30)); // Adding vertical space
    panel.add(nameLabel);
    panel.add(nameField);
    panel.add(Box.createVerticalStrut(10)); // Adding vertical space
    panel.add(startButton);

    startButton.addActionListener(e -> {
        patientSymptoms.clear(); // Clear previous symptoms
        currentSymptomIndex = 0;
        showNextSymptom(panel, nameField.getText(), nameField);
    }
    
    );
    
}

    private static void showNextSymptom(JPanel panel, String patientName, JTextField nameField) {
    if (currentSymptomIndex >= allSymptoms.length) {
        // Done gathering symptoms, show diagnosis
        displayDiagnosis(panel, patientName);
        return;
    }

    String symptom = allSymptoms[currentSymptomIndex];
    JLabel descriptionLabel = new JLabel("<html><font face='Comic Sans MS' color='#87C4FF' size='8' >" + nameField.getText() + ", </font><font face='Comic Sans MS' size='8'>do you also have these symptoms?</font></html>");
    descriptionLabel.setForeground(Color.WHITE);
    JLabel symptomLabel = new JLabel("<html>do you have a " + "<font color='red' size='15'>" + symptom + "</font>?</html>");
    
    // Set text color and font style for "Do you have"
    symptomLabel.setForeground(Color.white); // Example: change to red
    Font labelFont = symptomLabel.getFont();
    symptomLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 23));

    JButton yesButton = new JButton("Yes");
    yesButton.setFont(new Font("Comic Sans MS", Font.BOLD, 26)); // Changing text size
    yesButton.setForeground(new Color(30,3,66)); // Set text color to white
    yesButton.setPreferredSize(new Dimension(200, 20)); // Set preferred size for button

    JButton noButton = new JButton("No ");
    noButton.setFont(new Font("Comic Sans MS", Font.BOLD, 26)); // Changing text size
    noButton.setForeground(new Color(30,3,66)); // Set text color to white
    noButton.setPreferredSize(new Dimension(200, 20)); // Set preferred size for button

    yesButton.addActionListener(e -> {
        patientSymptoms.add(symptom);
        panel.removeAll();
        currentSymptomIndex++;
        showNextSymptom(panel, patientName, nameField); // Show next symptom
    });

    noButton.addActionListener(e -> {
        currentSymptomIndex++;
        showNextSymptom(panel, patientName, nameField); // Show next symptom
    });
    
    
    // Set preferred size for buttons
    yesButton.setPreferredSize(new Dimension(300, 40)); // Set width to 100 and height to 40
    noButton.setPreferredSize(new Dimension(100, 40)); // Set width to 100 and height to 40

    // Set background colors for buttons
    yesButton.setBackground(new Color(154, 200, 205)); // #790b1b
    noButton.setBackground(new Color(225, 247, 245)); // #caa2ac

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Set layout to vertical BoxLayout
    panel.removeAll();
    panel.add(descriptionLabel);
    panel.add(symptomLabel);
    panel.add(Box.createVerticalStrut(20)); // Adding vertical space
    panel.add(yesButton);
    panel.add(Box.createVerticalStrut(20)); // Adding vertical space
    panel.add(noButton);
    panel.revalidate();
    panel.repaint();
}


private static void displayDiagnosis(JPanel panel, String patientName) {
    String query = "diagnose([" + String.join(",", patientSymptoms) + "], Diseases).";
    Query q1 = new Query(query);
    java.util.Map<String, Term>[] solutions = q1.allSolutions();

    List<String> diseases = new ArrayList<>();
    for (java.util.Map<String, Term> solution : solutions) {
        Term diseaseTerm = solution.get("Diseases");
        String disease = diseaseTerm.toString();
        diseases.add(disease);
    }

    StringBuilder diseasesText = new StringBuilder();
    for (String disease : diseases) {
    diseasesText.append("<br>").append("<font color='red' size='30'>").append(disease).append("</font>");
}
    
    

JLabel diagnosisLabel = new JLabel("<html><font face='Comic Sans MS' size='8'>Based on the symptoms, " + patientName + " you may have:" + diseasesText.toString() + "</html>");
diagnosisLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20)); // Changing text size
diagnosisLabel.setForeground(Color.WHITE);
panel.removeAll();
panel.add(diagnosisLabel);
panel.revalidate();
panel.repaint();
    JButton homeButton = new JButton("Home");
    homeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
    homeButton.setForeground(Color.WHITE);
    homeButton.setBackground(new Color(14, 70, 163));
   // homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
       homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new welcomescreen();
                
            }
        });
    panel.add(Box.createVerticalGlue()); // Add vertical glue to push the home button to the bottom
    panel.add(homeButton);
}

    static void welcomescreen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}