package com.pyl.demo.Service.infoFinService.impl;

import com.github.pagehelper.PageHelper;
import com.pyl.demo.Service.infoFinService.infoFinService;
import com.pyl.demo.Util.RespBean;
import com.pyl.demo.mapper.collect_record_infoMapper;
import com.pyl.demo.mapper.plant_divide_infoMapper;
import com.pyl.demo.mapper.plant_traffic_infoMapper;
import com.pyl.demo.model.collect_record_info;
import com.pyl.demo.model.plant_divide_info;
import com.pyl.demo.model.plant_traffic_info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("infoFinService")
public class infoFinServiceImpl implements infoFinService {

    @Autowired
    collect_record_infoMapper collect_record_infoMapper;

    @Autowired
    plant_divide_infoMapper plant_divide_infoMapper;

    @Autowired
    plant_traffic_infoMapper plant_traffic_infoMapper;

    private final static Logger logger = LoggerFactory.getLogger(infoFinServiceImpl.class);

    public int insertCollectRecord(collect_record_info collect_record_info){
        int result = collect_record_infoMapper.insert(collect_record_info);
        return result;
    }

    //删除采收数据
    public int deleteCollectRecord(int id){
        int result = collect_record_infoMapper.deleteByPrimaryKey(id);
        return result;
    }
    //更新采收数据
    public int updateCollectRecord(collect_record_info collect_record_info){
        int result = collect_record_infoMapper.updateByPrimaryKey(collect_record_info);
        return result;
    }
    //查看采收数据
    public collect_record_info selectCollectRecord(int id){
        return collect_record_infoMapper.selectByPrimaryKey(id);
    }
    //获得该用户采收数据个数
    public int getCollectRecordNum(String username){
        return collect_record_infoMapper.getCollectRecordNum(username);
    }

    public List<collect_record_info> selectAllCollectRecord(int pageNum, int pageSize,String username){
        PageHelper.startPage(pageNum,pageSize);
        return collect_record_infoMapper.selectAllCollectRecord(username);
    }

    //增加分级包装记录
    public int insertDividePack(plant_divide_info plant_divide_info){
        int result = plant_divide_infoMapper.insert(plant_divide_info);
        return result;
    }
    //删除分级包装记录
    public int deleteDividePack(int id){
        int result = plant_divide_infoMapper.deleteByPrimaryKey(id);
        return result;
    }
    //更新分级包装记录
    public int updateDividePack(plant_divide_info plant_divide_info) {
        int result = plant_divide_infoMapper.updateByPrimaryKey(plant_divide_info);
        return result;
    }
    //查看分级包装记录
    public plant_divide_info checkDividePack(int id){
        return plant_divide_infoMapper.selectByPrimaryKey(id);
    }

    public List<plant_divide_info> selectAllDividePack(int pageNum, int pageSize,String username){
        PageHelper.startPage(pageNum,pageSize);
        return plant_divide_infoMapper.selectAllDividePack(username);
    }
    //获得该用户分级包装数据个数
    public int getDividePackNum(String username){
        return plant_divide_infoMapper.getDividePackNum(username);
    }


    //获得用户所有的运输记录
    public List<plant_traffic_info> selectAllTraf(int pageNum, int pageSize,String username){
        PageHelper.startPage(pageNum,pageSize);
        List<plant_traffic_info> list = plant_traffic_infoMapper.selectAllTraf(username);
        return list;
    }
    //插入运输记录
    public int insertTraffic(plant_traffic_info plant_traffic_info){
        int result = plant_traffic_infoMapper.insert(plant_traffic_info);
        return result;
    }
    //删除运输记录
    public int deleteTraffic(int id){
        int result = plant_traffic_infoMapper.deleteByPrimaryKey(id);
        return result;
    }
    //修改运输记录
    public int updateTraffic(plant_traffic_info plant_traffic_info){
        int result = plant_traffic_infoMapper.updateByPrimaryKey(plant_traffic_info);
        return result;
    }
    //查看运输记录
    public plant_traffic_info checkTraffic(int id){
        plant_traffic_info plant_traffic_info= plant_traffic_infoMapper.selectByPrimaryKey(id);
        return plant_traffic_info;
    }
    //获得用户运输记个数
    public int getTrafficNum(String username){
        int num = plant_traffic_infoMapper.getTrafficNum(username);
        return num;
    }
}

