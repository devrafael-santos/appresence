package com.raffasdev.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Lesson {

    @Id
    @Column(columnDefinition = "DATE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDate date;

}
