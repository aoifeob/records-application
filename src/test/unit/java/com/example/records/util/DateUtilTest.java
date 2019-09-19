package com.example.records.util;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
public class DateUtilTest {

  @Autowired
  private DateUtil dateUtil;

  @Test
  public void testFormatDate() throws Exception {
    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
    assertEquals("01/01/1999", dateUtil.formatDate(date));
  }

  @Test
  public void testConvertToLocalDate() throws Exception {
    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
    LocalDate localDate = dateUtil.convertToLocalDate(date);
    assertEquals(1, localDate.getDayOfMonth());
    assertEquals(1, localDate.getMonthValue());
    assertEquals(1999, localDate.getYear());
  }

}
