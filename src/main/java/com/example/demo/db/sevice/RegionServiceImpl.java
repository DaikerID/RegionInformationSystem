package com.example.demo.db.sevice;

import com.example.demo.db.mapper.RegionMapper;
import com.example.demo.db.model.Region;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

  private final RegionMapper regionMapper;

  @Override
  @Cacheable("regions")
  public Optional<Region> getRegionById(Long id) {
    return Optional.ofNullable(regionMapper.getRegionById(id));
  }

  @Override
  public List<Region> getRegions() {
    return regionMapper.getRegions();
  }

  @Override
  @Transactional
  public void insertRegion(Region region) {
    regionMapper.insertRegion(region);
  }

  @Override
  @Transactional
  public void updateRegion(Region region) {
    regionMapper.updateRegion(region);
  }

  @Override
  @Transactional
  public void deleteRegion(Long id) {
    regionMapper.deleteRegion(id);
  }
}
