package com.syt.springbootee.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:29
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddNewDTO {

    private String username;

    private String password;
}
