package interfaces;

import academic.ResearchPaper;
import academic.ResearchProject;
import exceptions.LowHIndexException;
import exceptions.NotAResearcherException;

public interface Researcher {

    void addResearchPaper(ResearchPaper paper) throws NotAResearcherException;

    void addResearchProject(ResearchProject project) throws LowHIndexException;

    int calculateHIndex();

    void startNewProject(String title, String description) throws LowHIndexException;

    void viewResearchInfo();
}
