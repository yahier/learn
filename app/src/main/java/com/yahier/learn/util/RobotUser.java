package com.yahier.learn.util;

import com.hyphenate.easeui.domain.EaseUser;

/**
 * Created by Administrator on 2016/10/31.
 */

public class RobotUser extends EaseUser {
    public RobotUser(String username) {
        super(username.toLowerCase());
    }
}
