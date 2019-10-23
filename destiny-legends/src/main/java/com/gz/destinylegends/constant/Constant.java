package com.gz.destinylegends.constant;

import java.math.BigDecimal;

public class Constant {

    //**********key值 start**********

    /**
     * 成功状态码key值
     */
    public final static String CODE = "code";

    /**
     * 返回的数据对象key值
     */
    public final static String DATA = "data";

    /**
     * 返回的token状态的key值
     */
    public final static String TOKEN = "token";

    /**
     * 返回消息结果的key值
     */
    public final static String MESSAGE = "message";

    /**
     * 返回对象列表的header的key值
     */
    public final static String HEADER = "header";

    //**********key值 end**********


    //**********状态码 start**********

    /**
     * 成功时的状态码
     */
    public final static Integer CODE_SUCCESS = 20000;

    /**
     * 操作失败时的状态码
     */
    public final static Integer CODE_ERROR = -1;

    /**
     * 查询不到数据时的状态码
     */
    public final static Integer CODE_NOT_SEARCH = 0;

    //**********状态码 end**********


    //**********结果消息 start**********

    /**
     * 登录成功返回消息
     */
    public final static String LOGIN_SUCCESS = "认证成功";

    /**
     * 登录失败返回消息
     */
    public final static String LOGIN_FAILD = "认证失败";

    /**
     * 操作成功返回消息
     */
    public final static String SUCCESS = "操作成功";

    /**
     * 操作失败返回消息
     */
    public final static String ERROR = "操作失败";

    /**
     * 查询不到数据返回消息
     */
    public final static String NOT_SEARCH = "查询不到相应数据";

    //**********结果消息 end**********


    //**********文件相关 start**********

    /**
     * 所有文件的路径
     */
    public final static String FILE_PATH = "/destiny/file";

    /**
     * 图片文件路径
     */
    public final static String IMAGE_PATH = "/destiny/file/image";

    /**
     * 音频文件路径
     */
    public final static String AUDIO_PATH = "/destiny/file/audio";

    /**
     * 所有英雄文件路径
     */
    public final static String HERO_PATH = "/destiny/file/hero";


    public final static String ALLOW_SUFFIX = "[]";

    //**********文件相关 end**********


    //**********数字相关 start**********

    /**
     * 小数点保留位数
     */
    public final static Integer SCALE = 2;

    /**
     * 数字取整规则
     */
    public final static Integer ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

    //**********数字相关 end**********

}
