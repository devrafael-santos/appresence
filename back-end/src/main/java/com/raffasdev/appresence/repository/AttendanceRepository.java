package com.raffasdev.appresence.repository;

import com.raffasdev.appresence.domain.Attendance;
import com.raffasdev.appresence.domain.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
}
