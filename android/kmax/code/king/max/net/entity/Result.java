package king.max.net.entity;

/**
 * Description: 统一返回对象
 */
public class Result<T> {
    public static final int SUCCESS = 0;
    public static final int FAILED = -1;

    /* 返回状态码 */
    private int status;
    /* 提示信息 */
    private String msg;
    /* Token */
    private String token;
    /* 数据对象 */
    private T content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
