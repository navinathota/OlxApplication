package com.zensar.master.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MasterDto {
	private long id;
	private String category;
	private long statusId;
	private String status;
}
