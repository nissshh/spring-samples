package com.company.project;

public class PersonDTORequest {
    String name;

    Integer age;

    public PersonDTORequest() {
    }

    public PersonDTORequest(String name, Integer age) {

        super();
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {

        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {

        this.age = age;
    }


}
