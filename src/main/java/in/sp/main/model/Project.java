package in.sp.main.model;

import java.util.List;

public class Project {
    private String emoji;
    private String title;
    private String description;
    private List<String> tags;
    private String githubLink;
    private String liveLink;
    private String imagePath;

    // Getters & Setters
    public String getEmoji() {
        return emoji;
    }
    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getGithubLink() {
        return githubLink;
    }
    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLiveLink() {
        return liveLink;
    }
    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
