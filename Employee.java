public class Employee extends Person 
{
    private String jobTitle;
    private String managerID;
    private int numberOfDeals;

    public Employee(String personID, String name, String jobTitle, String managerID) 
    {
        super(personID, name);
        this.jobTitle = jobTitle;
        this.managerID = managerID;
        this.numberOfDeals = 0;
    }

    public String getJobTitle() 
    { 
        return jobTitle; 
    }
    public String getManagerID() 
    { 
        return managerID; 
    }
    public int getNumberOfDeals() 
    { 
        return numberOfDeals; 
    }

    public void setJobTitle(String jobTitle) 
    { 
        this.jobTitle = jobTitle; 
    }
    public void setManagerID(String managerID) 
    { 
        this.managerID = managerID; 
    }
    public void recordADeal() 
    { 
        this.numberOfDeals++; 
    }

    @Override
    public String toString() 
    {
        return super.toString() + ", Job Title: " + jobTitle + ", Manager ID: " + managerID + ", Deals: " + numberOfDeals;
    }
}