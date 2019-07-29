package org.java.web;

import org.java.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    @RequestMapping("add")
    public void add(@RequestParam Map<String,Object> map){
        settlementService.add(map);
    }

    @RequestMapping("loadSettlement")
    public String loadSettlement(){
        return "settlement";
    }
    @RequestMapping("showData")
    @ResponseBody
    public Map<String,Object> showData(HttpSession session){
        Map<String,Object> emp = (Map<String, Object>) session.getAttribute("emp");
        return settlementService.showData(emp.get("emp_username").toString());
    }

    @RequestMapping("settlement")
    public String settlement(@RequestParam Map<String,Object> map,HttpSession session){
        Map<String,Object> emp = (Map<String, Object>) session.getAttribute("emp");
        map.put("emp_id",emp.get("emp_id").toString());
        settlementService.add(map);
        return "redirect:loadSettlement";
    }
}
