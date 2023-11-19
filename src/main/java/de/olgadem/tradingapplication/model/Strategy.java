package de.olgadem.tradingapplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("strategies")
public class Strategy {
  @Id
  private Integer id;
  private String name;
  private List<String> processes;

  public Strategy(String name, List<String> processes) {
    this.name = name;
    this.processes = processes;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getProcesses() {
    return processes;
  }

  public void setProcesses(List<String> processes) {
    this.processes = processes;
  }

  @Override
  public String toString() {
    return "Strategy{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", processes=" + processes +
            '}';
  }

}
