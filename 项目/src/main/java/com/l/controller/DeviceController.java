package com.l.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.l.bean.Device;
import com.l.bean.ListTemp;
import com.l.bean.UserInfo;
import com.l.service.IDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author l
 * @since 2019-04-15
 */
@Controller
@RequestMapping("/device")
@Api(description = "设备")
public class DeviceController {

    @Resource(name = "deviceServiceImpl")
    private IDeviceService deviceService;

    @ApiOperation(value = "获取设备列表")
    @RequestMapping(value = "getDeviceList", method = RequestMethod.GET)
    @ResponseBody
    public ListTemp getDeviceList(@RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        EntityWrapper ew = new EntityWrapper();
        ew.orderBy("create_time", false);
        PageInfo<Device> pageInfo = new PageInfo<Device>(deviceService.selectList(ew));

        ListTemp listTemp = new ListTemp();
        listTemp.setCode(0);
        listTemp.setCount((int) pageInfo.getTotal());
        listTemp.setData(pageInfo.getList());
        return listTemp;
    }

    @ApiOperation(value = "添加设备")
    @RequestMapping(value = "addDevice", method = RequestMethod.POST)
    @ResponseBody
    public boolean addDevice(Device device, HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("user_key");
        device.setCreateTime(new Date());
        if (user != null) {
            device.setCreateUser(user.getUserName());
        }
        return deviceService.insert(device);
    }

    @ApiOperation(value = "删除设备")
    @RequestMapping(value = "delDevice", method = RequestMethod.POST)
    @ResponseBody
    public boolean delDevice(@RequestParam("id") Integer id) {
        return deviceService.deleteById(id);
    }

}
