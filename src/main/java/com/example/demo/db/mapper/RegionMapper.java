package com.example.demo.db.mapper;

import com.example.demo.db.model.Region;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RegionMapper {

  @Select("SELECT id as id, name as name,"
      + "short_name as shortName FROM REGION WHERE id = #{id}")
  Region getRegionById(@Param("id") Long id);

  @ResultType(Region.class)
  @Select("SELECT id as id, name as name,"
      + " short_name as shortName FROM REGION")
  List<Region> getRegions();

  @Insert("INSERT INTO REGION(id, name, short_name)"
      + "VALUES (#{id}, #{name}, #{shortName})")
  void insertRegion(Region region);

  @Update("UPDATE REGION "
      + "SET "
      + "name = #{name},"
      + "short_name = #{shortName}"
      + "where id = #{id}")
  void updateRegion(Region region);

  @Delete("DELETE FROM REGION WHERE id = #{id}")
  void deleteRegion(@Param("id") Long id);
}
