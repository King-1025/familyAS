package king.gen.entity;

import java.util.Date;

public class Api {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.action
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String action;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.flag
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.check_token
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Boolean checkToken;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.result_format
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String resultFormat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.call_limit
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer callLimit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.call_count
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer callCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.failed
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer failed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.last_time
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Date lastTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.last_request_ip
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String lastRequestIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.path_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer pathId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer typeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_api.state_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer stateId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.id
     *
     * @return the value of tb_api.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.id
     *
     * @param id the value for tb_api.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.name
     *
     * @return the value of tb_api.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.name
     *
     * @param name the value for tb_api.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.action
     *
     * @return the value of tb_api.action
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getAction() {
        return action;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.action
     *
     * @param action the value for tb_api.action
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.flag
     *
     * @return the value of tb_api.flag
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.flag
     *
     * @param flag the value for tb_api.flag
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.check_token
     *
     * @return the value of tb_api.check_token
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Boolean getCheckToken() {
        return checkToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.check_token
     *
     * @param checkToken the value for tb_api.check_token
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setCheckToken(Boolean checkToken) {
        this.checkToken = checkToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.result_format
     *
     * @return the value of tb_api.result_format
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getResultFormat() {
        return resultFormat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.result_format
     *
     * @param resultFormat the value for tb_api.result_format
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setResultFormat(String resultFormat) {
        this.resultFormat = resultFormat == null ? null : resultFormat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.call_limit
     *
     * @return the value of tb_api.call_limit
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getCallLimit() {
        return callLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.call_limit
     *
     * @param callLimit the value for tb_api.call_limit
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setCallLimit(Integer callLimit) {
        this.callLimit = callLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.call_count
     *
     * @return the value of tb_api.call_count
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getCallCount() {
        return callCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.call_count
     *
     * @param callCount the value for tb_api.call_count
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.failed
     *
     * @return the value of tb_api.failed
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getFailed() {
        return failed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.failed
     *
     * @param failed the value for tb_api.failed
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.last_time
     *
     * @return the value of tb_api.last_time
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.last_time
     *
     * @param lastTime the value for tb_api.last_time
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.last_request_ip
     *
     * @return the value of tb_api.last_request_ip
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getLastRequestIp() {
        return lastRequestIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.last_request_ip
     *
     * @param lastRequestIp the value for tb_api.last_request_ip
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setLastRequestIp(String lastRequestIp) {
        this.lastRequestIp = lastRequestIp == null ? null : lastRequestIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.path_id
     *
     * @return the value of tb_api.path_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getPathId() {
        return pathId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.path_id
     *
     * @param pathId the value for tb_api.path_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.type_id
     *
     * @return the value of tb_api.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.type_id
     *
     * @param typeId the value for tb_api.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_api.state_id
     *
     * @return the value of tb_api.state_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getStateId() {
        return stateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_api.state_id
     *
     * @param stateId the value for tb_api.state_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
}