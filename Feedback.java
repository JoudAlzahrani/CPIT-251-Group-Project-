/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmain251;

/**
 *
 * @author jood
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

class Feedback {
    private String userId; // هنا نخزن رقم المستخدم
    private String description; // هنا نخزن وصف الملاحظات
    private String timestamp; // هنا نخزن الوقت اللي تم فيه تقديم الملاحظة

    public Feedback(String userId, String description) {
        this.userId = userId; // رقم المستخدم
        this.description = description; // وصف الملاحظة
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // نسجل الوقت الحالي
    }

    public String getEntry() {
        return userId + "|" + description + "|" + timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

