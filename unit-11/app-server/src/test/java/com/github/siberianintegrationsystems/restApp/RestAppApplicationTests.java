package com.github.siberianintegrationsystems.restApp;

import com.github.siberianintegrationsystems.restApp.controller.JournalRestController;
import com.github.siberianintegrationsystems.restApp.controller.QuestionRestController;
import com.github.siberianintegrationsystems.restApp.controller.SessionRestController;
import com.github.siberianintegrationsystems.restApp.data.*;
import com.github.siberianintegrationsystems.restApp.service.JournalService;
import com.github.siberianintegrationsystems.restApp.service.QuestionService;
import com.github.siberianintegrationsystems.restApp.service.SessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAppApplicationTests{
	private final JournalService journalService;
	private final QuestionService questionService;
	private final SessionService sessionService;
	private final SessionRestController sessionRestController;
	private final QuestionRestController questionRestController;
	private final JournalRestController journalRestController;
	private final SessionRepository sessionRepository;
	private final QuestionRepository questionRepository;
	private final JournalRepository journalRepository;
	private final AnswerRepository answerRepository;
	private final SelectedAnswerRepository selectedAnswerRepository;

	public RestAppApplicationTests(JournalService journalService,
								   QuestionService questionService,
								   SessionService sessionService,
								   SessionRestController sessionRestController,
								   QuestionRestController questionRestController,
								   JournalRestController journalRestController,
								   SessionRepository sessionRepository,
								   QuestionRepository questionRepository,
								   JournalRepository journalRepository,
								   AnswerRepository answerRepository,
								   SelectedAnswerRepository selectedAnswerRepository) {
		this.journalService = journalService;
		this.questionService = questionService;
		this.sessionService = sessionService;
		this.sessionRestController = sessionRestController;
		this.questionRestController = questionRestController;
		this.journalRestController = journalRestController;
		this.sessionRepository = sessionRepository;
		this.questionRepository = questionRepository;
		this.journalRepository = journalRepository;
		this.answerRepository = answerRepository;
		this.selectedAnswerRepository = selectedAnswerRepository;
	}

	@Test
	public void contextLoads() {
		assertNotNull(journalService);
		assertNotNull(questionService);
		assertNotNull(sessionService);
		assertNotNull(journalRestController);
		assertNotNull(questionRestController);
		assertNotNull(sessionRestController);
		assertNotNull(answerRepository);
		assertNotNull(journalRepository);
		assertNotNull(questionRepository);
		assertNotNull(selectedAnswerRepository);
		assertNotNull(sessionRepository);
	}

}
