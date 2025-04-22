package com.shobakaBarabaka.collection;


import java.io.IOException;

/**
 * Organization class
 */
public class Organization {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String fullName; //Поле не может быть null
    private OrganizationType type; //Поле может быть null



    {
        try {
            id = IdGenerator.getInstance().generateOrgId();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            id = -1L;
        }
    }


    /**
     * sets {@link Organization}'s name
     * @throws IllegalArgumentException if name doesn't follow restrictions
     * @param name {@link Organization}'s name
     */
    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("name can't be null");
        if (name.isEmpty()) throw new IllegalArgumentException("name can't be empty");
        this.name = name;
    }


    /**
     * sets {@link Organization}'s full name
     * @throws IllegalArgumentException if full name doesn't follow restrictions
     * @param fullName {@link Organization}'s full name
     */
    public void setFullName(String fullName) {
        if (fullName == null) throw new IllegalArgumentException("full name can't be null");
        this.fullName = fullName;
    }


    /**
     * sets {@link Organization}'s type
     * @param type {@link Organization}'s type
     */
    public void setType(OrganizationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", type=" + type +
                '}';
    }
}
