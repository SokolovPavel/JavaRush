package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("C://PDF//3");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setBirthDate(new Date(1538470184947L));
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);
            user.setLastName("Sviridov");
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            if(users != null){
                writer.println("yes");
                writer.println(users.size());
                for(int i=0;i< users.size();i++){
                    if(users.get(i).getFirstName() != null){
                        writer.println("yes");
                        writer.println(users.get(i).getFirstName());
                    }
                    else writer.println("no");

                    if(users.get(i).getLastName() != null){
                        writer.println("yes");
                        writer.println(users.get(i).getLastName());
                    }
                    else writer.println("no");

                    if(users.get(i).getBirthDate() != null){
                        writer.println("yes");
                        writer.println(users.get(i).getBirthDate().getTime());
                    }
                    else writer.println("no");

                    if(users.get(i).getCountry() != null){
                        writer.println("yes");
                        writer.println(users.get(i).getCountry());
                    }
                    else writer.println("no");

                    if(users.get(i).isMale() == true){
                        writer.println("yes");
                    }
                    else writer.println("no");

                    writer.flush();
                }
            }else writer.println("no");
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if(!reader.ready()) {System.out.println("Error =("); return;}

            if(reader.readLine().equals("yes")){
                int count = Integer.parseInt(reader.readLine());
                for(int i=0;i < count; i++){
                    User user = new User();
                    if(reader.readLine().equals("yes")){
                        user.setFirstName(reader.readLine());
                    }

                    if(reader.readLine().equals("yes")){
                        user.setLastName(reader.readLine());
                    }

                    if(reader.readLine().equals("yes")){
                        user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    }

                    if(reader.readLine().equals("yes")){
                        String country = reader.readLine();
                        if(country.equals("RUSSIA"))user.setCountry(User.Country.RUSSIA);
                        if(country.equals("UKRAINE"))user.setCountry(User.Country.UKRAINE);
                        if(country.equals("OTHER"))user.setCountry(User.Country.OTHER);
                    }

                    if(reader.readLine().equals("yes")){
                        user.setMale(true);
                    }else
                    {
                        user.setMale(false);
                    }
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
