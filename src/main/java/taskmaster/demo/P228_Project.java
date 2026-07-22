package taskmaster.demo;

public class P228_Project {

    private int projectId;

    private String projectCode;

    private String projectName;

    private String description;

    private String startDate;

    private String endDate;

    private double budget;

    private String priority;

    private String status;

    private int managerId;

    // Default Constructor
    public P228_Project() {

    }

    // Parameterized Constructor
    public P228_Project(int projectId,
                        String projectCode,
                        String projectName,
                        String description,
                        String startDate,
                        String endDate,
                        double budget,
                        String priority,
                        String status,
                        int managerId) {

        this.projectId = projectId;
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.priority = priority;
        this.status = status;
        this.managerId = managerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {

        return "Project ID    : " + projectId +
               "\nProject Code  : " + projectCode +
               "\nProject Name  : " + projectName +
               "\nDescription   : " + description +
               "\nStart Date    : " + startDate +
               "\nEnd Date      : " + endDate +
               "\nBudget        : " + budget +
               "\nPriority      : " + priority +
               "\nStatus        : " + status +
               "\nManager ID    : " + managerId;

    }

}