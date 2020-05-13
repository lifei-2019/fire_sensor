package com.l.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.l.bean.Device;
import com.l.dao.DeviceDao;
import com.l.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author l
 * @since 2019-04-15
 */
@Service("deviceServiceImpl")
public class DeviceServiceImpl extends ServiceImpl<DeviceDao, Device> implements IDeviceService {

    @Autowired
    private DeviceDao deviceDao;

}
