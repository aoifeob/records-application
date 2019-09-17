package com.example.records.controller;

import com.example.records.model.Record;
import com.example.records.model.RecordDTO;
import com.example.records.service.RecordsService;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

  private RecordsService recordsService;

  @Autowired
  public PageController(RecordsService recordsService) {
    this.recordsService = recordsService;
  }

  @GetMapping(value = "")
  public String getHomepage() {
    return "index";
  }

  @GetMapping(value = "/add-record")
  public String getAddRecordPage(Model model) {
    model.addAttribute("record", new RecordDTO());
    return "add-record";
  }

  @PostMapping(value = "/add-record")
  public String saveStudent(@ModelAttribute("record") RecordDTO recordDTO, BindingResult errors,
      Model model) {
    if (recordsService.addedRecord(recordDTO)) {
      return getListRecordsPage(model);
    }
    return "error";
  }

  @GetMapping(value = "/list-records")
  public String getListRecordsPage(Model model) {
    model.addAttribute("records", recordsService.listRecords());
    return "list-records";
  }

}
