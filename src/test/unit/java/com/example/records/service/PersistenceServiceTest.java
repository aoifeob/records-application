package com.example.records.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.example.records.model.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PersistenceServiceTest {

  @Autowired
  private PersistenceService persistenceService;

  @Test
  public void testPreCreateRecord() {
    Record record = Record.builder().build();
    assertNull(record.getCreateDate());
    persistenceService.preCreate(record);
    assertNotNull(record.getCreateDate());
  }

}
