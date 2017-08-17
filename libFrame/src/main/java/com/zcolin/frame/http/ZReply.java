/*
 * *********************************************************
 *   author   colin
 *   company  fosung
 *   email    wanglin2046@126.com
 *   date     17-2-8 上午9:40
 * ********************************************************
 */

package com.zcolin.frame.http;

/**
 * Http报文返回数据的处理接口
 * 如果使用{@link com.zcolin.frame.http.response.ZResponse},则实体需要实现此接口
 */
public interface ZReply {
    /**
     * 是否是成功的信息，用来判定服务器处理了信息之后返回的是否为正确的数据
     */
    boolean isSuccess();

    /**
     * 获取和服务器约定的返回码
     */
    int getReplyCode();

    /**
     * 获取 如果请求错误的错误信息
     */
    String getErrorMessage();
}
