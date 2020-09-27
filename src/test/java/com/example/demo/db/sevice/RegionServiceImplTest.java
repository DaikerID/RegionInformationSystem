package com.example.demo.db.sevice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.db.mapper.RegionMapper;
import com.example.demo.db.model.Region;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegionServiceImplTest {

  @Mock
  private RegionMapper mapper;

  @InjectMocks
  private RegionServiceImpl service;

  @Test
  void getRegionById() {
    Region region = new Region(1L, "qwe", "qweqwe");
    when(mapper.getRegionById(anyLong())).thenReturn(region);

    Optional<Region> regionById = service.getRegionById(1L);
    assertThat(regionById.get()).isEqualTo(region);
  }

  @Test
  void getRegions() {
    List<Region> regions = List.of(new Region(1L, "qwe", "qweqwe"));
    when(mapper.getRegions()).thenReturn(regions);
    assertThat(service.getRegions()).isEqualTo(regions);
  }

  @Test
  void updateRegion() {
    Region region = new Region(1L, "qwe", "qweqwe");
    service.updateRegion(region);
    verify(mapper, times(1)).updateRegion(region);
  }

  @Test
  void insertRegion() {
    Region region = new Region(1L, "qwe", "qweqwe");
    service.insertRegion(region);
    verify(mapper, times(1)).insertRegion(region);
  }

  @Test
  void deleteRegion() {
    Long id = 1L;
    service.deleteRegion(id);
    verify(mapper, times(1)).deleteRegion(id);
  }
}