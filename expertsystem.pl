% Extended symptoms and diseases with simple severity scoring
symptom1(fever).
symptom1(cough).
symptom1(headache).
symptom1(nausea).
symptom1(sneezing).
symptom1(sore_throat).
symptom1(vomiting).
symptom1(diarrhea).
symptom1(chest_pain).
symptom1(shortness_of_breath).
symptom1(difficulty_swallowing).
symptom1(ear_pain).
symptom1(hearing_loss).
symptom1(abdominal_pain).
symptom1(shortness_of_breath).
symptom1(sweating).
symptom1(runny_nose).

% Diseases with their symptoms
disease1(flu, [fever, cough, headache]).
disease1(common_cold, [cough, sneezing, sore_throat]).
disease1(stomach_bug, [nausea, vomiting, diarrhea]).
disease1(pneumonia, [fever, cough, chest_pain, shortness_of_breath]).
disease1(tonsillitis, [sore_throat, fever, difficulty_swallowing]).
disease1(ear_infection, [ear_pain, fever, hearing_loss]).
disease1(appendicitis, [abdominal_pain, nausea, vomiting, fever]).
disease1(heart_attack, [chest_pain, shortness_of_breath, nausea, sweating]).
disease1(gastroenteritis, [nausea, vomiting, diarrhea, abdominal_pain]).
disease1(sinusitis, [headache, fever, cough, sore_throat, sneezing]).
disease1(bronchitis, [cough, fever, shortness_of_breath, chest_pain]).
disease1(laryngitis, [cough, sore_throat, difficulty_swallowing]).
disease1(influenza, [fever, cough, headache, nausea, vomiting]).
disease1(whooping_cough, [cough, sneezing, runny_nose, fever]).
disease1(food_poisoning, [nausea, vomiting, diarrhea, abdominal_pain, fever]).
disease1(gallstones, [abdominal_pain, nausea, vomiting, fever, sweating]).
disease1(acute_otitis_media, [ear_pain, fever, difficulty_swallowing, hearing_loss]).



% Checks if a patient's symptoms match a disease exactly
matches_disease(Disease, PatientSymptoms) :-
    disease1(Disease, RequiredSymptoms),
    permutation(RequiredSymptoms, PatientSymptoms). % Check for exact match

% Given a list of patient symptoms, find matching diseases
diagnose(PatientSymptoms, Diseases) :-
    findall(Disease, matches_disease(Disease, PatientSymptoms), Diseases).
