package userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")

    private List<User> users = new LinkedList<>();

    public List<User> getUsers() {
        return users;
    }

    public synchronized boolean add(User user) {
        return users.add(user);
    }

    public synchronized boolean delete(User user) {
        return users.remove(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        if (users.contains(user)) {
            users.get(users.indexOf(user)).setAmount(user.getAmount());
            result = true;
        }
        return result;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User fromUser = new User(fromId);
        User toUser = new User(toId);
        if (users.contains(fromUser) && users.contains(toUser)) {
            users.get(users.indexOf(fromUser)).setAmount(users.get(users.indexOf(fromUser)).getAmount() - amount);
            users.get(users.indexOf(toUser)).setAmount(users.get(users.indexOf(toUser)).getAmount() + amount);
            result = true;
        }
        return result;
    }

}
