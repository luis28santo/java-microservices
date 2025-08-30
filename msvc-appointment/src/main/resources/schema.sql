CREATE TABLE appointment (
    id SERIAL PRIMARY KEY,
    patient_id INTEGER NOT NULL,
    doctor VARCHAR(100),
    appointment_date DATE NOT NULL,   -- solo la fecha (ej: 2025-08-26)
    appointment_time TIME NOT NULL,   -- solo la hora (ej: 14:30:00)
    status SMALLINT NOT NULL DEFAULT 3, -- 0: CANCELLED, 1: COMPLETED, 2: CONFIRMED, 3: PENDING
    reason VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);