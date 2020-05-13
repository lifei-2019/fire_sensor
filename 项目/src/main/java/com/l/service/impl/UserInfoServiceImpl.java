package com.l.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.l.bean.UserInfo;
import com.l.dao.UserInfoDao;
import com.l.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author l
 * @since 2019-04-14
 */
@Service("userInfoServiceImpl")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements IUserInfoService {

}
