package king.gen.mapper;

import java.util.List;
import king.gen.entity.Account;
import king.gen.entity.AccountExample;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    long countByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int deleteByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int insertSelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    List<Account> selectByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    Account selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbg.generated Sat Sep 07 12:14:41 CST 2019
     */
    int updateByPrimaryKey(Account record);
}