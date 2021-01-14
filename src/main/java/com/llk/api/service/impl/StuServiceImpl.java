package com.llk.api.service.impl;

import com.llk.api.dao.StuDao;
import com.llk.api.model.po.Student;
import com.llk.api.model.vo.StudentParams;
import com.llk.api.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuServiceImpl implements StuService {

    @Resource
    private StuDao stuDao;


    @Override
    public void addStudent(Student stu) {
        stuDao.addStudent(stu);
    }

    @Override
    public Map queryStudentData(StudentParams params) {
        //业务处理
        Map rs = new HashMap();
        Integer count = stuDao.queryDataCount(params);
        rs.put("count",count);
        //list
        List<Student> stus = stuDao.queryListDataByParams(params);
        rs.put("list",stus);
        return rs;
    }

    @Override
    public void delStu(Integer id) {
        stuDao.delStu(id);
    }

    @Override
    public Student queryDataById(Integer id) {
        return stuDao.queryDataById(id);
    }

    @Override
    public void updateStu(Student stu) {
        stuDao.updateStu(stu);
    }
}
/*//业务处理
        Map rs=new HashMap();
        //count
        Integer count = studentDao.queryDataCount(params);
        rs.put("count",count);
        //list
        List<Student> students = studentDao.queryListDataByParams(params);
        rs.put("list",students);
        return rs;*/