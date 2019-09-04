package king.gen.mapper;

import java.util.List;
import king.gen.entity.Type;
import king.gen.entity.TypeExample;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    long countByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int deleteByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int insert(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int insertSelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    List<Type> selectByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    Type selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int updateByPrimaryKeySelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_type
     *
     * @mbg.generated Wed Sep 04 11:33:11 CST 2019
     */
    int updateByPrimaryKey(Type record);
}