package king.gen.entity;

public class Type {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_type.id
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_type.item_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    private String itemType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_type.id
     *
     * @return the value of tb_type.id
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_type.id
     *
     * @param id the value for tb_type.id
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_type.item_type
     *
     * @return the value of tb_type.item_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_type.item_type
     *
     * @param itemType the value for tb_type.item_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }
}