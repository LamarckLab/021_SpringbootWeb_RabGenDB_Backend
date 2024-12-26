package com.rabies.mapper;

import com.rabies.pojo.Genome;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GenomeMapper {


    @Select("select * from rabies.genome")
    List<Genome> listGenomes();
}
