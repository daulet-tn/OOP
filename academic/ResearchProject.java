package academic;

import java.util.ArrayList;
import java.util.List;

public class ResearchProject {
    private String projectId;
    private String title;
    private String description;
    private List<ResearchPaper> publishedPapers = new ArrayList<>();
    private boolean isActive;

    public ResearchProject(String projectId, String title, String description) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.isActive = true;
    }

    public void addPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
    }

    public void finish() {
        this.isActive = false;
    }

    // Getters
    public String getProjectId()             { return projectId; }
    public String getTitle()                 { return title; }
    public String getDescription()           { return description; }
    public List<ResearchPaper> getPublishedPapers() { return publishedPapers; }
    public boolean isActive()                { return isActive; }

    @Override
    public String toString() {
        return title + (isActive ? " [active]" : " [finished]") +
               " — papers: " + publishedPapers.size();
    }
}
