package com.university.constants;

public class ApplicationConstants {

    public static final String NEW_ACCOUNT_EMAIL_TITLE = "TeamMate | Nowe konto w systemie";
    public static final String TASK_PINNED_EMAIL_TITLE = "TeamMate | Masz nowe zadanie";

    public static String generateAccountCreatedEmail(String userName, String userSurname, String loginUrl) {
        return "<h3>Hello " + cappitalize(userName) + " " + cappitalize(userSurname) + "!</h3><br>" +
                "Your account is created.<br>" +
                "You can now log in to Teammate by clicking in the following link:<br>" +
                "<a href=\"" + loginUrl + "\">Teammate account login</a><br><br>" +
                "____________________________<br>" +
                "Thank you for your trust and using TeamMate.<br>" +
                "TeamMate team";
    }

    private static String cappitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

}
