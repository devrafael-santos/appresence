package com.raffasdev.backend.repository;

import com.raffasdev.backend.domain.Attendance;
import com.raffasdev.backend.domain.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
}
