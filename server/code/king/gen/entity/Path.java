package king.gen.entity;

public class Path {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_path.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_path.base_path
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    private String basePath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_path.id
     *
     * @return the value of tb_path.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_path.id
     *
     * @param id the value for tb_path.id
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_path.base_path
     *
     * @return the value of tb_path.base_path
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_path.base_path
     *
     * @param basePath the value for tb_path.base_path
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath == null ? null : basePath.trim();
    }
}