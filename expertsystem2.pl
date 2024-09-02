
% Symptoms commonly associated with cancer
symptom(unexplained_weight_loss).
symptom(fatigue).
symptom(persistent_pain).
symptom(changes_in_bowel_bladder_habits).
symptom(persistent_cough_or_hoarseness).
symptom(changes_in_moles_or_skin_lesions).
symptom(unexplained_bleeding_or_bruising).
symptom(difficulty_swallowing_or_indigestion).
symptom(lumps_or_swelling).

% Diseases related to cancer
disease(lung_cancer, [persistent_cough_or_hoarseness, unexplained_weight_loss, persistent_pain]).
disease(breast_cancer, [lumps_or_swelling, changes_in_moles_or_skin_lesions, unexplained_bleeding_or_bruising]).
disease(colorectal_cancer, [changes_in_bowel_bladder_habits, unexplained_weight_loss, persistent_pain, unexplained_bleeding_or_bruising]).


% Checks if a patient's symptoms match a disease exactly
matches_cancer(Disease, PatientSymptoms) :-
    disease(Disease, RequiredSymptoms),
    permutation(RequiredSymptoms, PatientSymptoms). % Check for exact match

% Given a list of patient symptoms, find matching cancer types
diagnose_cancer(PatientSymptoms, CancerTypes) :-
    findall(Disease, matches_cancer(Disease, PatientSymptoms), CancerTypes).


