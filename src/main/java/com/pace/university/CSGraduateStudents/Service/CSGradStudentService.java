package com.pace.university.CSGraduateStudents.Service;

import com.pace.university.CSGraduateStudents.Model.CSGradStudent;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.*;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;

@Service
public class CSGradStudentService {

    private List<CSGradStudent> csGradStudentList;

    @PostConstruct
    public void generateStudentList(){
        try{
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("student_database.json");
        String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();

            CSGradStudent[] csGradStudent = objectMapper.readValue(content, CSGradStudent[].class);
            this.csGradStudentList = Arrays.asList(csGradStudent);
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public List<CSGradStudent> getAllStudents() {
            return this.csGradStudentList;
    }

    public CSGradStudent getStudentByID(int id){
            for(CSGradStudent student:this.csGradStudentList){
                if(student.getId() == id){
                    return student;
                }
            }

        return null;
    }

    public HashMap<String,String> getCourseRegisteredById(int id){
            for(CSGradStudent student:this.csGradStudentList){
                if(student.getId() == id){
                    return student.getCourseRegistered();
                }
            }
        return null;
    }

    public String getCourseName(int id, int courseNumber){
            for(CSGradStudent student:this.csGradStudentList){
                if(student.getId() == id){
                    return student.getCourseRegistered().get(Integer.toString(courseNumber));
                }
            }
        return null;
    }



}
