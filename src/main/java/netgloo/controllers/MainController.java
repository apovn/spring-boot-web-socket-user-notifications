package netgloo.controllers;

import netgloo.domain.Notification;
import netgloo.domain.RequestInfo;
import netgloo.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private NotificationService notificationService;

    /**
     * GET  /  -> show the index page.
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * GET  /notifications  -> show the notifications page.
     */
    @RequestMapping("/notifications")
    public String notifications() {
        return "notifications";
    }

    /**
     * GET  /notifications  -> show the notifications page.
     */
    @RequestMapping("/feedback")
    public String feedback() {
        return "feedback";
    }

    /**
     * POST  /some-action  -> do an action.
     * <p>
     * RequestBody: https://stackoverflow.com/questions/11291933/requestbody-and-responsebody-annotations-in-spring
     */
    @RequestMapping(value = "/some-action", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> someAction(@RequestBody RequestInfo requestInfo) {

        // Do an action here
        // ...

        // Send the notification to "UserA" (by username)
        notificationService.notify(new Notification("hello"), requestInfo.getUser());
        notificationService.feedback(new Notification("feedback"), requestInfo.getUser());

        // Return an http 200 status code
        return new ResponseEntity<>(HttpStatus.OK);
    }

} // class MainController
