package king.gen.entity;

public class State {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_state.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_state.state
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_state.profile
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String profile;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_state.id
     *
     * @return the value of tb_state.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_state.id
     *
     * @param id the value for tb_state.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_state.state
     *
     * @return the value of tb_state.state
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_state.state
     *
     * @param state the value for tb_state.state
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_state.profile
     *
     * @return the value of tb_state.profile
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getProfile() {
        return profile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_state.profile
     *
     * @param profile the value for tb_state.profile
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }
}