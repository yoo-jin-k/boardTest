package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.NoticeSaveDTO;
import com.board.boardTest.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public Long save(@RequestBody NoticeSaveDTO noticeSaveDTO) {
        return noticeService.save(noticeSaveDTO);
    }
}
