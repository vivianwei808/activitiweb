package com.imooc.activitiweb;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class Part7_Gateway {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Test
    public void initProcessInstance() {

        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey(
//                        "myProcess_Inclusive");
                        "myProcess_Parallel");
        System.out.println("流程实例ID："+processInstance.getProcessDefinitionId());
    }

    @Test
    public void completeTask() {

        Map<String, Object> variables = new HashMap<String, Object>();

        //流程实例idecd41693-d3cd-11ea-ad34-dcfb4875e032

        taskService.complete("98c0dc03-50e9-11eb-a9a7-1253fb9c9bcd");
//        taskService.complete("98c10315-50e9-11eb-a9a7-1253fb9c9bcd");
        System.out.println("完成任务");


    }

}
