package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.java.dao.SettlementMapper;
import org.java.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettlementServiceImpl implements SettlementService {

    @Autowired
    private SettlementMapper settlementMapper;
    @Autowired
    private TaskService taskService;

    @Override
    public void add(Map<String, Object> map) {
        settlementMapper.add(map);
    }

    @Override
    public Map<String, Object> showData(String userName) {
        Map<String,Object> dataMap = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        TaskQuery query = taskService.createTaskQuery();
        query.taskAssignee(userName);
        List<Task> tasks = query.list();
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            Map<String,Object> data = settlementMapper.findAdvanceAdjustmentByInstanceId(processInstanceId);
            if(data==null){
                continue;
            }
            data.put("instance_id",task.getProcessInstanceId());
            data.put("taskId",task.getId());//任务id
            data.put("taskName",task.getName());//任务名称
            data.put("createtime",task.getCreateTime());//任务的开始时间
            data.put("taskDefKey",task.getTaskDefinitionKey());//每一个任务对应的id的名称
            list.add(data);
        }
        dataMap.put("code",0);
        dataMap.put("msg","");
        dataMap.put("count",list.size());
        dataMap.put("data",list);
        return dataMap;

    }

    @Override
    public void settlement(Map<String, Object> map) {
        taskService.complete(map.get("taskId").toString());
        settlementMapper.add(map);
    }
}
