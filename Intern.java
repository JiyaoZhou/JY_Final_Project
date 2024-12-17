public class Intern extends Employee {
    private String university;

    public Intern(String personID, String name, String jobTitle, String university) {
        super(personID, name, jobTitle, "None");
        this.university = university;
    }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    @Override
    public String toString() {
        return super.toString() + ", University: " + university;
    }
}
