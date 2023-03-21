package Other;

public class Test {

    private int testID;
    private String patientName;
    private String testDate;
    private String postcode;
    private String outcome;
    private String patientMobile;
    private String testLocation;
    private String cc1Name;
    private String cc1Mobile;
    private String cc2Name;
    private String cc2Mobile;

    public Test(String patientName, String testDate, String postcode, String outcome, String patientMobile, String cc1Name, String cc1Mobile, String cc2Name, String cc2Mobile) {
        this.patientName = patientName;
        this.testDate = testDate;
        this.postcode = postcode;
        this.outcome = outcome;
        this.patientMobile = patientMobile;
        this.cc1Name = cc1Name;
        this.cc1Mobile = cc1Mobile;
        this.cc2Name = cc2Name;
        this.cc2Mobile = cc2Mobile;
    }

    public Test(){}

    public int getTestID() {
        return testID;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public String getCc1Name() {
        return cc1Name;
    }

    public String getCc1Mobile() {
        return cc1Mobile;
    }

    public String getCc2Name() {
        return cc2Name;
    }

    public String getCc2Mobile() {
        return cc2Mobile;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public void setCc1Name(String cc1Name) {
        this.cc1Name = cc1Name;
    }

    public void setCc1Mobile(String cc1Mobile) {
        this.cc1Mobile = cc1Mobile;
    }

    public void setCc2Name(String cc2Name) {
        this.cc2Name = cc2Name;
    }

    public void setCc2Mobile(String cc2Mobile) {
        this.cc2Mobile = cc2Mobile;
    }

    public String getTestLocation() {
        return testLocation;
    }

    public void setTestLocation(String testLocation) {
        this.testLocation = testLocation;
    }
}
