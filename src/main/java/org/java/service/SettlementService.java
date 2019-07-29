package org.java.service;

import java.util.Map;

public interface SettlementService {
    void add(Map<String,Object> map);
    Map<String,Object> showData(String userName);
    void settlement(Map<String,Object> map);
}
