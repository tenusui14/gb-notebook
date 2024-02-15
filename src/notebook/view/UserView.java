package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;


public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        //Commands com;

        while (true) {
            System.out.println("Use: 1 - Create new note, 2 - Read note by id, 3 - Read all notes, 4 - Change note," +
                    " 5 - Delete note, 6 - Exit");
            String command = userController.prompt("Введите команду: ");
//            com = Commands.valueOf(command);
            if (command.equals("6")) return;
            switch (command) {
                case "1":
                    User u = userController.createUser();
                    userController.saveUser(u);
                    break;
                case "2":
                    String id = userController.prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    System.out.println(userController.readAll());
                    break;
                case "5":
                    String userIdent = userController.prompt("Enter user id: ");
                    userController.deleteUser(userIdent);
                    break;
                case "4":
                    String userId = userController.prompt("Enter user id: ");
                    userController.updateUser(userId, userController.createUser());

            }
        }
    }




}
