package com.example.demo.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

  private Long id;
  private String name;
  private String shortName;

  public Region(String name, String shortName) {
    this.name = name;
    this.shortName = shortName;
  }
}
