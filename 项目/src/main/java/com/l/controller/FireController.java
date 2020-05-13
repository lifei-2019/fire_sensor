package com.l.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.l.bean.Fire;
import com.l.bean.ListTemp;
import com.l.common.AlgorithmUtil;
import com.l.common.Param;
import com.l.common.ParamData;
import com.l.service.IFireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("fire")
@Api(description = "智能预警")
@RestController
public class FireController {

    @Resource(name = "fireServiceImpl")
    private IFireService fireService;

    @RequestMapping(value = "getFireList", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取智能预警列表")
    public ListTemp getFireList() {
        PageHelper.startPage(1, 20);
        EntityWrapper ew = new EntityWrapper();
        ew.orderBy("create_time", false);

        PageInfo<Fire> pageInfo = new PageInfo<Fire>(fireService.selectList(ew));

        ListTemp listTemp = new ListTemp();
        listTemp.setCode(0);
        listTemp.setCount((int) pageInfo.getTotal());

        Param param = ParamData.param;

        List<Fire> list = pageInfo.getList();

        if (list != null) {
            for (Fire fire : pageInfo.getList()) {
                AlgorithmUtil.algorithm(fire, param);
            }
        }

        listTemp.setData(list);
        return listTemp;
    }

}
