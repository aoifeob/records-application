package com.example.records.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.example.records.model.Record;
import com.example.records.model.RecordDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class RecordServiceTest {

  @Autowired
  private RecordService recordService;

  @Test
  public void testAddRecord() throws Exception {
    assertTrue(recordService.listRecords().isEmpty());

    RecordDTO recordDTO = new RecordDTO();
    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
    recordDTO.setName("Bob Test");
    recordDTO.setPpsn("123456789T");
    recordDTO.setDateOfBirth(date);
    recordDTO.setPhone("081234567");

    recordService.addRecord(recordDTO);

    assertEquals(1, recordService.listRecords().size());
    assertEquals("Bob Test", recordService.listRecords().get(0).getName());
    assertEquals("123456789T", recordService.listRecords().get(0).getPpsn());
    assertEquals("01/01/1999", recordService.listRecords().get(0).getDateOfBirth());
    assertEquals("081234567", recordService.listRecords().get(0).getPhone());
    assertNotNull(recordService.listRecords().get(0).getCreateDate());
  }

  @Test
  public void testListRecords() throws Exception {

    RecordDTO recordDTO = new RecordDTO();
    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
    recordDTO.setName("Bob Test");
    recordDTO.setPpsn("123456789T");
    recordDTO.setDateOfBirth(date);
    recordDTO.setPhone("081234567");
    recordService.addRecord(recordDTO);
    recordDTO.setPpsn("123456789U");
    recordService.addRecord(recordDTO);
    recordDTO.setPpsn("123456789V");
    recordService.addRecord(recordDTO);
    recordDTO.setPpsn("123456789W");
    recordService.addRecord(recordDTO);

    List<Record> recordList = recordService.listRecords();
    assertEquals("123456789T", recordList.get(0).getPpsn());
    assertTrue(recordList.get(0).getCreateDate().compareTo(recordList.get(1).getCreateDate()) < 0);
    assertEquals("123456789U", recordList.get(1).getPpsn());
    assertTrue(recordList.get(1).getCreateDate().compareTo(recordList.get(2).getCreateDate()) < 0);
    assertEquals("123456789V", recordList.get(2).getPpsn());
    assertTrue(recordList.get(2).getCreateDate().compareTo(recordList.get(3).getCreateDate()) < 0);
    assertEquals("123456789W", recordList.get(3).getPpsn());

  }

}
