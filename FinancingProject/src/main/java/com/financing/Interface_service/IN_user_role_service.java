package com.financing.Interface_service;

import java.util.List;

import com.financing.bean.User_role;



public interface IN_user_role_service {
      List<User_role>list_user_role();
      User_role getById(int id);
}
