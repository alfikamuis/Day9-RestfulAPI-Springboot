package com.restfulSpringboot.JpaHibernate.dto;

import java.time.LocalDate;

public record StudentDTO(Long id, String name, String email, short age, LocalDate createdAt) {
}
