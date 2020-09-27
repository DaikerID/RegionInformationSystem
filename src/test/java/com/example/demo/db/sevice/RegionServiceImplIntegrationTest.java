package com.example.demo.db.sevice;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.config.PersistenceConfig;
import com.example.demo.db.mapper.RegionMapper;
import com.example.demo.db.model.Region;
import java.util.Objects;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@AutoConfigureMybatis
@ContextConfiguration(classes = {RegionServiceImpl.class,
    PersistenceConfig.class})
public class RegionServiceImplIntegrationTest {

  @Autowired
  private RegionMapper mapper;

  @Autowired
  private RegionServiceImpl service;

  private Region region = new Region(1L, "Leningradskaya oblast", "78");

  void initDataBase() {
    if (Objects.isNull(mapper.getRegionById(1L))) {
      mapper.insertRegion(region);
    }
  }

  @Test
  void getRegionById() {
    initDataBase();
    Optional<Region> regionById = service.getRegionById(1L);
    assertThat(regionById.get()).isEqualTo(region);
  }

}
