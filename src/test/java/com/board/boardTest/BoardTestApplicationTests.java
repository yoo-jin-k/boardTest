package com.board.boardTest;

import com.board.boardTest.persistence.NoticeSaveDTO;
import com.board.boardTest.persistence.dto.entity.Notice;
import com.board.boardTest.repsitory.NoticeRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardTestApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	NoticeRepository noticeRepository;

	@After
	public void tearDown() throws Exception {
		noticeRepository.deleteAll();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void noticeAll() {
		String title = "테스트 title";
		String content = "테스트 content";

		NoticeSaveDTO noticeSaveDTO = NoticeSaveDTO.builder()
				.title(title)
				.content(content)
				.author("author")
				.build();
		String url = "http://localhost:" + port + "/api/notice";

		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, noticeSaveDTO, Long.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);

		List<Notice> all = noticeRepository.findAll();
		assertThat(all.get(0).getTitle()).isEqualTo(title);
		assertThat(all.get(0).getContent()).isEqualTo(content);


//		noticeRepository.save(Notice.builder()
//				.title(title)
//				.content(content)
//				.author("author@gmail.com")
//				.build());
//
//		List<Notice> noticeList = noticeRepository.findAll();
//
//		Notice notice = noticeList.get(0);
//		assertThat(notice.getTitle()).isEqualTo(title);
//		assertThat(notice.getContent()).isEqualTo(content);
	}

}
