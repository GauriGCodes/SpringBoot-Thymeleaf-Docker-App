package com.pace.university.CSGraduateStudents.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pace.university.CSGraduateStudents.Model.CSGradStudent;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.*;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,CSGradStudent> csGradStudents = objectMapper.readValue(content, new TypeReference<Map<String,CSGradStudent>>(){});
        this.csGradStudentList = new ArrayList<CSGradStudent>();
        this.csGradStudentList.addAll(csGradStudents.values());
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

    public HashMap<String,String> getCourseName(int id, int courseNumber){
            for(CSGradStudent student:this.csGradStudentList){
                if(student.getId() == id && student.getCourseRegistered().get(Integer.toString(courseNumber)) != null){
                    HashMap<String,String> course = new HashMap<>();
                    course.put(Integer.toString(courseNumber), student.getCourseRegistered().get(Integer.toString(courseNumber)));
                    return course;
                }
            }
        return null;
    }



}
