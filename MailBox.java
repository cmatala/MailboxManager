
public class MailBox {
    private String client;
    private Email[] emails;
    private int actualSize;

    MailBox() {
        // Assign default name to client
        this.client = "outlook";
        // Instantiate emails array with size 15
        this.emails = new Email[15];
        // Set actualSize to 0
        this.actualSize = 0;
    }

    MailBox(String client) {
        // Call default constructor using chaining
        this();
        // Initialize client variable with client parameter
        this.client = client;
    }

    public String getClient() {

            return client;

    }

    public Email getEmail(int index) {
        if (index >= 0 && index < actualSize) {
            return emails[index];
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }


    public void addEmail(Email email) {
        int MAX_SIZE = 15;
        if (actualSize < MAX_SIZE) {
            if (email == null) { //correction Elie
                System.out.println("Email cannot be null.");
                return;
            }
            emails[actualSize] = email;
            actualSize++;
        } else {
            System.out.println("You have reached maximum capacity. Upgrade your account");
        }
    }

    public int getActualSize() {
        return actualSize;
    }


    public void sortEmailsByDate() {
        for (int i = 0; i < emails.length; i++) {
            for (int j = i + 1; j < emails.length; j++) {
                if (emails[i] != null && emails[j] != null &&
                        emails[i].getDate() != null && emails[j].getDate() != null && // correction
                        emails[i].getDate().getYear() > emails[j].getDate().getYear()) {
                    Email temp = emails[i];
                    emails[i] = emails[j];
                    emails[j] = temp;
                }
            }
        }
    }

    public Email findEmail(int year) {
        for (Email email : emails) {
            if (email.getDate().getYear() == year) {
                return email;
            }
        }
        return null; // no email found for the given year
    }

    public int countUrgent() {
        int count = 0;
        for (Email email : emails) {
            if (email != null && email.isUrgent()) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(client).append(" account summary : ").append("\n");
        sb.append("The account has ").append(getActualSize()).append("emails").append("\n");
        sb.append(countUrgent()).append("email(s) was/were urgent\n");
        for (Email email : emails) {
            if (email != null) {
                sb.append(email.toString()).append("\n");
            }
        }
        return sb.toString();
    }




}
