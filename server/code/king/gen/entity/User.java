package king.gen.entity;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.token
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.nick
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String nick;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer typeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.icon_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer iconId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.state_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer stateId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.id
     *
     * @return the value of tb_user.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.id
     *
     * @param id the value for tb_user.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.name
     *
     * @return the value of tb_user.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.name
     *
     * @param name the value for tb_user.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.token
     *
     * @return the value of tb_user.token
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.token
     *
     * @param token the value for tb_user.token
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.nick
     *
     * @return the value of tb_user.nick
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getNick() {
        return nick;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.nick
     *
     * @param nick the value for tb_user.nick
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.type_id
     *
     * @return the value of tb_user.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.type_id
     *
     * @param typeId the value for tb_user.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.icon_id
     *
     * @return the value of tb_user.icon_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getIconId() {
        return iconId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.icon_id
     *
     * @param iconId the value for tb_user.icon_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.state_id
     *
     * @return the value of tb_user.state_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getStateId() {
        return stateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.state_id
     *
     * @param stateId the value for tb_user.state_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
}