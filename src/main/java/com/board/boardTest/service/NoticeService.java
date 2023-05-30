package com.board.boardTest.service;

import com.board.boardTest.persistence.NoticeSaveDTO;
import com.board.boardTest.repsitory.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public Long save(NoticeSaveDTO noticeSaveDTO) {
        return noticeRepository.save(noticeSaveDTO.toEntity()).getId();
    }
}
