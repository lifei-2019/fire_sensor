package com.l.controller;

import com.l.common.Param;
import com.l.common.ParamData;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("model")
@Api(description = "模型管理")
@Controller
public class ModelController {

    @RequestMapping(value = "getParam", method = RequestMethod.GET)
    @ResponseBody
    public Param getParam() {
        return ParamData.param;
    }

    @RequestMapping(value = "updateParam", method = RequestMethod.POST)
    @ResponseBody
    public boolean getParam(Param param) {
        ParamData.param.setFactor(param.getFactor());
        ParamData.param.setMinHeight(param.getMinHeight());
        ParamData.param.setArea(param.getArea());
        ParamData.param.setInterval(param.getInterval());
        ParamData.param.setBuildHeight(param.getBuildHeight());
        return true;
    }

}
