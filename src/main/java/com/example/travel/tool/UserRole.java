package com.example.travel.tool;
/**
 * @author qsj
 * @create 02 - 23:25
 */
public class UserRole {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String phone;
    private Integer roleId;
    private String roleName;//角色

//    public UserRole(User user, int roleId, String roleName) {
//        this.id = user.getId();
//        this.name = user.getName();
//        this.gender = user.getGender();
//        this.age = user.getAge();
//        this.phone = user.getPhone();
//        this.roleId = roleId;
//        this.roleName = roleName;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
