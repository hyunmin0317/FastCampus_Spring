package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

class UserTest {
    @Test
    void test() {
        User user = new User();
        User user1 = new User("hyunmin", "choihm9903@naver.com", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("hyunmin", "choihm9903@hanmail.net");
        User user3 = User.builder().name("hyunmin").email("choihm9903@gmail.com").build();

        user.setEmail("choihm9903@naver.com");
        user.setName("hyunmin");

        System.out.println(">>> "+user);
        System.out.println(">>> "+user1);
        System.out.println(">>> "+user2);
        System.out.println(">>> "+user3);
    }
}