package sample.common.dao.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Task {
	private Long id;
	private String username;
	private String title;
	private String content;
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
