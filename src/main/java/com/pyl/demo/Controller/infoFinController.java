package com.pyl.demo.Controller;

import com.pyl.demo.Service.UserService.impl.UserServiceImpl;
import com.pyl.demo.Service.infoFinService.infoFinService;
import com.pyl.demo.Util.RespBean;
import com.pyl.demo.Util.UTCtoDate;
import com.pyl.demo.model.collect_record_info;
import com.pyl.demo.model.plant_divide_info;
import com.pyl.demo.model.plant_traffic_info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/infomationFin")
public class infoFinController {

    private final static Logger logger = LoggerFactory.getLogger(infoFinController.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private infoFinService infoFinService;

    /**
     * 增加采收表数据
     */
    @ResponseBody
    @RequestMapping(value = "/insertCollectRecord")
    public RespBean insertCollectRecord(HttpServletRequest request){
        collect_record_info collect_record_info = new collect_record_info();
        collect_record_info.setPlantName(request.getParameter("plantName"));
        collect_record_info.setPlantation(request.getParameter("plantation"));
        collect_record_info.setRulesCollect(request.getParameter("rule"));
        if(request.getParameter("isFinish").equals(false)){
            collect_record_info.setIsFinish((byte) 0);
        }else{
            collect_record_info.setIsFinish((byte) 1);
        }
        collect_record_info.setUsername(request.getParameter("username"));
        String time = request.getParameter("time");
        if(time.equals("")||time.equals(null)||time.equals("Invalid Date")){
            collect_record_info.setDealTime(null);
        }else{
            String dateTime = UTCtoDate.parseTime(time);
            Date date = new Date(dateTime);
            collect_record_info.setDealTime(date);
        }
        String number = request.getParameter("number");
        if(number.equals(null)){
            collect_record_info.setNumber(null);
        }else{
            collect_record_info.setNumber(Double.valueOf(number));
        }
        int result = infoFinService.insertCollectRecord(collect_record_info);
        if(result==0){
            return RespBean.error("插入失败");
        }else{
            return RespBean.ok("插入成功");
        }
    }

    /**
     * 更新采收表数据
     */
    @ResponseBody
    @RequestMapping(value = "/updateCollectRecord")
    public RespBean updateCollectRecord(HttpServletRequest request){
        collect_record_info collect_record_info = new collect_record_info();
        collect_record_info.setId(Integer.parseInt(request.getParameter("id")));
        collect_record_info.setPlantName(request.getParameter("plantName"));
        collect_record_info.setPlantation(request.getParameter("plantation"));
        collect_record_info.setRulesCollect(request.getParameter("rule"));
        if(request.getParameter("isFinish").equals(false)){
            collect_record_info.setIsFinish((byte) 0);
        }else{
            collect_record_info.setIsFinish((byte) 1);
        }
        collect_record_info.setUsername(request.getParameter("username"));
        String time = request.getParameter("time");
        if(time.equals("")||time.equals(null)||time.equals("Invalid Date")){
            String dateTime = UTCtoDate.parseTime(time);
            Date date = new Date(dateTime);
            collect_record_info.setDealTime(date);
        }else{
            collect_record_info.setDealTime(null);
        }
        String number = request.getParameter("number");
        if(number.equals(null)){
            collect_record_info.setNumber(null);
        }else{
            collect_record_info.setNumber(Double.valueOf(number));
        }
        int result = infoFinService.updateCollectRecord(collect_record_info);
        if(result==0){
            return RespBean.error("更新失败");
        }else{
            return RespBean.ok("更新成功");
        }
    }

    /**
     * 删除采收表数据
     */
    @ResponseBody
    @RequestMapping(value = "/deleteCollectRecord", produces = {"application/json;charset=UTF-8"})
    public RespBean deleteCollectRecord(int id){
        int result = infoFinService.deleteCollectRecord(id);
        if(result==0){
            return RespBean.error("删除失败");
        }else{
            return RespBean.ok("删除成功");
        }
    }

    /**
     * 查看采收表数据
     */
    @ResponseBody
    @RequestMapping(value = "/checkCollectRecord", produces = {"application/json;charset=UTF-8"})
    public RespBean checkCollectRecord(int id){
        collect_record_info collect_record_info = infoFinService.selectCollectRecord(id);
        if(collect_record_info.equals(null)){
            return RespBean.error("查找失败");
        }else{
            return RespBean.ok("查找成功",collect_record_info);
        }
    }

    /**
     * 获得该用户采收表的所有数据
     */
    @ResponseBody
    @RequestMapping(value = "/checkAllCollectRecord", produces = {"application/json;charset=UTF-8"})
    public RespBean checkAllCollectRecord(int pageNum, int pageSize,String username){
        List<collect_record_info> list = infoFinService.selectAllCollectRecord(pageNum,pageSize,username);
        if(list.isEmpty()){
            return RespBean.error("无数据");
        }else{
            return RespBean.ok("成功",list);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getCollectRecordNum", produces = {"application/json;charset=UTF-8"})
    public RespBean getCollectRecordNum(String username){
        return RespBean.ok("请求成功",infoFinService.getCollectRecordNum(username));
    }

    /**
     *  增加分级包装记录
     */
    @ResponseBody
    @RequestMapping(value = "/insertDividePack")
    public RespBean insertDividePack(HttpServletRequest request){
        plant_divide_info plant_divide_info = new plant_divide_info();
        plant_divide_info.setPlantName(request.getParameter("plantName"));
        plant_divide_info.setAddress(request.getParameter("address"));
        plant_divide_info.setQuality(request.getParameter("quality"));
        plant_divide_info.setRemark(request.getParameter("remark"));
        plant_divide_info.setRulesPack(request.getParameter("rules"));
        plant_divide_info.setSize(request.getParameter("size"));
        plant_divide_info.setUsername(request.getParameter("username"));
        String time = request.getParameter("time");
        if(time.equals("")||time.equals(null)||time.equals("Invalid Date")){
            plant_divide_info.setDealTime(null);
        }else{
            String dateTime = UTCtoDate.parseTime(time);
            Date date = new Date(dateTime);
            plant_divide_info.setDealTime(date);
        }
        String number = request.getParameter("number");
        if(number.equals(null)){
            plant_divide_info.setNumber(null);
        }else{
            plant_divide_info.setNumber(Double.valueOf(number));
        }
        int result = infoFinService.insertDividePack(plant_divide_info);
        if(result==0){
            return RespBean.error("插入失败");
        }else{
            return RespBean.ok("插入成功");
        }
    }

    /**
     * 删除分级包装记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteDividePack")
    public RespBean deleteDividePack(int id){
        int result = infoFinService.deleteDividePack(id);
        if(result==0){
            return RespBean.error("删除失败");
        }else{
            return RespBean.ok("删除成功");
        }
    }

    /**
     * 查看分级包装记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkDividePack", produces = {"application/json;charset=UTF-8"})
    public RespBean checkDividePack(int id){
        plant_divide_info plant_divide_info = infoFinService.checkDividePack(id);
        if(plant_divide_info.equals(null)){
            return  RespBean.error("查找失败");
        }else{
            return RespBean.ok("查找成功",plant_divide_info);
        }
    }

    /**
     * 更新分级包装记录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateDividePack")
    public RespBean updateDividePack(HttpServletRequest request){
        plant_divide_info plant_divide_info = new plant_divide_info();
        plant_divide_info.setId(Integer.parseInt(request.getParameter("id")));
        plant_divide_info.setPlantName(request.getParameter("plantName"));
        plant_divide_info.setAddress(request.getParameter("address"));
        plant_divide_info.setQuality(request.getParameter("quality"));
        plant_divide_info.setRemark(request.getParameter("remark"));
        plant_divide_info.setRulesPack(request.getParameter("rules"));
        plant_divide_info.setSize(request.getParameter("size"));
        plant_divide_info.setUsername(request.getParameter("username"));
        String time = request.getParameter("time");
        if(time.equals("")||time.equals(null)||time.equals("Invalid Date")){
            String dateTime = UTCtoDate.parseTime(time);
            Date date = new Date(dateTime);
            plant_divide_info.setDealTime(date);
        }else{
            plant_divide_info.setDealTime(null);
        }
        String number = request.getParameter("number");
        if(number.equals(null)){
            plant_divide_info.setNumber(null);
        }else{
            plant_divide_info.setNumber(Double.valueOf(number));
        }
        int result = infoFinService.updateDividePack(plant_divide_info);
        if(result==0){
            return RespBean.error("更新失败");
        }else{
            return RespBean.ok("更新成功");
        }
    }

    /**
     * 获得用户所有的分级包装记录
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkAllDividePack")
    public RespBean checkAllDividePack(int pageNum, int pageSize,String username){
        List<plant_divide_info> list = infoFinService.selectAllDividePack(pageNum,pageSize,username);
        if(list.isEmpty()){
            return RespBean.error("无数据");
        }else {
            return RespBean.ok("查找成功",list);
        }
    }

    /**
     * 获得分级包装记录个数
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getDividePackNum", produces = {"application/json;charset=UTF-8"})
    public RespBean getDividePackNum(String username){
        return RespBean.ok("请求成功",infoFinService.getDividePackNum(username));
    }

    /**
     * 获得用户所有的运输记录
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllTraf", produces = {"application/json;charset=UTF-8"})
    public RespBean selectAllTraf(int pageNum, int pageSize,String username){
        List<plant_traffic_info> list = infoFinService.selectAllTraf(pageNum,pageSize,username);
        if(list.isEmpty()){
            return RespBean.error("无数据");
        }else{
            return RespBean.ok("查询成功",list);
        }
    }

    /**
     * 插入运输记录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertTraffic")
    public RespBean insertTraffic(HttpServletRequest request){
        plant_traffic_info plant_traffic_info = new plant_traffic_info();
        plant_traffic_info.setPlaceBegin(request.getParameter("place_begin"));
        plant_traffic_info.setPlaceEnd(request.getParameter("place_end"));
        plant_traffic_info.setPlantName(request.getParameter("plantName"));
        plant_traffic_info.setRemark(request.getParameter("remark"));
        plant_traffic_info.setUsername(request.getParameter("username"));
        String weight = request.getParameter("weight");
        if(weight.equals(null)){
            plant_traffic_info.setWeight(null);
        }else{
            plant_traffic_info.setWeight(Double.valueOf(weight));
        }
        String time = request.getParameter("time");
        if(time.equals("")||time.equals(null)||time.equals("Invalid Date")){
            plant_traffic_info.setDealDate(null);
        }else{
            String dateTime = UTCtoDate.parseTime(time);
            Date date = new Date(dateTime);
            plant_traffic_info.setDealDate(date);
        }
        int result = infoFinService.insertTraffic(plant_traffic_info);
        if(result==0){
            return RespBean.error("插入失败");
        }else{
            return RespBean.ok("插入成功");
        }
    }

    /**
     * 删除运输记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteTraffic")
    public RespBean deleteTraffic(int id){
        int result = infoFinService.deleteTraffic(id);
        if(result==0){
            return RespBean.error("删除失败");
        }else{
            return RespBean.ok("删除成功");
        }
    }

    /**
     * 修改运输记录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateTraffic")
    public RespBean updateTraffic(HttpServletRequest request){
        plant_traffic_info plant_traffic_info = new plant_traffic_info();
        plant_traffic_info.setPlaceBegin(request.getParameter("place_begin"));
        plant_traffic_info.setPlaceEnd(request.getParameter("place_end"));
        plant_traffic_info.setPlantName(request.getParameter("plantName"));
        plant_traffic_info.setRemark(request.getParameter("remark"));
        plant_traffic_info.setUsername(request.getParameter("username"));
        String weight = request.getParameter("weight");
        if(weight.equals(null)){
            plant_traffic_info.setWeight(null);
        }else{
            plant_traffic_info.setWeight(Double.valueOf(weight));
        }
        String time = request.getParameter("time");
        if(time.equals("")||time.equals(null)||time.equals("Invalid Date")){
            plant_traffic_info.setDealDate(null);
        }else{
            String dateTime = UTCtoDate.parseTime(time);
            Date date = new Date(dateTime);
            plant_traffic_info.setDealDate(date);
        }
        plant_traffic_info.setId(Integer.parseInt(request.getParameter("id")));
        int result = infoFinService.updateTraffic(plant_traffic_info);
        if(result==0){
            return RespBean.error("更新失败");
        }else{
            return RespBean.ok("更新成功");
        }
    }

    /**
     * 查看运输记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkTraffic")
    public RespBean checkTraffic(int id){
        plant_traffic_info plant_traffic_info = infoFinService.checkTraffic(id);
        if(plant_traffic_info.equals(null)){
            return RespBean.error("查找失败");
        }else{
            return RespBean.ok("查找成功");
        }
    }

    /**
     * 获得用户运输记个数
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTrafficNum")
    public RespBean getTrafficNum(String username){
        return RespBean.ok("请求成功",infoFinService.getTrafficNum(username));
    }
}
