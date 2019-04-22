package entity;

public class Result {
    private boolean flag;
    private Integer code;
    private String massage;
    private Object data;

    public Result() {
    }

    public Result(boolean flag, Integer code, String massage) {
        this.flag = flag;
        this.code = code;
        this.massage = massage;
    }

    public Result(boolean flag, Integer code, String massage, Object data) {
        this.flag = flag;
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
