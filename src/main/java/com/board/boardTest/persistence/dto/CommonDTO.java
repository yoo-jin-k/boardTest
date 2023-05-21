package com.board.boardTest.persistence.dto;

import java.time.LocalDateTime;

public class CommonDTO {

	/** 삭제 여부 */
	private String deleteYn;

	/** 등록일 */
	private LocalDateTime insertTime;

	/** 수정일 */
	private LocalDateTime updateTime;

	/** 삭제일 */
	private LocalDateTime deleteTime;

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public LocalDateTime getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(LocalDateTime insertTime) {
		this.insertTime = insertTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}

	

}
