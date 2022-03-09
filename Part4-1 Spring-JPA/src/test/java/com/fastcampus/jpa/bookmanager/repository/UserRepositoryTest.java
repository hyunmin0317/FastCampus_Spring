package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {   // create, read, update, delete
        userRepository.save(new User());

        userRepository.findAll().forEach(System.out::println);
//        for (User user : userRepository.findAll())
//            System.out.println(user);
    }

    @Test
    void crud2() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        List<User> users2 = userRepository.findAllById(Lists.newArrayList(1L, 2L, 5L));
        users.forEach(System.out::println);
        users2.forEach(System.out::println);

        User user1 = new User("jack", "jack@naver.com");
        User user2 = new User("steve", "steve@gmail.com");
        userRepository.save(user1);
        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users3 = userRepository.findAll();
        users3.forEach(System.out::println);
    }

    @Test
    @Transactional
    void crud3() {
        User user = userRepository.getOne(1L);
        User user2 = userRepository.findById(1L).orElse(null);
        System.out.println(user);
        System.out.println(user2);
    }
}