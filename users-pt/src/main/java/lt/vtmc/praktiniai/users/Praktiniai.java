package lt.vtmc.praktiniai.users;

import java.util.Comparator;
import java.util.List;

public class Praktiniai {

    public static Integer countUsersOlderThen25(List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");
        int olderThen25 = 0;
        for (User user : users) {
            if (user.getAge() > 25) {
                olderThen25++;
            }
        }
        return olderThen25;
    }

    public static double getAverageAge(List<User> users) {

//        throw new UnsupportedOperationException("Not implemented");

        int allAges = 0;
        for (User user : users) {
            allAges += user.getAge();
        }

        return (double) allAges / users.size();
    }

    public static Integer getMinAge(List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");

        int minAge = users.get(0).getAge();
        for (User user : users) {
            if(user.getAge() < minAge) {
                minAge = user.getAge();
            }
        }
        return minAge;
    }

    public static User findByName(List<User> users, String name) {
//        throw new UnsupportedOperationException("Not implemented");
        User userByName = users.get(0);
        for (User user : users) {
            if(user.getName().equals(name)) {
                userByName = user;
            }
        }
        return userByName;
    }

    public static List<User> sortByAge(List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");

        users.sort((a, b) -> a.getAge().compareTo(b.getAge()));
//        users.sort(Comparator.comparing(User::getAge));
        return users;
    }

    public static User findOldest(List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");
        User oldest = users.get(0);
        int oldestAge = 0;
        for (User user : users) {
            if(user.getAge() > oldestAge) {
                oldestAge = user.getAge();
                oldest = user;
            }
        }
        return oldest;
    }

    public static int sumAge(List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");
        int sumOfAges = 0;
        for (User user : users) {
            sumOfAges += user.getAge();
        }
        return sumOfAges;
    }

}
