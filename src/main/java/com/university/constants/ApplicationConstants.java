package com.university.constants;

import java.util.Optional;

public class ApplicationConstants {

    public static final String NEW_ACCOUNT_EMAIL_TITLE = "TeamMate | New account created";
    public static final String TASK_PINNED_TO_USER_EMAIL_TITLE = "TeamMate | You've got new task";
    public static final String PROJECT_PINNED_TO_MANAGER_EMAIL_TITLE = "TeamMate | Welcome Project Manager";
    public static final String PROJECT_EVENT_UPDATE_EMAIL_TITLE = "TeamMate | Project event update";
    public static final String PROJECT_DOCUMENT_UPDATE_EMAIL_TITLE = "TeamMate | Project document update";
    public static final String TASK_STATUS_UPDATE_EMAIL_TEMPLATE = "TeamMate | Task status update";

    public static String generateAccountCreatedEmail(String userName, String userSurname) {
        return "<h3>Hello " + cappitalize(userName) + " " + cappitalize(userSurname) + "!</h3><br>" +
                "Your account is created.<br>" +
                "You can now log in to Teammate by clicking in the following link:<br>" +
                "____________________________<br>" +
                "Thank you for your trust and using TeamMate.<br>" +
                "TeamMate team";
    }

    public static String generateTaskPinnedEmail(String userName, String userSurname) {
        return "<h3>Hello " + cappitalize(userName) + " " + cappitalize(userSurname) + "!</h3><br>" +
                "There is new task on your project's taskboard which was pinned to you.<br>" +
                "You can now log in working hours spend on your task and change its state.<br>" +
                "Your task state is TODO now.<br>" +
                "____________________________<br>" +
                "Thank you for your trust and using TeamMate.<br>" +
                "TeamMate team";
    }

    public static String generateProjectPinnedEmail(String userName, String userSurname) {
        return "<h3>Hello " + cappitalize(userName) + " " + cappitalize(userSurname) + "!</h3><br>" +
                "We are grad to announce new project in Teammate system.<br>" +
                "You have been choosen to be team leader and manager.<br>" +
                "____________________________<br>" +
                "Thank you for your trust and using TeamMate.<br>" +
                "TeamMate team";
    }

    public static String generateProjectDocumentUpdateEmail(String userName, String userSurname) {
        return "<h3>Hello " + cappitalize(userName) + " " + cappitalize(userSurname) + "!</h3><br>" +
                "There are some changes in project documents.<br>" +
                "Some document was updated.<br>" +
                "You can check it in documents section of your project.<br>" +
                "____________________________<br>" +
                "Thank you for your trust and using TeamMate.<br>" +
                "TeamMate team";
    }

    public static String generateProjectEventUpdateEmail(String userName, String userSurname) {
        return "<h3>Hello " + cappitalize(userName) + " " + cappitalize(userSurname) + "!</h3><br>" +
                "There are some changes in project events.<br>" +
                "Some event was updated.<br>" +
                "You can check it in events section of your project.<br>" +
                "____________________________<br>" +
                "Thank you for your trust and using TeamMate.<br>" +
                "TeamMate team";
    }

    public static String generateTaskStatusUpdateEmail(String userName, String userSurname) {
        return "<h3>Hello " + cappitalize(userName) + " " + cappitalize(userSurname) + "!</h3><br>" +
                "There are some changes in project taskboard.<br>" +
                "Task pinned to project taskboard changed its status.<br>" +
                "You can check it in project taskboard section.<br>" +
                "____________________________<br>" +
                "Thank you for your trust and using TeamMate.<br>" +
                "TeamMate team";
    }

    private static String cappitalize(String word) {
        return Optional.ofNullable(word).isPresent() ? word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() : "";
    }

}
