package com.example.records.controller;

import com.example.records.model.Person;
import com.example.records.service.RecordsService;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/record")
@Slf4j
public class RecordController {

  private RecordsService recordsService;

  @Autowired
  public RecordController(RecordsService recordsService){
    this.recordsService = recordsService;
  }

  @ApiOperation(value = "Add a new record", produces = MediaType.APPLICATION_JSON_VALUE)
  @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addRecord(@RequestBody @Valid Person person, BindingResult result){
    try {
//      if (result.hasErrors()){
//        List<CustomError> errors = buildValidationResponse(result);
//        return ResponseEntity.unprocessableEntity().body(errors);
//      }
      recordsService.addRecord(person);
      return ResponseEntity.ok().build();
    } catch (Exception e){
      log.error("Error adding record: ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @ApiOperation(value = "Get all person records", produces = MediaType.APPLICATION_JSON_VALUE)
  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity listRecords(){
    return recordsService.listRecords();
  }

//  private List<CustomError> buildValidationResponse(BindingResult result) {
//    List<CustomError> errorList = result.getAllErrors().stream()
//        .map(e -> new CustomError((e instanceof FieldError?((FieldError)e).getField():""), e.getDefaultMessage()))
//        .filter(e -> !e.getField().isEmpty())
//        .collect(Collectors.toList());
//    ValidationErrorSortingService.sortErrors(errorList);
//    return errorList;
//  }

}

