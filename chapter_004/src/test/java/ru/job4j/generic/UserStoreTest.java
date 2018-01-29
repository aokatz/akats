package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    @Test
    public void whenAddShouldAdd() {
        UserStore userStore = new UserStore();
        User user = new User("1");
        userStore.add(user);
        assertThat(userStore.findById("1"), is(user));
    }

    @Test
    public void whenReplaceShouldAdd() {
        UserStore userStore = new UserStore();
        User user = new User("10");
        userStore.add(new User("1"));
        userStore.add(new User("2"));
        assertThat(userStore.replace("1", user), is(true));
    }

    @Test
    public void whenDeleteShouldDelete() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        roleStore.add(new Role("2"));
        assertThat(roleStore.delete("1"), is(true));
    }

    @Test
    public void whenFindByIdShouldFind() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("10");
        roleStore.add(new Role("1"));
        roleStore.add(role);
        roleStore.add(new Role("2"));
        assertThat(roleStore.findById("10"), is(role));
    }

}