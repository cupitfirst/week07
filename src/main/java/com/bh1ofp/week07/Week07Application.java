package com.bh1ofp.week07;

import com.bh1ofp.week07.dao.UserRepository;
import com.bh1ofp.week07.entity.User;
import com.bh1ofp.week07.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class Week07Application implements CommandLineRunner {

    private final DataSource dataSource;

    @Resource
    private UserRepository userRepository;

    @Resource
    private OrderService orderService;

    public Week07Application(DataSource dataSource){
        this.dataSource =  dataSource;
    }

    public static void main(String[] args) {

        SpringApplication.run(Week07Application.class, args);


    }

    @Override
    public void run(String[] args) throws Exception {

        if (dataSource != null) {
            printDataSourceInfo(dataSource);
            log.info("Connect to datasource success.");

            List<User> userList = userRepository.queryUser();
            System.out.println(userList.size());

            for (User user: userList) {
                System.out.println(user.getUsername());

            }
            orderService.insertOrders();

        } else {
            log.error("Connect to datasource failed!");
        }
    }

    private void printDataSourceInfo(DataSource dataSource) throws SQLException {

        Connection connection;
        if (dataSource != null) {
            connection = dataSource.getConnection();
        } else {
            log.error("Get dataSource failed!");
            return;
        }

        if (connection != null) {
            log.info("DataSource Url: {}", connection.getMetaData().getURL());
        } else {
            log.error("Connect to datasource failed!");
        }
    }
}
