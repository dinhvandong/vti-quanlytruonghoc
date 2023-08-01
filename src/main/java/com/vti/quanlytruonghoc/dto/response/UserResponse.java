package com.vti.quanlytruonghoc.dto.response;

import com.vti.quanlytruonghoc.models.User;
import com.vti.quanlytruonghoc.models.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private User user;
    private UserProfile userProfile;
}
