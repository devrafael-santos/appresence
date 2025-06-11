package com.raffasdev.appresence.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
public class AttendanceId implements Serializable {
    private LocalDate lessonDate;
    private UUID studentId;

    public AttendanceId(LocalDate lessonDate, UUID studentId) {
        this.lessonDate = lessonDate;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceId that = (AttendanceId) o;
        return Objects.equals(lessonDate, that.lessonDate) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonDate, studentId);
    }
}
