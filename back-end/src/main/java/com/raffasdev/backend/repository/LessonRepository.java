package com.raffasdev.backend.repository;

import com.raffasdev.backend.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LessonRepository extends JpaRepository<Lesson, LocalDate> {
}
