package com.hb.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-02 15:21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//在序列化的过程给属性换一个位置
//@JsonPropertyOrder(value = {"title","author"})
public class Article {
    //@JsonIgnore  //不参与序列化和反序列化
    private Long id;
    //@JsonProperty("auther") //给属性起一个别名
    private String author;
    private String title;
    private String content;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String createTime;
    private List<Reader> reader;
}