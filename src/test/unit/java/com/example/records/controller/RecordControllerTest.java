package com.example.records.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class RecordControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getIndexPage() throws Exception {
    mockMvc.perform(get(""))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
  }

  @Test
  public void getAddRecordPage() throws Exception {
    mockMvc.perform(get("/add-record"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(view().name("add-record"));
  }

  @Test
  public void getListRecordsPage() throws Exception {
    mockMvc.perform(get("/list-records"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(view().name("list-records"));
  }
}
