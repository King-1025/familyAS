package king.gen.entity;

public class Who {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_who.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_who.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_who.address
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_who.phone
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_who.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer typeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_who.id
     *
     * @return the value of tb_who.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_who.id
     *
     * @param id the value for tb_who.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_who.name
     *
     * @return the value of tb_who.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_who.name
     *
     * @param name the value for tb_who.name
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_who.address
     *
     * @return the value of tb_who.address
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_who.address
     *
     * @param address the value for tb_who.address
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_who.phone
     *
     * @return the value of tb_who.phone
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_who.phone
     *
     * @param phone the value for tb_who.phone
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_who.type_id
     *
     * @return the value of tb_who.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_who.type_id
     *
     * @param typeId the value for tb_who.type_id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}