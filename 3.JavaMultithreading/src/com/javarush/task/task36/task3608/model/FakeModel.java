package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.LinkedList;

public class FakeModel implements Model{
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUsers() {
        LinkedList<User> users = new LinkedList<>();
        users.add(new User("Lesha",1,9));
        users.add(new User("Vanya",2,15));
        users.add(new User("Pasha",5,35));
        modelData.setUsers(users);
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    private ModelData modelData = new ModelData();
}
