package com.raffasdev.appresence.repository;

import com.raffasdev.appresence.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LessonRepository extends JpaRepository<Lesson, LocalDate> {
}
