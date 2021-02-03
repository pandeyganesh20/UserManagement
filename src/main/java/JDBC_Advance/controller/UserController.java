package JDBC_Advance.controller;

import JDBC_Advance.enums.OperationTypeEnum;
import JDBC_Advance.model.User;
import JDBC_Advance.service.UserService;
import JDBC_Advance.service.UserServiceImplementation;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserController {
    public static void main(String[] args) {
        UserService userService = new UserServiceImplementation();

        String decision ;


        do {

            String operation = JOptionPane.showInputDialog("Enter operation save |update|delete|list|get");

            switch (operation) {

                case "save":
                    User savedUser = getUser(OperationTypeEnum.SAVE.name());

                    int saved = userService.saveUser(savedUser);
                    if (saved >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is saved in db sucessfully");
                    } else
                        JOptionPane.showMessageDialog(null, "Opps! error in db");
                    break;


                case "update":

                    User updatedUser = getUser(OperationTypeEnum.UPDATTE.name());

                    int updated = userService.updateUser(updatedUser);
                    if (updated >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is updated in db sucessfully");
                    } else
                        JOptionPane.showMessageDialog(null, "Opps! error in db");

                    break;


                case "delete":
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id:  "));
                    int deleted = userService.deleteUser(id);
                    if (deleted >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is deleted in db sucessfully");
                    } else
                        JOptionPane.showMessageDialog(null, "Opps! error in db");

                    break;


                case "list":
                    userService.getAllUser().forEach(user ->
                    {
                        System.out.println("User id is: " + user.getId());
                        System.out.println(" User name is: " + user.getUserName());
                        System.out.println("User password is: " + user.getPassword());
                        System.out.println("User mobile no  is: " + user.getMobileNo());
                        System.out.println(" User salary is: " + user.getSalary());
                        System.out.println("User dob is is: " + user.getDob());
                        System.out.println("Is user enable: " + user.isEnable());
                        System.out.println("==================");
                    });
                    break;

                case "get":
                    id = Integer.parseInt(JOptionPane.showInputDialog("Enter id:  "));
                    User user = userService.getUserById(id);
                    System.out.println("User id is: " + user.getId());
                    System.out.println(" User name is: " + user.getUserName());
                    System.out.println("User password is: " + user.getPassword());
                    System.out.println("User mobile no  is: " + user.getMobileNo());
                    System.out.println(" User salary is: " + user.getSalary());
                    System.out.println("User dob is is: " + user.getDob());
                    System.out.println("Is user enable: " + user.isEnable());
                    break;
            }

            decision = JOptionPane.showInputDialog("do you want to continue? yes|no");
        }
        while (decision.equalsIgnoreCase("yes"));

    }

    public static User getUser(String type) {
        User user = new User();
        if (type.equalsIgnoreCase("update")) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id:  "));
            user.setId(id);
        }
        String username = JOptionPane.showInputDialog("Enter username:  ");
        String password = JOptionPane.showInputDialog("Enter password:  ");
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:  "));
        long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobileNo:  "));
        boolean enable = Boolean.parseBoolean(JOptionPane.showInputDialog("Is ueser enable?"));
        String dob = JOptionPane.showInputDialog("Enter dob: format=> YYYY-MM_DD");

        LocalDate ld = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        user.setUserName(username);
        user.setPassword(password);
        user.setMobileNo(mobileNo);
        user.setSalary(salary);
        user.setEnable(enable);
        user.setDob(ld);
        return user;
    }
}


