package com.pyl.demo.Service.infoService.impl;

import com.github.pagehelper.PageHelper;
import com.pyl.demo.Service.infoService.infoService;
import com.pyl.demo.mapper.*;
import com.pyl.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("infoB_Service")
public class infoServiceImpl implements infoService {

    @Autowired
    private plant_place_infoMapper plant_place_infoMapper;

    @Autowired
    private plantation_infoMapper plantation_infoMapper;

    @Autowired
    private place_record_infoMapper place_record_infoMapper;

    @Autowired
    private USER_infoMapper user_infoMapper;

    @Autowired
    private shave_record_infoMapper shave_record_infoMapper;

    @Autowired
    private disease_record_infoMapper disease_record_infoMapper;

    @Autowired
    private preserve_record_infoMapper preserve_record_infoMapper;

    /*
    @Autowired
    private plantation_infoMapper plantation_infoMapper;

    public List<plantation_info> getAllplantation(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return plantation_infoMapper.selectAll();
    }

    public List<plantation_info> getAllByUser(int pageNum,int pageSize,String username){
        PageHelper.startPage(pageNum,pageSize);
        return plantation_infoMapper.selectAllByUser(username);
    }


    public int getNum(String username){
        return plantation_infoMapper.selectNum(username);
    }

    public List<plantation_info> getAllByGroup(int pageNum,int pageSize,String username){
        PageHelper.startPage(pageNum,pageSize);
        return  plantation_infoMapper.selectAllByGroup(username);
    }
    */

    //返回对应的选园定植数据
    public List<plant_place_info> getPlacePlant(int pageNum, int pageSize, int id){
        PageHelper.startPage(pageNum,pageSize);
        return plant_place_infoMapper.selectChoosePlant(id);
    }

    public int getNum(int user_id){
        return plant_place_infoMapper.selectNumByUserId(user_id);
    }

    public List<plantation_info> getAllPlant(int pageNum, int pageSize, String username){
        PageHelper.startPage(pageNum,pageSize);
        return plantation_infoMapper.selectAllplantByUser(username);
    }

    public List<place_record_info> getAllPlantRecord(int pageNum, int pageSize, String username){


        int id = user_infoMapper.selectIDByUsername(username);
        PageHelper.startPage(pageNum,pageSize);
        return place_record_infoMapper.selectAllPlaceRecord(id);
    }

    public int getNumByUser(int user_id){
        return place_record_infoMapper.selectNumByUser(user_id);
    }

    public List<shave_record_info> getAllShaveRecord(int pageNum, int pageSize, int user_id){
        PageHelper.startPage(pageNum,pageSize);
        return shave_record_infoMapper.selectAllByUser(user_id);
    }

    public int getShaveRecordNum(int user_id){
        return shave_record_infoMapper.selectShaveRecordNum(user_id);
    }

    public List<disease_record_info> getAllDiseaseRecord(int pageNum, int pageSize, int user_id){
        PageHelper.startPage(pageNum,pageSize);
        return disease_record_infoMapper.selectAllByUser(user_id);
    }

    public int getDiseaseRecordNum(int user_id){
        return  disease_record_infoMapper.selectDiseaseNum(user_id);
    }

    public List<preserve_record_info> getAllPreserveRecord(int pageNum, int pageSize, int user_id){
        PageHelper.startPage(pageNum,pageSize);
        return preserve_record_infoMapper.selectAllByUser(user_id);
    }

    public int getPreserveNum(int user_id){
        return preserve_record_infoMapper.selectPreserveNum(user_id);
    }

    public int InsertDiseaseRecord(disease_record_info record_info){
        return disease_record_infoMapper.insert(record_info);
    }

    public int getDiseaseID(String name){
        return disease_record_infoMapper.selectIDByName(name);
    }

    public int deleteDiseaseRecord(int id){
        return disease_record_infoMapper.deleteByPrimaryKey(new Integer(id));
    }

    public disease_record_info getDiseaseById(int id){
        return disease_record_infoMapper.selectByPrimaryKey(new Integer(id));
    }

    public int updateByPrimaryKey(disease_record_info record){
        int i = disease_record_infoMapper.updateByPrimaryKey(record);
        return i;
    }

    public shave_record_info getShaveById(int id){
        shave_record_info shave_record_info = shave_record_infoMapper.selectByPrimaryKey(id);
        return  shave_record_info;
    }

    public int insertShaveRecord(shave_record_info shave_record_info){
        int result = shave_record_infoMapper.insert(shave_record_info);
        return result;
    }

    public int deleteShaveRecord(int id){
        int result = shave_record_infoMapper.deleteByPrimaryKey(id);
        return result;
    }

    public int updateShave(shave_record_info shave_record_info){
        int result = shave_record_infoMapper.updateByPrimaryKey(shave_record_info);
        return  result;
    }

    public int insertPreserveRecord(preserve_record_info preserve_record_info){
        int result = preserve_record_infoMapper.insert(preserve_record_info);
        return result;
    }

    public int deletePreserveRecord(int id){
        int result = preserve_record_infoMapper.deleteByPrimaryKey(id);
        return result;
    }

    public int updatePreserveRecord(preserve_record_info preserve_record_info){
        int result = preserve_record_infoMapper.updateByPrimaryKey(preserve_record_info);
        return result;
    }

}
