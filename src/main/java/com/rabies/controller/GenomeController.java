package com.rabies.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rabies.pojo.Genome;
import com.rabies.pojo.User;
import com.rabies.service.GenomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class GenomeController {

    @Autowired
    private GenomeService genomeService;

    // 分页查询方法
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/listGenomePage")  // 定义了一个Get请求接口
    public HashMap<String, Object> listGenomePage(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize,
        @RequestParam(required = false) String accession,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) String refinedHost){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<Genome> genomes = genomeService.listByAccessionAndCountryAndHost(accession, country, refinedHost);
        // PageInfo是PageHelper提供的工具类，在这里用于封装users的信息
        PageInfo<Genome> pageInfo = new PageInfo<>(genomes);
        // 创建了一个空的HashMap，用于封装返回给前端的数据
        HashMap<String, Object> result = new HashMap<>();
        // 把分页后的用户列表存入result中的data键中(这部分数据用于渲染表格)
        result.put("data", pageInfo.getList());
        // 把用户总记录数存入result中的total键中(这部分数据用来计算页数)
        result.put("total", pageInfo.getTotal());
        return result;
    }
}
