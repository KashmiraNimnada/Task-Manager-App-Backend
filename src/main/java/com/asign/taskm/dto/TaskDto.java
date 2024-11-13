package com.asign.taskm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

    private String name;
    private String description;
    private String duedate;
    private String status;
    private String user_name;

}
