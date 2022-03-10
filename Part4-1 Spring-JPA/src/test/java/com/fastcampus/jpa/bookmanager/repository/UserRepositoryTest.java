package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    // create, read, update, delete
    @Test
    void crud() {
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

    @Test
    void crud4() {
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
//        userRepository.save(new User("new martin", "newmartin@fastcampus.com"));
//        userRepository.flush();
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crud5() {
        long count = userRepository.count();
        boolean exists = userRepository.existsById(1L);
        System.out.println(count);
        System.out.println(exists);
    }

    @Test
    void crud6() {
        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        userRepository.deleteById(2L);
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(3L, 4L)));
        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(3L, 4L)));
        userRepository.deleteAll();
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crud7() {
        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));

        System.out.println("page : " + users);
        System.out.println("totalElements : " + users.getTotalElements());
        System.out.println("totalPages : " + users.getTotalPages());
        System.out.println("numberOfElements : " + users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size : " + users.getSize());

        users.getContent().forEach(System.out::println);
    }

    @Test
    void crud8() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")    // name 제외
                .withMatcher("email", endsWith());
        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);
        userRepository.findAll(example).forEach(System.out::println);

        User user = new User();
        user.setEmail("slow");
        matcher = ExampleMatcher.matching().withMatcher("email", contains());
        example = Example.of(user, matcher);
        userRepository.findAll(example).forEach(System.out::println);
    }
}