package com.zensar.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data

public class CustomMadeExceptions {
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
//global and other exception handlers not needed as this works	

}
