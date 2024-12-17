public class Manager extends Employee {
    private int teamSize;

    public Manager(String personID, String name, String jobTitle, int teamSize) {
        super(personID, name, jobTitle, "None");
        this.teamSize = teamSize;
    }

    public int getTeamSize() { return teamSize; }
    public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

    @Override
    public String toString() {
        return super.toString() + ", Team Size: " + teamSize;
    }
}