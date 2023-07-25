package com.huangqi.servicebase.exceptionhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Myexception extends RuntimeException{
    private Integer code;
    private String msg;
}
