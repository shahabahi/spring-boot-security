package com.example.demo.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {


    //harRole('ROLE_')  hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getStudents() {
        return null;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentID) {
        System.out.println(studentID);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, Student student) {
        System.out.println(String.format("%s %s", studentId, student.toString()));
    }
}
