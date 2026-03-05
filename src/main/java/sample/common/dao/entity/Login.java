package sample.common.dao.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Login {
	private Long id;
	private String username;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
