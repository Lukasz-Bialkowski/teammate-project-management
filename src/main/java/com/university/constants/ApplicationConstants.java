package com.university.constants;

public class ApplicationConstants {

    public static final String ACCOUNT_ACTIVATION_EMAIL_TITLE = "TeamMate | Account activation";
    public static final String TASK_PINNED_EMAIL_TITLE = "TeamMate | You have been pinned to a new task";

    public static String generateAccountActivationEmailContent(String accountLogin, String acctivationLink) {
        return "Hello " + accountLogin + "!\n" +
                "Your account is created. " +
                "To activate your account click the following url: \n" +
                acctivationLink + "\n" +
                "____________________________" +
                "Thank you for your trust and using TeamMate.\n" +
                "TeamMate team";
    }

    ;

}
