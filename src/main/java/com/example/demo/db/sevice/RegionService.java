package com.example.demo.db.sevice;

import com.example.demo.db.model.Region;
import java.util.List;
import java.util.Optional;

public interface RegionService {

  Optional<Region> getRegionById(Long id);

  List<Region> getRegions();

  void insertRegion(Region region);

  void updateRegion(Region region);

  void deleteRegion(Long id);
}
