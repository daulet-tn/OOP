package academic;

public class ResearchPaper {
    private String paperId;
    private String title;
    private String authors;
    private String journal;
    private int year;
    private int citations;
    private int pages;

    public ResearchPaper(String paperId, String title, String authors,
                         String journal, int year, int pages) {
        this.paperId = paperId;
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.year = year;
        this.pages = pages;
        this.citations = 0;
    }

    public void addCitation() {
        this.citations++;
    }

    public void setCitations(int c) {
        this.citations = c;
    }

    // Getters
    public String getPaperId() { return paperId; }
    public String getTitle()   { return title; }
    public String getAuthors() { return authors; }
    public String getJournal() { return journal; }
    public int getYear()       { return year; }
    public int getCitations()  { return citations; }
    public int getPages()      { return pages; }

    @Override
    public String toString() {
        return title + " (" + year + ") — citations: " + citations;
    }
}
