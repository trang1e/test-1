package com.test.vo;

/**
 *
 *
 * @author wulha
 * @date 2019-01-03
 */
public class ResultVo<T> {

    public static String SUCCESS_RET_CODE = "000000";

    public static String SUCCESS_RET_MSG = "success";

    public static String ERROR_RET_CODE = "111111";

    public static String ERROR_RET_MSG = "error";


    private String retCode;

    private String retMsg;

    T data;

    public ResultVo(String retCode, String retMsg, T data) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public static <T> ResultVo<T> success(T data) {
        return new ResultVo<>(SUCCESS_RET_CODE, SUCCESS_RET_MSG, data);
    }

    public static <T> ResultVo<T> error(T data) {
        return new ResultVo<>(ERROR_RET_CODE, ERROR_RET_MSG, data);
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
            "retCode='" + retCode + '\'' +
            ", retMsg='" + retMsg + '\'' +
            ", data=" + data +
            '}';
    }
}
