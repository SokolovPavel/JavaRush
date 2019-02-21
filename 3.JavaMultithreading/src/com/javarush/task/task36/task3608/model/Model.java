package com.javarush.task.task36.task3608.model;

public interface Model {
    void loadDeletedUsers() ;
    ModelData getModelData();
    void loadUsers();
    void loadUserById(long userId);
    public void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
