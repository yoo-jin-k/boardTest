package com.board.boardTest.repsitory;

import com.board.boardTest.persistence.dto.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
