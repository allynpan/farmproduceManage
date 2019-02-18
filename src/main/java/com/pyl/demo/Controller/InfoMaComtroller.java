package com.pyl.demo.Controller;

import com.pyl.demo.Service.UserService.impl.UserServiceimpl;
import com.pyl.demo.Service.infoService.infoService;
import com.pyl.demo.Util.RespBean;
import com.pyl.demo.Util.UTCtoDate;
import com.pyl.demo.model.disease_record_info;
import com.pyl.demo.model.plant_info;
import com.pyl.demo.model.plant_place_info;
import com.pyl.demo.model.shave_record_info;
import jdk.nashorn.internal.scripts.JO;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("informationBefo")
public class InfoMaComtroller {

    private final static Logger logger = LoggerFactory.getLogger(InfoMaComtroller.class);

    @Autowired
    private infoService infoService;

    @Autowired
    private UserServiceimpl userService;

    @ResponseBody
    @RequestMapping(value = "/test",produces = {"application/json;charset=UTF-8"})
    public RespBean test(int pageNum,int pageSize,String username){
        return RespBean.ok("请求成功",infoService.getAllPlant(pageNum,pageSize,username));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllplant",produces = {"application/json;charset=UTF-8"})
    public RespBean getAllplants(int pageNum,int pageSize,String username){

        logger.info("pageNum:"+pageNum+"pageSize:"+pageSize+"username:"+username);
        return RespBean.ok("请求成功",infoService.getAllPlant(pageNum,pageSize,username));
    }

    @ResponseBody
    @RequestMapping(value = "/getPlantAndPlace",produces = {"application/json;charset=UTF-8"})
    public RespBean getAllplantsGroup(int pageNum,int pageSize,String username){
        logger.info("pageNum:"+pageNum+"pageSize:"+pageSize+"username:"+username);
        int i = userService.getID(username);
        List<plant_place_info>  choosePlants = infoService.getPlacePlant(pageNum,pageSize,i);
        return RespBean.ok("请求成功",choosePlants);
    }

    @ResponseBody
    @RequestMapping(value = "/getPlantAndPlaceNum",produces = {"application/json;charset=UTF-8"})
    public RespBean getPlantAndPlaceNum(String username){
        logger.info("username:"+username);
        int i = userService.getID(username);
        int id = infoService.getNum(i);
        return RespBean.ok("请求成功",id);
    }

    /**
     *  用于果园信息记录那个网页
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllPlantRecord",produces = {"application/json;charset=UTF-8"})
    public RespBean getAllPlantRecord(int pageNum,int pageSize,String username){
        logger.info("pageNum:"+pageNum+"pageSize:"+pageSize);
        return RespBean.ok("请求成功",infoService.getAllPlantRecord(pageNum,pageSize,username));
    }

    /**
     * 获取果园信息记录的个数
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPlaceRecordNum",produces = {"application/json;charset=UTF-8"})
    public RespBean getNumByUser(String username){
        int id = userService.getID(username);
        return  RespBean.ok("请求成功", infoService.getNumByUser(id));
    }

    /**
     * 获得所有的修剪记录
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllShaveRecord",produces = {"application/json;charset=UTF-8"})
    public RespBean getAllShaveRecord(int pageNum, int pageSize, String username){
        int id = userService.getID(username);
        return RespBean.ok("请求成功",infoService.getAllShaveRecord(pageNum,pageSize,id));
    }

    /**
     * 获得修剪记录的数目
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getShaveRecordNum",produces = {"application/json;charset=UTF-8"})
    public RespBean getShaveRecordNum(String username){
         int id = userService.getID(username);
         return RespBean.ok("请求成功",infoService.getShaveRecordNum(id));
    }


    /**
     * 获得所有的病虫害记录
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllDiseaseRecord",produces = {"application/json;charset=UTF-8"})
    public RespBean getAllDiseaseRecord(int pageNum, int pageSize, String username){
        int id = userService.getID(username);
        return RespBean.ok("请求成功",infoService.getAllDiseaseRecord(pageNum,pageSize,id));
    }

    /**
     * 获得病虫害记录的个数
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getDiseaseRecordNum",produces = {"application/json;charset=UTF-8"})
    public RespBean getDiseaseRecordNum(String username){
        int id = userService.getID(username);
        return RespBean.ok("请求成功",infoService.getDiseaseRecordNum(id));
    }

     /**
     * 获得preserve表信息
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllPreserveRecord",produces = {"application/json;charset=UTF-8"})
    public RespBean getAllPreserveRecord(int pageNum, int pageSize, String username){
        int id = userService.getID(username);
        return  RespBean.ok("请求成功",infoService.getAllPreserveRecord(pageNum,pageSize,id));
    }

    /**
     * 获得preserve表的数目
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPreserveNum",produces = {"application/json;charset=UTF-8"})
    public RespBean getPreserveNum(String username){
        int id = userService.getID(username);
        return RespBean.ok("请求成功",infoService.getPreserveNum(id));
    }

    @ResponseBody
    @RequestMapping(value = "/insertDisease")
    public RespBean insertDiseaseRecord(HttpServletRequest request) throws JSONException, ParseException {
        disease_record_info record_info = new disease_record_info();
        record_info.setName((String)request.getParameter("name"));

        record_info.setInsectName((String)request.getParameter("insectName"));
        record_info.setMedicine((String)request.getParameter("medicine"));
        if(request.getParameter("isFinish").equals(false)){
            record_info.setIsFinish((byte) 0);
        }else{
            record_info.setIsFinish((byte) 1);
        }
        record_info.setResult(request.getParameter("result"));
        record_info.setPlace(request.getParameter("place"));
        String num = request.getParameter("num");
        if(num.equals(null)||num.equals("")){
            record_info.setNum(null);
        }else{
            record_info.setNum(new Integer(num));
        }
        String diseaseNum = request.getParameter("diseaseNum");
        if(diseaseNum.equals(null)||diseaseNum.equals("")){
            record_info.setDiseaseNum(null);
        }else{
            record_info.setDiseaseNum(new Integer(diseaseNum));
        }
        String time = request.getParameter("time");
        if(time.equals(null)||time.equals("")||time.equals("Invalid Date")){
            record_info.setTime(null);
        }else{
            //logger.info(time);
            String date = UTCtoDate.parseTime(time);
            //logger.info(date);
            Date date1 = new Date(date);
            record_info.setTime(date1);
        }
        String square = request.getParameter("square");
        if(square.equals(null)||square.equals("")){
            record_info.setSquare(null);
        }else{
            record_info.setSquare(new Double(square));
        }
        String diseaseRate = request.getParameter("diseaseRate");
        if(diseaseRate.equals(null)||diseaseRate.equals("")){
            record_info.setDiseaseRate(null);
        }else{
            record_info.setDiseaseRate(new Double(diseaseRate));
        }
        String protectTime = request.getParameter("protectTime");
        logger.info("protectTime:"+protectTime);
        if(protectTime.equals("")||protectTime.equals(null)||protectTime.equals("Invalid Date")){
            record_info.setProtectTime(null);
        }else{
            //logger.info("protectTime:"+protectTime);
            String date = UTCtoDate.parseTime(protectTime);
            Date date1 = new Date(date);
            record_info.setProtectTime(date1);
            //Date date = new Date(protectTime);
            //record_info.setProtectTime(date);
        }
        String dosage = request.getParameter("dosage");
        if(dosage.equals(null)||dosage.equals("")){
            record_info.setDosage(null);
        }else{
            record_info.setDosage(new Double(dosage));
        }
        String username = request.getParameter("username");
        int user_id = userService.getID(username);
        record_info.setUserId(user_id);
        logger.info(record_info.toString());
        int i = infoService.InsertDiseaseRecord(record_info);
        if(i==0){
            return RespBean.error("插入失败");
        }else{
            return RespBean.ok("插入成功");
        }
    }

    /**
     * 删除病虫害记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteDisease",produces = {"application/json;charset=UTF-8"})
    public RespBean deleteDisease(int id){
        int result = infoService.deleteDiseaseRecord(id);
        if(id==0){
            return RespBean.error("删除失败");
        }else{
            return RespBean.ok("删除成功");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getDiseaseByID",produces = {"application/json;charset=UTF-8"})
    public RespBean getDiseaseById(int id){
        disease_record_info disease_record_info = infoService.getDiseaseById(id);
        if(disease_record_info!=null) {
            return RespBean.ok("请求成功", disease_record_info);
        }else{
            return RespBean.error("请求失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateDiseaseById")
    public RespBean updateDiseaseById(HttpServletRequest request){
        Map map = request.getParameterMap();
        logger.info("map:"+map.toString());
        disease_record_info record_info = new disease_record_info();
        record_info.setName((String)request.getParameter("name"));

        record_info.setInsectName((String)request.getParameter("insectName"));
        record_info.setMedicine((String)request.getParameter("medicine"));
        if(request.getParameter("isFinish").equals(false)){
            record_info.setIsFinish((byte) 0);
        }else{
            record_info.setIsFinish((byte) 1);
        }
        record_info.setResult(request.getParameter("result"));
        record_info.setPlace(request.getParameter("place"));
        String num = request.getParameter("num");
        if(num.equals(null)||num.equals("")){
            record_info.setNum(null);
        }else{
            record_info.setNum(new Integer(num));
        }
        String diseaseNum = request.getParameter("diseaseNum");
        if(diseaseNum.equals(null)||diseaseNum.equals("")){
            record_info.setDiseaseNum(null);
        }else{
            record_info.setDiseaseNum(new Integer(diseaseNum));
        }
        String time = request.getParameter("time");
        logger.info("time:"+time);
        if(time.equals(null)||time.equals("")||time.equals("Invalid Date")){
                record_info.setTime(null);
            }else{
                //logger.info(time);
                String date = UTCtoDate.parseTime(time);
                //logger.info(date);
                Date date1 = new Date(date);
                record_info.setTime(date1);
        }
        String square = request.getParameter("square");
        if(square.equals(null)||square.equals("")){
            record_info.setSquare(null);
        }else{
            record_info.setSquare(new Double(square));
        }
        String diseaseRate = request.getParameter("diseaseRate");
        if(diseaseRate.equals(null)||diseaseRate.equals("")){
            record_info.setDiseaseRate(null);
        }else{
            record_info.setDiseaseRate(new Double(diseaseRate));
        }
        String protectTime = request.getParameter("protectTime");
        logger.info("protectTime:"+protectTime);
        if(protectTime.equals("")||protectTime.equals(null)||protectTime.equals("Invalid Date")){
            record_info.setProtectTime(null);
        }else{
            //logger.info("protectTime:"+protectTime);
            String date = UTCtoDate.parseTime(protectTime);
            Date date1 = new Date(date);
            record_info.setProtectTime(date1);
            //Date date = new Date(protectTime);
            //record_info.setProtectTime(date);
        }
        String dosage = request.getParameter("dosage");
        if(dosage.equals(null)||dosage.equals("")){
            record_info.setDosage(null);
        }else{
            record_info.setDosage(new Double(dosage));
        }
        String username = request.getParameter("username");
        int user_id = userService.getID(username);
        record_info.setUserId(user_id);
        int id = Integer.parseInt(request.getParameter("id"));
        record_info.setId(id);
        String exector = request.getParameter("executor");
        record_info.setExecutor(exector);
        logger.info(record_info.toString());
        int i = infoService.updateByPrimaryKey(record_info);
        if(i==0){
            return RespBean.error("更新失败");
        }else{
            return RespBean.ok("更新成功");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getShaveByID")
    public RespBean getShaveById(int id){
        shave_record_info shave_record_info = infoService.getShaveById(id);
        if(!shave_record_info.equals(null)){
            return RespBean.ok("请求成功",shave_record_info);
        }else{
            return RespBean.error("请求失败");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/insertShave")
    public RespBean insertShave(HttpServletRequest request){
        shave_record_info shave_record_info = new shave_record_info();
        String method = request.getParameter("method");
        shave_record_info.setMethod(method);
        String number = request.getParameter("number");
        if(number.equals(null)){
            shave_record_info.setNumber(null);
        }else{
            shave_record_info.setNumber(Integer.parseInt(number));
        }
        //shave_record_info.setNumber(number);
        String time = request.getParameter("time");
        if(time.equals(null)||time.equals("")||time.equals("Invalid Date")){
            shave_record_info.setTime(null);
        }else{
            //logger.info(time);
            String date = UTCtoDate.parseTime(time);
            //logger.info(date);
            Date date1 = new Date(date);
            shave_record_info.setTime(date1);
        }
        String statue = request.getParameter("statue");
        shave_record_info.setStatue(statue);
        String remark = request.getParameter("remark");
        shave_record_info.setRemark(remark);
        String name = request.getParameter("name");
        shave_record_info.setName(name);
        String username = request.getParameter("username");
        int user_id = userService.getID(username);
        shave_record_info.setUserId(user_id);
        int result = infoService.insertShaveRecord(shave_record_info);
        if(result!=0){
            return RespBean.ok("插入成功");
        }else{
            return RespBean.error("插入失败");
        }
        //return RespBean.ok("更新成功");
    }


    @ResponseBody
    @RequestMapping(value = "/deleteShave")
    public RespBean deleteShave(int id){
        int result = infoService.deleteShaveRecord(id);
        if(result!=0){
            return RespBean.ok("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
        //return RespBean.ok("删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "/updateShave")
    public RespBean updateShave(HttpServletRequest request){
        shave_record_info shave_record_info = new shave_record_info();
        String method = request.getParameter("method");
        shave_record_info.setMethod(method);
        String number = request.getParameter("number");
        if(number.equals(null)){
            shave_record_info.setNumber(null);
        }else{
            shave_record_info.setNumber(Integer.parseInt(number));
        }
        //shave_record_info.setNumber(number);
        String time = request.getParameter("time");
        if(time.equals(null)||time.equals("")||time.equals("Invalid Date")){
            shave_record_info.setTime(null);
        }else{
            //logger.info(time);
            String date = UTCtoDate.parseTime(time);
            //logger.info(date);
            Date date1 = new Date(date);
            shave_record_info.setTime(date1);
        }
        String statue = request.getParameter("statue");
        shave_record_info.setStatue(statue);
        String remark = request.getParameter("remark");
        shave_record_info.setRemark(remark);
        String name = request.getParameter("name");
        shave_record_info.setName(name);
        String id = request.getParameter("id");
        shave_record_info.setId(Integer.parseInt(id));
        String username = request.getParameter("username");
        int user_id = userService.getID(username);
        shave_record_info.setUserId(user_id);
        int result = infoService.updateShave(shave_record_info);
        if(result!=0){
            return RespBean.ok("更新成功");
        }else{
            return RespBean.error("更新失败");
        }
        //return RespBean.ok("更新成功");
    }

    @ResponseBody
    @RequestMapping(value = "/insertPreserve")
    public RespBean insertPreserve(HttpServletRequest request){
        return RespBean.ok("增加成功");
    }

    @ResponseBody
    @RequestMapping(value = "/deletePreserve")
    public RespBean deletePreserve(int id){
        return  RespBean.ok("删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "/updatePreserve")
    public RespBean updatePreserve(HttpServletRequest request){
        return  RespBean.ok("更新成功");
    }


}
