package com.pace.university.CSGraduateStudents.Controller;


import com.pace.university.CSGraduateStudents.Model.CSGradStudent;
import com.pace.university.CSGraduateStudents.Model.EmptyJsonBody;
import com.pace.university.CSGraduateStudents.Service.CSGradStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@Controller
public class CSGradStudentsController {

    @Autowired
    private CSGradStudentService csGradStudentService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String root(){
        return "index";
    }

    @RequestMapping(value="/students", method = RequestMethod.GET)
    public ResponseEntity<List<CSGradStudent>> getStudents(){
        List<CSGradStudent> csGradStudentList = this.csGradStudentService.getAllStudents();
        return new ResponseEntity<>(csGradStudentList,HttpStatus.OK);
    }

    @RequestMapping(value="students/{id}", method = RequestMethod.GET)
    public ResponseEntity getStudentById(@PathVariable("id") int id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
        CSGradStudent student = this.csGradStudentService.getStudentByID(id);
        if(student == null){
            return responseBuilder.body(new EmptyJsonBody());
        }
        return responseBuilder.body(student);
    }

    @RequestMapping(value="students/{id}/courseRegistered", method = RequestMethod.GET)
    public ResponseEntity getCourseRegisteredById(@PathVariable("id") int id)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
        HashMap<String,String> courseRegistered = this.csGradStudentService.getCourseRegisteredById(id);
        if(courseRegistered == null){
            return responseBuilder.body(new EmptyJsonBody());
        }

        return responseBuilder.body(courseRegistered);

    }

    @RequestMapping(value="students/{id}/courseRegistered/{courseNumber}", method = RequestMethod.GET)
    public ResponseEntity getCourseName(@PathVariable("id") int id,@PathVariable("courseNumber") int courseNumber)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
        HashMap<String,String> courseName = this.csGradStudentService.getCourseName(id,courseNumber);
        if(courseName == null){
            return responseBuilder.body(new EmptyJsonBody());
        }
        return responseBuilder.body(courseName);

    }


 }



