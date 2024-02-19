package com.ammouri.school;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

  private final SchoolService service;
  @PostMapping(value = "/save")
  public ResponseEntity<?> saveSchool(@RequestBody School school){
    return  ResponseEntity.ok(service.saveSchool(school));
  }

  @GetMapping(value = "/getall")
  public ResponseEntity<List<School>> getAllSchools(){
    return ResponseEntity.ok(service.findAllSchools());
  }

  @GetMapping(value = "/school-with-students/{school-id}")
  public ResponseEntity<FullSchoolResponse> schoolWithStudents(@PathVariable("school-id") Long schoolId){
   return ResponseEntity.ok(this.service.findSchoolsWithStudents(schoolId));

  }

}
