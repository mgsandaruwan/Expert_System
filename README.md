# Disease Prediction Java Application

## About the Project

The Disease Prediction Java Application uses an innovative approach to predict common diseases and cancer status based on the symptoms provided by the user. By leveraging a **Prolog-based knowledge base**, the application analyzes the user's symptoms and predicts the most likely disease or medical condition.

This project is designed to assist individuals in understanding their symptoms and identifying possible health concerns, promoting early diagnosis and timely intervention.

## Key Features

- **Symptom-based Prediction:** Users can enter their symptoms, and the application predicts the most likely disease or condition based on a Prolog knowledge base.
- **Cancer Status Detection:** The application specifically predicts cancer-related conditions based on the symptoms provided by the user.
- **User-Friendly Interface:** A simple and intuitive Java-based GUI makes it easy for users to input symptoms and view predictions.
- **Prolog Knowledge Base Integration:** The core of the application is powered by a Prolog knowledge base, which contains a structured set of rules and facts for disease prediction.

## How It Works

1. **Symptom Input:** The user provides a list of symptoms.
2. **Knowledge Base Query:** The Java application queries the Prolog knowledge base, which contains predefined rules to match symptoms with diseases.
3. **Disease Prediction:** Based on the symptoms entered, the application returns a list of possible diseases or medical conditions.
4. **Cancer Prediction:** The system specifically predicts whether the user might be at risk for cancer, based on symptoms indicative of cancer-related conditions.

## Technologies Used

- **Java**: For developing the application and its user interface.
- **Prolog**: For the knowledge base that stores and processes the rules for disease prediction.
- **Swing**: For the graphical user interface (GUI) to input symptoms and display results.
- **JPL (Java-Prolog Interface)**: Used to connect Java with the Prolog knowledge base.

## Installation

To run this project, you need to set up the following:

1. **Java Development Kit (JDK)**: Install JDK 8 or later.
2. **SWI-Prolog**: Download and install SWI-Prolog from [here](https://www.swi-prolog.org/Download).
3. **JPL Library**: Install the JPL library, which allows Java to interface with Prolog.
   - You can find installation instructions for JPL [here](https://www.swi-prolog.org/Download.html).

