package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("Ivan", "Ivanov", "ivan@mail.ru", new Car("BMV", 7)));
        userService.add(new User("Sergey", "Sergeev", "sergey@mail.ru", new Car("FORD", 150)));
        userService.add(new User("Egor", "Egorov", "egor@mail.ru", new Car("VOLVO", 747)));
        userService.add(new User("Stas", "Stasov", "stas@mail.ru", new Car("AUDI", 5)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        userService.getUserByCarModelAndSeries("AUDI", 5);
    }

    }




