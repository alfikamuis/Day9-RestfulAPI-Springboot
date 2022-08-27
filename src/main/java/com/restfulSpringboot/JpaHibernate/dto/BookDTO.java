package com.restfulSpringboot.JpaHibernate.dto;

import java.time.LocalDate;

public record BookDTO(Long id, Long studentId, String bookName, LocalDate createdAt) {
}
