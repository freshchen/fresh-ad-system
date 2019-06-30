package com.ecnu.lingc.ad.sponsor.service;

import com.ecnu.lingc.ad.common.exception.AdException;
import com.ecnu.lingc.ad.sponsor.vo.CreateUserRequest;
import com.ecnu.lingc.ad.sponsor.vo.CreateUserResponse;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * */
    CreateUserResponse createUser(CreateUserRequest request)
            throws AdException;
}
