package com.example.demo.endpoint;

import com.example.demo.db.model.Region;
import com.example.demo.db.sevice.RegionServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegionEndpoint {

  private final RegionServiceImpl regionService;

  @GetMapping(path = "regions")
  public List<Region> getRegion() {
    return regionService.getRegions();
  }

  @GetMapping(path = "region/{id}")
  public Region getRegion(@PathVariable Long id) {
    return regionService.getRegionById(id)
                        .orElseThrow(() -> new NullPointerException("Region not found!"));
  }

  @PutMapping(path = "region/{id}")
  public void updateRegion(@RequestBody Region region) {
    regionService.updateRegion(region);
  }

  @PostMapping(path = "region/{id}")
  public void insertRegion(@RequestBody Region region) {
    regionService.insertRegion(region);
  }

  @DeleteMapping(path = "region/{id}")
  public void deleteRegion(@PathVariable Long id) {
    regionService.deleteRegion(id);
  }
}
