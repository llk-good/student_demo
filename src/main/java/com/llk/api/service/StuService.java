package com.llk.api.service;

import com.llk.api.model.po.Student;
import com.llk.api.model.vo.StudentParams;

import java.util.Map;

public interface StuService {
    void addStudent(Student stu);

    Map queryStudentData(StudentParams params);

    void delStu(Integer id);

    Student queryDataById(Integer id);

    void updateStu(Student stu);
}
