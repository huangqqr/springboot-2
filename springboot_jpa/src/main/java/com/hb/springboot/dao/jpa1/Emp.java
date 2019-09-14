package com.hb.springboot.dao.jpa1;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-14 16:29
 **/

@Data
@Entity
public class Emp {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;
}