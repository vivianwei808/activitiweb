package com.imooc.activitiweb;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Part2_ProcessDefinition {

    @Autowired
    private RepositoryService repositoryService;

    //查询流程定义
    @Test
    public void getDefinitions(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .list();
        for(ProcessDefinition pd : list){
            System.out.println("------流程定义--------");
            System.out.println("Name："+pd.getName());
            System.out.println("Key："+pd.getKey());
            System.out.println("ResourceName："+pd.getResourceName());
            System.out.println("DeploymentId："+pd.getDeploymentId());
            System.out.println("Version："+pd.getVersion());

        }

    }

    //删除流程定义
    @Test
    public void delDefinition(){

        String pdID="459cfe75-50c8-11eb-8d58-1e34aa5fd354";
        repositoryService.deleteDeployment(pdID,true);
        System.out.println("删除流程定义成功");
    }
}
