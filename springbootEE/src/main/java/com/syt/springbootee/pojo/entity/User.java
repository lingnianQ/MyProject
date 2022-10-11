package com.syt.springbootee.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;

    private String username;

    private String password;

    private Integer loginCount;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

}
