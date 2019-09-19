package com.example.records.controller;

import com.example.records.model.RecordDTO;
import com.example.records.service.RecordService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class RecordController {

  private RecordService recordService;

  @Autowired
  public RecordController(RecordService recordService) {
    this.recordService = recordService;
  }

  @GetMapping(value = "")
  public String getIndexPage() {
    return "index";
  }

  @GetMapping(value = "/add-record")
  public String getAddRecordPage(Model model) {
    model.addAttribute("record", new RecordDTO());
    return "add-record";
  }

  @PostMapping(value = "/add-record")
  public String addRecord(@ModelAttribute("record") @Valid RecordDTO recordDTO,
      BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      return "add-record";
    }
    try {
      recordService.addRecord(recordDTO);
    } catch (Exception e) {
      log.error("Error adding record ", e);
    }
    return getListRecordsPage(model);
  }

  @GetMapping(value = "/list-records")
  public String getListRecordsPage(Model model) {
    model.addAttribute("records", recordService.listRecords());
    return "list-records";
  }

}
