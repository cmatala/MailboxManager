public class Email {
    private Date date;
    private String subject;
    private boolean urgent;

    Email(){
        this.subject = "No Subject";
        this.date = new Date(2023,6,24);
    }


    Email(Date date, boolean urgent, String subject) {
        this.date = date;
        this.subject = subject;
        this.urgent = urgent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    @Override
    public String toString() {
        return "Email info: " +
                "date:" + date +
                "  subject: '" + subject + '\'' +
                "  urgent:" + urgent;
    }

}
