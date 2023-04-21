package portalService.test2.user;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

class UserDaoTest {

    @Test
    public void get() throws SQLException {

        Long id = 1l;
        String name = "umdu";
        String password = "1234";

        UserDao userDao = new UserDao();
        User user = userDao.findById(1l);

        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);

    }

    @Test
    public void insert() throws SQLException {

        String name = "엄두용";
        String password = "2222";
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new UserDao();
        userDao.insert(user);

        User insertedUser = userDao.findById(user.getId());

        assertThat(insertedUser.getId()).isGreaterThan(1l);
        assertThat(insertedUser.getId()).isEqualTo(user.getId());
        assertThat(insertedUser.getName()).isEqualTo(user.getName());
        assertThat(insertedUser.getPassword()).isEqualTo(user.getPassword());
    }

}