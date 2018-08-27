package userstorage;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class UserStorageTest {
    UserStorage userStorage = new UserStorage();


    @Test
    public void whenAdd() {
        User user = new User(1);
        userStorage.add(user);
        assertThat(userStorage.getUsers().get(0), is(user));
    }

    @Test
    public void whenDelete() {
        User user1 = new User(1);
        User user2 = new User(1);
        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.delete(user1);
        assertThat(userStorage.getUsers().get(0), is(user2));
    }

    @Test
    public void whenUpdate() {
        User user = new User(1, 100);
        userStorage.add(user);
        userStorage.update(new User(1, 150));
        assertThat(userStorage.getUsers().get(0).getAmount(), is(150));
    }

    @Test
    public void whenTransfer() {
        User user1 = new User(1, 100);
        User user2 = new User(2, 150);
        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.transfer(2, 1, 100);
        assertThat(userStorage.getUsers().get(0).getAmount(), is(200));
        assertThat(userStorage.getUsers().get(1).getAmount(), is(50));
    }



}