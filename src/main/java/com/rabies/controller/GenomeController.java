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

    // 这个接口用于实现：用户重新提交被打回的序列时, 修改genome表中某条序列的信息
    @CrossOrigin
    @PostMapping("/reSubmit")
    public boolean reSubmit(@RequestBody Genome genome){
        return genomeService.reSubmit(genome);
    }

    // 这个接口用于实现：删除Genome表中的某条序列
    @CrossOrigin
    @GetMapping("/delSequence")
    public boolean delSequence(String accession){
        return genomeService.delSequence(accession);
    }

    // 这个接口用于实现: 将某个用户的待审核的序列全部列出来
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/sequenceWaitingForCheck")
    public HashMap<String, Object> waitingForCheck(
        @RequestParam(defaultValue = "1") int pageNum,
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

    // 这个接口用于实现: 将某个用户被打回的序列全部列出来
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/rejectedApplications")
    public HashMap<String, Object> rejectedApplications(
        @RequestParam(defaultValue = "1") int pageNum,
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

    // 这个接口用于实现: 将某个用户审核通过的序列全部列出来
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/acceptedApplications")
    public HashMap<String, Object> acceptedApplications(
        @RequestParam(defaultValue = "1") int pageNum,
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

    // 这个接口用于实现: 使用accession进行精确分页查询(已通过审核的)
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/genomePreciseSearchPage")
    public HashMap<String, Object> genomePreciseSearch(
        @RequestParam(defaultValue = "1") int pageNum,
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

    // 这个接口用于实现: 使用country和refinedHost进行模糊分页查询(已通过审核)
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/genomeFlexSearchPage")
    public HashMap<String, Object> genomeFlexSearch(
        @RequestParam(defaultValue = "1") int pageNum,
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

    // 该接口用于实现: 列出所有用户的待审核序列(供管理员查看)
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/listGenomePage")
    public HashMap<String, Object> listGenomePage(
        @RequestParam(defaultValue = "1") int pageNum,
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
