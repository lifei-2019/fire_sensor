package com.l.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.l.bean.Fire;
import com.l.dao.FireDao;
import com.l.service.IFireService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author l
 * @since 2019-04-14
 */
@Service("fireServiceImpl")
public class FireServiceImpl extends ServiceImpl<FireDao, Fire> implements IFireService {

}
