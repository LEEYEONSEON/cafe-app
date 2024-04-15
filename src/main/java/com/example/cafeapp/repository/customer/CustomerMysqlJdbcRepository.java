

package com.example.cafeapp.repository.customer;

import com.example.cafeapp.dto.customer.request.CustomerDeleteRequest;
import com.example.cafeapp.dto.customer.request.CustomerEnrollRequest;
import com.example.cafeapp.dto.customer.request.CustomerUpdateRequest;
import com.example.cafeapp.dto.customer.response.CustomerResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Primary
@Repository
public class CustomerMysqlJdbcRepository implements CustomerJdbcRepository {
    public final JdbcTemplate jdbcTemplate;

    public CustomerMysqlJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void enrollCustomer(CustomerEnrollRequest request) {
        String sql = "insert into customer (name, nick_name) values(?, ?)";
        //위의 sql을 jdbctemplate이 database에 날린다.
        jdbcTemplate.update(sql, request.getName(), request.getNickname());
//        customerList.add(new Customer(request.getName(), request.getNickname()));
    }

    @Override
    public List<CustomerResponse> showCustomer() {
        String sql = "select * from customer";
        return jdbcTemplate.query(sql, new RowMapper<CustomerResponse>() {
            @Override
            public CustomerResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String nickname = rs.getString("nick_name");
                return new CustomerResponse(id, name, nickname);
            }
        });
//        return customerList;
    }

    @Override
    public boolean isNotTargetExist(long id) {
        String readSql = "select * from customer where id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    @Override
    public void updateCustomer(CustomerUpdateRequest request) {
        String sql = "update customer set nick_name = ? where id = ?";
        jdbcTemplate.update(sql, request.getNickname(), request.getId());
        //        customerList.stream()
//                .filter(customer -> customer.getName().equals(request.getName()))
//                .findFirst().get();
    }

    @Override
    public void deleteCustomer(CustomerDeleteRequest request) {
        String sql = "delete from customer where id = ?";
        jdbcTemplate.update(sql, request.getId());
        //        Customer target = customerList.stream()
//                .filter(customer -> customer.getName().equals(request.getName())).findFirst()
//                .get();
//
//        customerList.remove(target);
    }
}
