
import java.time.LocalDateTime;


public class FeedBack {
    private String id;
    private String type;
    private String description;
    private String status;
    private String itResponse;
    private String createdBy;
    private String createdByName;
    private String respondedBy;
    private LocalDateTime createdAt; // Adding timestamp

    public FeedBack(String id, String type, String description, String createdBy, String createdByName) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.status = "Unsolved"; // Default status
        this.itResponse = null;
        this.createdBy = createdBy;
        this.createdByName = createdByName;
        this.createdAt = LocalDateTime.now(); // Set creation time
    }

    public String getRespondedBy() {
        return respondedBy;
    }

    public void setRespondedBy(String respondedBy) {
        this.respondedBy = respondedBy;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getItResponse() {
        return itResponse;
    }

    public void setItResponse(String response) {
        this.itResponse = response;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
