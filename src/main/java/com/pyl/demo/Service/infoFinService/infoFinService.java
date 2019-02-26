package com.pyl.demo.Service.infoFinService;

import com.pyl.demo.model.collect_record_info;
import com.pyl.demo.model.plant_divide_info;
import com.pyl.demo.model.plant_traffic_info;

import java.util.List;

public interface infoFinService {

    //增加采收数据
    public int insertCollectRecord(collect_record_info collect_record_info);
    //删除采收数据
    public int deleteCollectRecord(int id);
    //更新采收数据
    public int updateCollectRecord(collect_record_info collect_record_info);
    //查看采收数据
    public collect_record_info selectCollectRecord(int id);
    //查看该用户的所有采收数据
    public List<collect_record_info> selectAllCollectRecord(int pageNum, int pageSize,String username);
    //获得该用户采收数据个数
    public int getCollectRecordNum(String username);

    //增加分级包装记录
    public int insertDividePack(plant_divide_info plant_divide_info);
    //删除分级包装记录
    public int deleteDividePack(int id);
    //更新分级包装记录
    public int updateDividePack(plant_divide_info plant_divide_info);
    //查看分级包装记录
    public plant_divide_info checkDividePack(int id);
    //查看该用户的所有分级包装数据
    public List<plant_divide_info> selectAllDividePack(int pageNum, int pageSize,String username);
    //获得该用户分级包装数据个数
    public int getDividePackNum(String username);

    //获得用户所有的运输记录
    public List<plant_traffic_info> selectAllTraf(int pageNum, int pageSize,String username);
    //插入运输记录
    public int insertTraffic(plant_traffic_info plant_traffic_info);
    //删除运输记录
    public int deleteTraffic(int id);
    //修改运输记录
    public int updateTraffic(plant_traffic_info plant_traffic_info);
    //查看运输记录
    public plant_traffic_info checkTraffic(int id);
    //获得用户运输记个数
    public int getTrafficNum(String username);
}
