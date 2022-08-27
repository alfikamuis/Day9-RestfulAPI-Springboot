package com.restfulSpringboot.JpaHibernate.dto;

import java.time.LocalDate;

public record BookDTO(Long id, StudentDTO studentId, String bookName, LocalDate createdAt) {
}
