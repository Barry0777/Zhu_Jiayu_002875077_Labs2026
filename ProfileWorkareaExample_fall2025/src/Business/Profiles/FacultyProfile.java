package Business.Profiles;

import Business.Person.Person;

public class FacultyProfile extends Profile {

    // 角色名称使用常量，避免硬编码
    private static final String ROLE_NAME = "Faculty";

    public FacultyProfile(Person person) {
        super(person);
    }

    @Override
    public String getRole() {
        return ROLE_NAME;
    }
}
