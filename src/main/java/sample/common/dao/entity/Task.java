package sample.common.dao.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Task {
	private Long id;
	private String username;
	private String title;
	private String content;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
