








package com.esprit.veltun.gui;

import com.esprit.veltun.gui.event.jfxcalendar.model.CalendarEvent;
import com.esprit.veltun.gui.event.jfxcalendar.model.CalendarEventManager;
import com.esprit.veltun.gui.event.jfxcalendar.model.Reminder;
import com.esprit.veltun.gui.event.jfxcalendar.views.JFXCalendar;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.services.UserService;
import com.esprit.veltun.services.impl.InvitationServiceImpl;
import com.esprit.veltun.services.impl.SendMail;
import com.esprit.veltun.services.impl.UserServiceImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.controlsfx.control.Notifications;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class eventUi extends Application {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        InvitationService invitationService = InvitationServiceImpl.getInstance();
        invitationService.checkExpiredInvitation();
        System.out.println(UserServiceImpl.connectedUser);
        launch(args);
    }

    @Override
 /*   public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("event/search/search.fxml"));
        primaryStage.setTitle("Gestion des évenements");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }
   /* public void start(Stage primaryStage) throws Exception {


        Request request;
        Response response;
        class MeteoAPI {

            private static final String API_KEY = "your-api-key-here";
            private static final String API_ENDPOINT = "http://api.openweathermap.org/data/2.5/weather?q=";

            private OkHttpClient client;

            public MeteoAPI() {
                client = new OkHttpClient();
            }

            public String getMeteoData(String city) throws Exception {
                request = new Request.Builder()
                        .url(API_ENDPOINT + city + "&appid=" + API_KEY)
                        .build();

                response = client.newCall(request).execute();
                if (!response.isSuccessful()) throw new Exception("API request failed");
                return response.body().string();
            }

        }


        primaryStage.setTitle("Gestion des évenements");
        primaryStage.setResizable(false);
        Scene scene = new Scene(response);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();

    }*/

    public void start(Stage primaryStage) throws Exception {
        CalendarEventManager eventManager = new CalendarEventManager();
        JFXCalendar calendar = new JFXCalendar(eventManager);

        // EXAMPLES
// ===========================
        CalendarEvent event = new CalendarEvent("title", 1, "description");
        event.setType(CalendarEvent.ONE_TIME_EVENT);
        event.setDate(LocalDate.now());

// per week
        CalendarEvent event1 = new CalendarEvent("title", 1, "description");
        event1.setType(CalendarEvent.RECURRING_EVENT);
        event1.setPeriodicType(CalendarEvent.PER_WEEK);
        event1.setDaysInWeek("1,3,5,7"); // monday, Wednesday , Friday , Sunday

// per month
        CalendarEvent event2 = new CalendarEvent("title", 1, "description");
        event2.setType(CalendarEvent.RECURRING_EVENT);
        event2.setPeriodicType(CalendarEvent.PER_MONTH);
        event2.setPlaceInMonth(CalendarEvent.START_OF_MONTH);
// or event.setPlaceInMonth(CalendarEvent.END_OF_MONTH);

// per year
        CalendarEvent event3 = new CalendarEvent("title", 1, "description");
        event3.setType(CalendarEvent.RECURRING_EVENT);
        event3.setPeriodicType(CalendarEvent.PER_YEAR);
        event3.setYearlyDate(LocalDate.now());

// refresh the calendar
        calendar.refreshCalendar();




        primaryStage.setTitle("Gestion des évenements");
        primaryStage.setResizable(false);
        Scene scene = new Scene(calendar);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    /*public void start(Stage primaryStage) throws Exception {
        CalendarEventManager eventManager = new CalendarEventManager();
        JFXCalendar calendar = new JFXCalendar(eventManager);

        calendar.refreshCalendar();
        SendMail.sendMail("rim.hammami@esprit.tn","salut from app", "test");



        primaryStage.setTitle("Gestion des évenements");
        primaryStage.setResizable(false);
        Scene scene = new Scene(calendar);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();





    }*/
}
