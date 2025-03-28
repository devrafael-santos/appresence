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
    @MapsId("lessonDate")
    @JoinColumn(name = "lesson_date")
    private Lesson lesson;

    private boolean present;

    public Attendance(Lesson lesson, Student student, boolean present) {
        this.id = new AttendanceId(lesson.getDate(), student.getId());
        this.lesson = lesson;
        this.student = student;
        this.present = present;
    }
}
