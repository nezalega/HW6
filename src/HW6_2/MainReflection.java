package HW6_2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainReflection {
    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {

        Class<Person> personClass = Person.class;

//getMethod("name") Person
        List<String> methodNames1 = new ArrayList<>();
        try {
            Method metGetAge = personClass.getMethod("getAge", null);
            methodNames1.add(metGetAge.getName());
            Method metSetAge = personClass.getMethod("setAge", int.class);
            methodNames1.add(metSetAge.getName());
            Method metGetDateOfBirth = personClass.getMethod("getDateOfBirth", null);
            methodNames1.add(metGetDateOfBirth.getName());
            Method metSetDateOfBirth = personClass.getMethod("setDateOfBirth", String.class);
            methodNames1.add(metSetDateOfBirth.getName());
            Method metGetLastName = personClass.getMethod("getLastName", null);
            methodNames1.add(metGetLastName.getName());
            Method metSetLastName = personClass.getMethod("setLastName", String.class);
            methodNames1.add(metSetLastName.getName());
            System.out.println("---Person methods---");
            System.out.println("getMethod(\"name\") print: " + methodNames1.toString());

//getMethods() Person
            Method[] methodsPerson = personClass.getMethods();
            for (Method me : methodsPerson) {
                System.out.print(me.getName() + ", ");
            }
//getMethods() User
            Class<User> userClass = User.class;
            Method[] methodsUser = userClass.getMethods();
            System.out.println("\n---User methods---");
            for (Method me : methodsUser) {
                System.out.print(me.getName() + ", ");
            }
//getMethod("name") User
            List<String> methodNames2 = new ArrayList<>();
            methodNames2.add(userClass.getMethod("getPassword").getName());
            methodNames2.add(userClass.getMethod("setPassword", String.class).getName());
            methodNames2.add(userClass.getMethod("getEmail", null).getName());
            methodNames2.add(userClass.getMethod("setEmail", String.class).getName());
            methodNames2.add(userClass.getMethod("printUserInfo", null).getName());
            System.out.println("\ngetMethod(\"name\") print: " + methodNames2.toString());
//getFields() Person
            Field[] publicFieldsPerson = personClass.getFields();
            System.out.println("Fields of Person: ");
            for (Field fe : publicFieldsPerson) {
                System.out.println(fe.getName() + " ");
            }
//getField("name") Person
            Field firstNameField = personClass.getField("firstName");
            System.out.println("public field - " + firstNameField.getName());
//getFields() User
            Field[] publicFieldsUser = userClass.getFields();
            System.out.println("Fields of user: ");
            for (Field fe : publicFieldsUser) {
                System.out.print(fe.getName() + " ");
            }
//getField("name") User

            Field loginField = userClass.getField("login");
            Field firstNameField1 = userClass.getField("firstName");
            System.out.println("\npublic field - " + loginField.getName() + ", " + firstNameField1.getName());
//getDeclaredMethod("name") Person
            List<String> methodNames11 = new ArrayList<>();
            methodNames11.add(personClass.getDeclaredMethod("getAge", null).getName());
            methodNames11.add(personClass.getDeclaredMethod("setAge", int.class).getName());
            methodNames11.add(personClass.getDeclaredMethod("getDateOfBirth", null).getName());
            methodNames11.add(personClass.getDeclaredMethod("setDateOfBirth", String.class).getName());
            methodNames11.add(personClass.getDeclaredMethod("getLastName", null).getName());
            methodNames11.add(personClass.getDeclaredMethod("setLastName", String.class).getName());
            System.out.println("\ngetDeclaredMethod(\"name\") Person print: " + methodNames11.toString());
//getDeclaredMethod("name") User
            List<String> methodNames22 = new ArrayList<>();
            methodNames22.add(userClass.getDeclaredMethod("getPassword").getName());
            methodNames22.add(userClass.getDeclaredMethod("setPassword", String.class).getName());
            methodNames22.add(userClass.getDeclaredMethod("getEmail", null).getName());
            methodNames22.add(userClass.getDeclaredMethod("setEmail", String.class).getName());
            methodNames22.add(userClass.getDeclaredMethod("printUserInfo", null).getName());
            System.out.println("\ngetDeclaredMethod(\"name\") User print: " + methodNames22.toString());
// getDeclaredMethods() User
            Method[] declMethodsUser = userClass.getDeclaredMethods();
            System.out.println("\ndeclared methods User");
            for (Method me : declMethodsUser) {
                System.out.print(me.getName() + ", ");
            }
//getDeclaredMethods() Person
            Method[] declMethodsPerson = personClass.getDeclaredMethods();
            System.out.println("\ndeclared methods Person");
            for (Method me : declMethodsPerson) {
                System.out.print(me.getName() + ", ");
            }
//getDeclaredField("name") User
            Field decpasswordField = userClass.getDeclaredField("password");
            Field decemailField = userClass.getDeclaredField("email");
            System.out.println(
                    "\ndeclared field(\"name\") User - " + decpasswordField.getName() + ", " + decemailField.getName());
//getDeclaredFields() User
            Field[] declFieldsUser = userClass.getDeclaredFields();
            System.out.println("\nDeclaredFields() User: ");
            for (Field fi : declFieldsUser) {
                System.out.print(fi.getName() + " ");
            }
//getDeclaredField("name") Person
            Field decLastNameField = personClass.getDeclaredField("lastName");
            Field decDateOfBirthField = personClass.getDeclaredField("dateOfBirth");
            Field decAgeField = personClass.getDeclaredField("age");
            System.out.println("\ndeclared field(\"name\") Person - " + decLastNameField.getName() + ", "
                    + decDateOfBirthField.getName() + ", " + decAgeField.getName());
// getDeclaredFields() Person
            Field[] declFieldsPerson = personClass.getDeclaredFields();
            System.out.println("\nDeclaredFields() Person: ");
            for (Field fi : declFieldsPerson) {
                System.out.print(fi.getName() + " ");
            }
//set and get fields with Reflection
            Person person1 = new Person("1", "2", 3, "4");
            firstNameField.set(person1, "tom");
            decLastNameField.setAccessible(true);
            decLastNameField.set(person1, "jackson");
            decDateOfBirthField.setAccessible(true);
            decDateOfBirthField.set(person1, "15-05-1961");
            decAgeField.setAccessible(true);
            decAgeField.set(person1, 38);
            System.out.println("\nPerson 1 info: " + (String) firstNameField.get(person1) + " "
                    + (String) decLastNameField.get(person1) + " " + (String) decDateOfBirthField.get(person1)
                    + ", age " + (Integer) decAgeField.get(person1));

            User user1 = new User("5", "6", 7, "8", "9", "10", "11");
            loginField.set(user1, "loginUserStas");
            decpasswordField.setAccessible(true);
            decpasswordField.set(user1, "951753");
            decemailField.setAccessible(true);
            decemailField.set(user1, "mmm@ all.by");
            firstNameField1.set(user1, "Julia");
            decLastNameField.setAccessible(true);
            decLastNameField.set(user1, "frog");
            decDateOfBirthField.setAccessible(true);
            decDateOfBirthField.set(user1, "11-11-922");
            decAgeField.setAccessible(true);
            decAgeField.set(user1, 138);
            System.out.println("User 1 info: " + (String) firstNameField.get(user1) + " "
                    + (String) decLastNameField.get(user1) + " " + (String) decDateOfBirthField.get(user1) + ", age "
                    + (Integer) decAgeField.get(user1) + "\nlogin <" + loginField.get(user1) + "> password <"
                    + decpasswordField.get(user1) + "> email: " + (String) decemailField.get(user1));

//method toString with invoke
            Method toStr = userClass.getMethod("toString", null);
            String result = (String) toStr.invoke(user1, null);
            System.out.println("invoke:::::::: " + result);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}