
-- 0: CANCELLED, 1: COMPLETED, 2: CONFIRMED, 3: PENDING

INSERT INTO appointment
(patient_id, doctor, appointment_date, appointment_time, status, reason)
VALUES
(1, 'Dr. Juan Pérez', '2025-09-01', '09:30:00', 2, 'Consulta general'),
(2, 'Dra. Ana Torres', '2025-09-02', '15:00:00', 3, 'Chequeo anual'),
(3, 'Dr. Luis García', '2025-09-03', '11:15:00', 1, 'Control post-operatorio'),
(4, 'Dra. Sofía Mendoza', '2025-09-05', '16:45:00', 0, 'Cancelación por paciente');