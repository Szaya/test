package com.epam.training.test_backend.model;

import com.epam.training.test_backend.framework.CreateJSONBody;

public class Event extends CreateJSONBody {
    private Integer id;
    private String title;
    private String type;
    private Integer[] start;
    private Integer[] end;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer[] getStart() {
        return start;
    }

    public void setStart(Integer[] start) {
        this.start = start;
    }

    public Integer[] getEnd() {
        return end;
    }

    public void setEnd(Integer[] end) {
        this.end = end;
    }
    


  public static class Builder {
    private Integer id;
    private String title;
    private String type;
    private Integer[] start;
    private Integer[] end;

    public Builder(int id) {
      this.id = id;
    }

    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withStart(Integer[] start) {
      this.start = start;
      return this;
    }
    
    public Builder withEnd(Integer[] end) {
      this.end = end;
      return this;
    }
    
    public Event build() {
      Event event = new Event();
      event.id = this.id;
      event.title = this.title;
      event.type = this.type;
      event.start = this.start;
      event.end = this.end;

      return event;
    }

  }
}
