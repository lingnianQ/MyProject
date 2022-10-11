package com.syt.springbootee.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:29
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserListItemVO implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer loginCount;

}
