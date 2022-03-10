package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    // create, read, update, delete
    @Test
    void crud() {   // create
        userRepository.save(new User());

        userRepository.findAll().forEach(System.out::println);
//        for (User user : userRepository.findAll())
//            System.out.println(user);
    }

    @Test
    void crud2() {  // create
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
    void crud3() {  // read
        User user = userRepository.getOne(1L);
        User user2 = userRepository.findById(1L).orElse(null);
        System.out.println(user);
        System.out.println(user2);
    }

    @Test
    void crud4() {  // create
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
//        userRepository.save(new User("new martin", "newmartin@fastcampus.com"));
//        userRepository.flush();
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crud5() {  // read
        long count = userRepository.count();
        boolean exists = userRepository.existsById(1L);
        System.out.println(count);
        System.out.println(exists);
    }

    @Test
    void crud6() {  // delete
        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        userRepository.deleteById(2L);
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(3L, 4L)));
        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(3L, 4L)));
        userRepository.deleteAll();
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crud7() {  // read
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
    void crud8() {  // read
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

    @Test
    void crud9() {  // read
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

    @Test
    void crud10() {  // update
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("matin-update@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void select() {
        System.out.println(userRepository.findByName("dennis"));
        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));

        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "dennis"));
        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));

        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));
        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "art" + "%"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Order.desc("id"), Order.asc("email"))));
        System.out.println("findFirstSort : " + userRepository.findFirstByName("martin", getSort()));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Order.desc("id")))).getTotalElements());
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");
        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");
        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    private Sort getSort() {
        return Sort.by(
                Order.desc("id"),
                Order.desc("email"),
                Order.desc("createdAt"),
                Order.desc("updatedAt")
        );
    }
}