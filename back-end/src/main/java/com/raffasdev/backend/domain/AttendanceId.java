package com.raffasdev.backend.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
public class AttendanceId implements Serializable {
    private LocalDate classDate;
    private UUID studentId;

    public AttendanceId(LocalDate classDate, UUID studentId) {
        this.classDate = classDate;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceId that = (AttendanceId) o;
        return Objects.equals(classDate, that.classDate) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classDate, studentId);
    }
}
