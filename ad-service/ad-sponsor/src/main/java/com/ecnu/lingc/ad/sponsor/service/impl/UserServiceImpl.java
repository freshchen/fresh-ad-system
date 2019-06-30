package com.ecnu.lingc.ad.sponsor.service.impl;


import com.ecnu.lingc.ad.common.exception.AdException;
import com.ecnu.lingc.ad.sponsor.constant.Constants;
import com.ecnu.lingc.ad.sponsor.dao.AdUserRepository;
import com.ecnu.lingc.ad.sponsor.entity.AdUser;
import com.ecnu.lingc.ad.sponsor.service.IUserService;
import com.ecnu.lingc.ad.sponsor.utils.CommonUtils;
import com.ecnu.lingc.ad.sponsor.vo.CreateUserRequest;
import com.ecnu.lingc.ad.sponsor.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request)
            throws AdException {

        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdUser oldUser = userRepository.
                findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        AdUser newUser = userRepository.save(new AdUser(
                request.getUsername(),
                CommonUtils.md5(request.getUsername())
        ));

        return new CreateUserResponse(
                newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime()
        );
    }
}
