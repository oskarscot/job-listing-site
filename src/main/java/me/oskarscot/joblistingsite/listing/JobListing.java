package me.oskarscot.joblistingsite.listing;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job_listing")
public class JobListing {

  @Id
  private String id;
  private String name;
  private String description;
  private double salary;
  private String jobType;
  private String location;
  private String employer;
  private Instant posted;

  public JobListing(String id,
                    String name,
                    String description,
                    double salary,
                    String jobType,
                    String location,
                    String employer,
                    Instant posted) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.salary = salary;
    this.jobType = jobType;
    this.location = location;
    this.employer = employer;
    this.posted = posted;
  }

  public JobListing(String name,
                    String description,
                    double salary,
                    String jobType,
                    String location,
                    String employer,
                    Instant posted) {
    this.name = name;
    this.description = description;
    this.salary = salary;
    this.jobType = jobType;
    this.location = location;
    this.employer = employer;
    this.posted = posted;
  }

  public JobListing() {}

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getEmployer() {
    return employer;
  }

  public void setEmployer(String employer) {
    this.employer = employer;
  }

  public Instant getPosted() {
    return posted;
  }

  @Override
  public String toString() {
    return "JobListing{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", salary=" + salary +
        ", jobType='" + jobType + '\'' +
        ", location='" + location + '\'' +
        ", employer='" + employer + '\'' +
        ", posted=" + posted +
        '}';
  }
}
