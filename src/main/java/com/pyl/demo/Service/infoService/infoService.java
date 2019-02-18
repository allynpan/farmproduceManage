package com.pyl.demo.Service.infoService;


import com.pyl.demo.model.*;

import java.util.List;

public interface infoService {
    /*
    public List<plantation_info> getAllplantation(int pageNum,int pageSize);

    public int getNum(String username);

    public List<plantation_info> getAllByUser(int pageNum,int pageSize,String username);

    public List<plantation_info> getAllByGroup(int pageNum,int pageSize,String username);
    */

    public List<plant_place_info> getPlacePlant(int pageNum, int pageSize, int id);

    public int getNum(int user_id);

    public List<plantation_info> getAllPlant(int pageNum, int pageSize,String username);

    public List<place_record_info> getAllPlantRecord(int pageNum,int pageSize,String username);

    public int getNumByUser(int user_id);

    public List<shave_record_info> getAllShaveRecord(int pageNum, int pageSize, int user_id);

    public int getShaveRecordNum(int user_id);

    public List<disease_record_info> getAllDiseaseRecord(int pageNum, int pageSize, int user_id);

    public int getDiseaseRecordNum(int user_id);

    public List<preserve_record_info> getAllPreserveRecord(int pageNum, int pageSize, int user_id);

    public int getPreserveNum(int user_id);

    public int InsertDiseaseRecord(disease_record_info record_info);

    public int getDiseaseID(String name);

    public int deleteDiseaseRecord(int id);

    public disease_record_info getDiseaseById(int id);

    public int updateByPrimaryKey(disease_record_info record);

    public int insertShaveRecord(shave_record_info shave_record_info);

    public int deleteShaveRecord(int id);

    public int updateShave(shave_record_info shave_record_info);

    public shave_record_info getShaveById(int id);

    public int insertPreserveRecord(preserve_record_info preserve_record_info);

    public int deletePreserveRecord(int id);

    public int updatePreserveRecord(preserve_record_info preserve_record_info);



}
