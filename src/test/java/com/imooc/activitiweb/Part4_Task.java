package com.imooc.activitiweb;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Part4_Task {

    @Autowired
    private TaskService taskService;

    //任务查询
    @Test
    public void getTasks(){
        List<Task> list = taskService.createTaskQuery().list();
        for(Task tk : list){
            System.out.println("Id："+tk.getId());
            System.out.println("Name："+tk.getName());
            System.out.println("Assignee："+tk.getAssignee());
        }
    }

    //拾取任务
    @Test
    public void claimTask(){
        Task task = taskService.createTaskQuery().taskId("285a17d0-50ce-11eb-95f8-1e34aa5fd354").singleResult();
        taskService.claim("285a17d0-50ce-11eb-95f8-1e34aa5fd354","bajie");
    }

    //查询我的代办任务
    @Test
    public void getTasksByAssignee(){
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee("wukong")
                .list();
        for(Task tk : list){
            System.out.println("Id："+tk.getId());
            System.out.println("Name："+tk.getName());
            System.out.println("Assignee："+tk.getAssignee());
        }

    }

    //执行任务
    @Test
    public void completeTask(){
        taskService.complete("69b51811-50e9-11eb-90c1-1253fb9c9bcd");
        System.out.println("完成任务");

    }



    //归还与交办任务
    @Test
    public void setTaskAssignee(){
        Task task = taskService.createTaskQuery().taskId("1f2a8edf-cefa-11ea-84aa-dcfb4875e032").singleResult();
//        taskService.setAssignee("285a17d0-50ce-11eb-95f8-1e34aa5fd354","null");//归还候选任务
        taskService.setAssignee("285a17d0-50ce-11eb-95f8-1e34aa5fd354","wukong");//交办
    }



}
