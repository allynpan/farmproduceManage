package com.pyl.demo.Service.menuService;

import com.pyl.demo.model.permission_info;
import org.springframework.stereotype.Service;

import java.util.List;


public interface menuService {
    public List<permission_info> getMenuByPerId();
}
