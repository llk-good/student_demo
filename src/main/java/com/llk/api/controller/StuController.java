package com.llk.api.controller;

import com.llk.api.model.po.Student;
import com.llk.api.model.vo.ResultData;
import com.llk.api.model.vo.StudentParams;
import com.llk.api.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/stu/")
@CrossOrigin//添加一个跨域的注解
public class StuController {

    @Autowired
    private StuService stuService;

// 路径为  api/student/add
    // 请求方式为 post
    // 请求参数
    // name （必传的）
    // age (可选的)
    // sex
    //  birthday（yyyy-MM-dd）
    //返回值  {"code":"","message":"","data":""}  code 200处理成功  500处理失败  （失败原因  message）  data响应数据
    // javabean 和json如何互转的

    @PostMapping("add")
    private Map addStudent(Student stu){
        Map map = new HashMap();
        if (StringUtils.isEmpty(stu.getName())){
            map.put("code",500);
            map.put("message","数据不合法");
            map.put("data","");
            return  map;
        }
        //业务处理
        stuService.addStudent(stu);
        map.put("code",200);
        map.put("message","success");
        map.put("data","");
        return  map;
    }


// 路径为  api/student/list
    // 请求方式为 get
    // 请求参数
    // start （必传的）
    // size (必传的)
    // name
    //  birthdaymin（yyyy-MM-dd）
    //  birthdaymax（yyyy-MM-dd）
    //agemin
    //agemax
    //返回值  {"code":"","message":"","data":{list:[{"id":1,"name":"",age:"",sex:":},{},{}],count:5}}  code 200处理成功  500处理失败  （失败原因  message）  data响应数据
    @PostMapping("list")
    private Map queryStudentData(StudentParams params){
        Map map = new HashMap();
        if (params.getSize() == null){
            map.put("code",500);
            map.put("message","参数不合法");
            map.put("data","");
            return map;//程序遇到return 到此结束
        }
        if (params.getStart() == null){
            map.put("code",500);
            map.put("message","参数不合法");
            map.put("data","");
            return map;//程序遇到return 到此结束
        }

        Map list = stuService.queryStudentData(params);
        map.put("code",200);
        map.put("message","success");
        map.put("data",list);
        return map;
    }



    /*
    * 删除
    *
    * @GetMapping("delBook")
    * */
    @DeleteMapping("delStu")
    public ResultData delStu(Integer id){
        if (id==null){
            return ResultData.error(400,"数据不合法");
        }
        stuService.delStu(id);
        return ResultData.success("");
    }

    /*
    *
    * 回显
    *
    * GetMapping
    * */
    @GetMapping("ById")
    public ResultData queryDataById(Integer id){
        if (id==null){
            return ResultData.error(400,"数据不合法");
        }
        Student stu = stuService.queryDataById(id);
        return ResultData.success(stu);
    }

    /*
    * 修改
    *postMappi
    * */
    @PostMapping("update")
    public ResultData updateStu(Student stu){
        stuService.updateStu(stu);
        return ResultData.success("");
    }
}
