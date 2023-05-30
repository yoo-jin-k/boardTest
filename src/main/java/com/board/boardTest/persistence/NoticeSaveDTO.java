package com.board.boardTest.persistence;

import com.board.boardTest.persistence.dto.entity.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeSaveDTO {
    private String title;
    private String content;
    private String author;

    @Builder
    public NoticeSaveDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
