public class Person {
    private String personID;
    private String name;

    public Person(String personID, String name) 
    {
        this.personID = personID;
        this.name = name;
    }

    public String getPersonID() 
    { 
        return personID; 
    }
    public String getName() 
    { 
        return name; 
    }

    public void setPersonID(String personID) 
    { 
        this.personID = personID; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }

    @Override
    public String toString() {
        return "ID: " + personID + ", Name: " + name;
    }
}
