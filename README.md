1) Удаление вроде бы работает, но есть ощущение что сделал что-то лишнее, спустя пару часов копания так и не понял что именно
2) Метод createUser переместил в UserController, так как в UserView мы в любом случае работаем с контроллером, а больше метод нигде кроме view не используется
    Из непонятного: метод Prompt так же перекочевал в UserController(хотя прекрасно понимаю что так нарушается принцип единства ответсвенности), не получилось его реализовать так, чтобы ничего не крашилось.
   UserValidator: так как при создании юзера используется метод createUser, который возвращает User'a, исключение вылетает после того как метод отработает, а не после создания строки, В КАЧЕСТВЕ ЗАТЫЧКИ, я добавил проверку в метод Prompt, так как не увидел других вариантов
4) ИЗМЕНЕНИЯ: вызов команд изменен на цифры вместо Commands  
