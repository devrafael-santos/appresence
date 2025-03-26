package com.raffasdev.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Attendance {
    @EmbeddedId
    private AttendanceId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("classDate")
    @JoinColumn(name = "class_date")
    private Class class_;

    private boolean present;

    public Attendance(Class class_, Student student, boolean present) {
        this.id = new AttendanceId(class_.getDate(), student.getId());
        this.class_ = class_;
        this.student = student;
        this.present = present;
    }
}
