package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;
import java.util.List;

public class FacultyDirectory {

    private final List<FacultyProfile> facultyList;

    public FacultyDirectory() {
        this.facultyList = new ArrayList<>();
    }

    public List<FacultyProfile> getFacultyList() {
        return facultyList;
    }

    public FacultyProfile createFacultyProfile(Person person) {
        FacultyProfile facultyProfile = new FacultyProfile(person);
        facultyList.add(facultyProfile);
        return facultyProfile;
    }
}
