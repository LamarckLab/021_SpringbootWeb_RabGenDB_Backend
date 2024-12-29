package com.rabies.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rabies.pojo.Genome;
import com.rabies.service.GenomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class GenomeController {

    @Autowired
    private GenomeService genomeService;

    // 这个接口用于实现: 向genome表中增加一条序列
    @CrossOrigin
    @PostMapping("/sequenceSave")
    public boolean sequenceSave(@RequestBody Genome genome){
        return genomeService.sequenceSave(genome);
    }

    // 这个接口用于实现：审核通过时修改genome表中某条序列的信息
    @CrossOrigin
    @PostMapping("/sequenceAccept")
    public boolean sequenceAccept(@RequestBody Genome genome){
        return genomeService.sequenceAccept(genome);
    }

    // 这个接口用于实现：审核打回时修改genome表中某条序列的信息
    @CrossOrigin
    @PostMapping("/sequenceReject")
    public boolean sequenceReject(@RequestBody Genome genome){
        return genomeService.sequenceReject(genome);
    }

    // 这个接口用于实现：删除Genome表中的某条数据
    @CrossOrigin
    @GetMapping("/delSequence")
    public boolean delSequence(String accession){
        return genomeService.delSequence(accession);
    }

    /* 这个接口用于实现：将Gonome表中某个用户提交的新序列但是没有被check的内容列出来
    传入参数：username
    传出参数：Genome集合
     */
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/sequenceWaitingForCheck")  // 定义了一个Get请求接口
    public HashMap<String, Object> waitingForCheck(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize,
        @RequestParam(required = false) String username){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<Genome> genomes = genomeService.waitingForCheck(username);
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


    /* 这个接口用于实现：将Gonome表中某个用户提交的新序列但并被打回的内容全部列出来
    传入参数：username
    传出参数：Genome集合
     */
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/rejectedApplications")  // 定义了一个Get请求接口
    public HashMap<String, Object> rejectedApplications(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize,
        @RequestParam(required = false) String username){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<Genome> genomes = genomeService.rejectedApplications(username);
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

    /* 这个接口用于实现：将Gonome表中某个用户提交的新序列但并被打回的内容全部列出来
    传入参数：username
    传出参数：Genome集合
     */
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/acceptedApplications")  // 定义了一个Get请求接口
    public HashMap<String, Object> acceptedApplications(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize,
        @RequestParam(required = false) String username){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<Genome> genomes = genomeService.acceptedApplications(username);
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


    // 精确查询分页查询方法
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/genomePreciseSearchPage")  // 定义了一个Get请求接口
    public HashMap<String, Object> genomePreciseSearch(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize,
        @RequestParam(required = false) String accession){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<Genome> genomes = genomeService.genomePreciseSearch(accession);
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

    // 模糊查询分页查询方法
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/genomeFlexSearchPage")  // 定义了一个Get请求接口
    public HashMap<String, Object> genomeFlexSearch(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) String refinedHost){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<Genome> genomes = genomeService.genomeFlexSearch(country, refinedHost);
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

    // 列出所有待审核的序列
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/listGenomePage")  // 定义了一个Get请求接口
    public HashMap<String, Object> listGenomePage(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<Genome> genomes = genomeService.listGenomePage();
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
