package com.example.records.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.records.model.Record;
import com.example.records.model.RecordDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class RecordFactoryTest {

  @Autowired
  private RecordFactory recordFactory;

  @Test
  public void testTransformRecordDTOWithPhone() throws Exception {
    RecordDTO recordDTO = new RecordDTO();
    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
    recordDTO.setName("Bob Test");
    recordDTO.setPpsn("123456789T");
    recordDTO.setDateOfBirth(date);
    recordDTO.setPhone("081234567");
    Record record = recordFactory.transformRecordDTO(recordDTO);
    assertEquals("Bob Test", record.getName());
    assertEquals("123456789T", record.getPpsn());
    assertEquals("01/01/1999", record.getDateOfBirth());
    assertEquals("081234567", record.getPhone());
  }

  @Test
  public void testTransformRecordDTOWithoutPhone() throws Exception {
    RecordDTO recordDTO = new RecordDTO();
    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
    recordDTO.setName("Bob Test");
    recordDTO.setPpsn("123456789T");
    recordDTO.setDateOfBirth(date);
    Record record = recordFactory.transformRecordDTO(recordDTO);
    assertEquals("Bob Test", record.getName());
    assertEquals("123456789T", record.getPpsn());
    assertEquals("01/01/1999", record.getDateOfBirth());
    assertNull(record.getPhone());
  }

}
