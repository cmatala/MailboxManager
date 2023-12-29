import org.jetbrains.annotations.Nullable;

import java.util.Scanner;

public class Driver {
    static MailBox[] mailBoxes = new MailBox[5];

    public static void main(String[] args) {



        MailBox mailBox1 = new MailBox("gmail");
        MailBox mailBox2 = new MailBox("outlook");
        MailBox mailBox3 = new MailBox("icloud");

        // Add the mailboxes to the mailBoxes array
        mailBoxes[0] = mailBox1;
        mailBoxes[1] = mailBox2;
        mailBoxes[2] = mailBox3;


        Email email1 = new Email();
        email1.setDate(new Date(2022,11,5));
        email1.setSubject("Exam2 guidelines");

        Email email2 = new Email(new Date(2021,3,5),true, "Quiz3 in Ch7");
        Email email3 = new Email();
        email3.setDate(new Date(2020,11,3));
        email3.setSubject("Late submission policy");

        mailBox2.addEmail(email1);
        mailBox2.addEmail(email2);
        mailBox2.addEmail(email3);



        // Call the displayMenu method
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while(!quit){
            // display menu
            System.out.println("Hello! What would you like to do?");
            System.out.println("1- List Emails in a mailbox");
            System.out.println("2- Add an email to a mailbox");
            System.out.println("3- Search for an email in a mailbox by year");
            System.out.println("4- Sort emails in a mailbox by year");
            System.out.println("5- Quit");

            // prompt user for input
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // process user input
            switch (choice) {
                case 1:
                    System.out.print("Enter client name: ");
                    String clientName = scanner.next();
                    MailBox mailbox = findMailbox(clientName);
                    if (mailbox == null) {
                        System.out.println("No mailbox found for client: " + clientName);
                    } else {
                        System.out.println(mailbox.toString());
                    }
                    break;

                case 2:
                    System.out.println("For which client?");
                    String clientName2 = scanner.next();
                    addEmailToMailbox(clientName2);
                    System.out.println("Emails sorted by year!");
                    break;

                case 3:
                    System.out.println("For which client?");
                    String clientName3 = scanner.next();
                    MailBox mailbox3 =findMailbox(clientName3);
                    if (mailbox3 == null) {
                        System.out.println("No mailbox found for client: " + clientName3);
                    } else {
                        System.out.println(" For which year?");
                        int year = scanner.nextInt();
                        Email email = mailbox3.findEmail(year);
                        if (email == null) {
                            System.out.println("No email found for year " + year);
                        } else {
                            System.out.println(email.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the client name: ");
                    String clientName4 = scanner.next();
                    MailBox mailBox = new MailBox(clientName4);
                    mailBox.sortEmailsByDate();
                    System.out.print("Emails sorted by year! ");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;

            }
        }



    }

    // Define the findMailbox method

    public static  MailBox findMailbox(String client) {
        for (int i = 0; i < mailBoxes.length; i++) {
            if (mailBoxes[i].getClient().equals(client)) {
                return mailBoxes[i];
            }
        }
        return null;
    }

    // Define the displayMenu method

    public static void addEmailToMailbox(String client){
        // get the mailbox object corresponding to that client by calling findMailbox method
        MailBox mailbox = findMailbox(client);

        if (mailbox == null) {
            System.out.println("Mailbox not found.");
            return;
        }
        // prompt the user for the email data

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email data (year, day, month, urgent, subject): ");
        String emailData = scanner.nextLine();
        String[] emailParts = emailData.split(",");
        if (emailParts.length != 5) {
            System.out.println("Invalid email data.");
            return;
        }

        //  read the data from the line corresponding to each variable inside the Email class
        int year = Integer.parseInt(emailParts[0]);
        int day = Integer.parseInt(emailParts[1]);
        int month = Integer.parseInt(emailParts[2]);
        String subject = emailParts[4];
        boolean isUrgent = Boolean.parseBoolean(emailParts[3]);

        // create a Date object from the month, day, year, and
        //use that in addition to the subject and urgent flag to create an Email object
        Date date = new Date(year, month, day);
        Email email = new Email(date, isUrgent, subject);

        // add the email object to the emails array of the desired mailbox
        mailbox.addEmail(email);
        System.out.println("Email added successfully");

    }






}
