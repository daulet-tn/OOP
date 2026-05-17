package users;

import academic.ResearchPaper;
import academic.ResearchProject;
import enums.UserRole;
import exceptions.LowHIndexException;
import exceptions.NotAResearcherException;
import interfaces.Researcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResearchEmployee extends Employee implements Researcher {
    private static final int MIN_H_INDEX_FOR_PROJECT = 3;

    private List<ResearchPaper>   papers   = new ArrayList<>();
    private List<ResearchProject> projects = new ArrayList<>();

    public ResearchEmployee(String userId, String firstName, String lastName,
                            String email, String passwordHash,
                            String employeeId, String department, double salary) {
        super(userId, firstName, lastName, email, passwordHash,
              UserRole.RESEARCHER, employeeId, department, salary);
    }

    @Override
    public void addResearchPaper(ResearchPaper paper) throws NotAResearcherException {
        if (paper == null) {
            throw new NotAResearcherException("Paper is null for " + firstName);
        }
        papers.add(paper);
        System.out.println(firstName + " added paper: " + paper.getTitle());
    }

    @Override
    public void addResearchProject(ResearchProject project) throws LowHIndexException {
        if (calculateHIndex() < MIN_H_INDEX_FOR_PROJECT) {
            throw new LowHIndexException(
                "H-index too low (" + calculateHIndex() +
                ") — need at least " + MIN_H_INDEX_FOR_PROJECT);
        }
        projects.add(project);
        System.out.println(firstName + " started project: " + project.getTitle());
    }

    @Override
    public int calculateHIndex() {
        List<Integer> citations = new ArrayList<>();
        for (ResearchPaper p : papers) {
            citations.add(p.getCitations());
        }
        Collections.sort(citations, Collections.reverseOrder());

        int h = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }

    @Override
    public void startNewProject(String title, String description) throws LowHIndexException {
        ResearchProject project = new ResearchProject(
            "P" + (projects.size() + 1), title, description);
        addResearchProject(project);
    }

    @Override
    public void viewResearchInfo() {
        System.out.println("==== Researcher: " + firstName + " " + lastName + " ====");
        System.out.println("  Papers:   " + papers.size());
        System.out.println("  Projects: " + projects.size());
        System.out.println("  H-index:  " + calculateHIndex());
    }

    // Getters
    public List<ResearchPaper>   getPapers()   { return papers; }
    public List<ResearchProject> getProjects() { return projects; }

    @Override
    public String print() {
        return "ResearchEmployee{name=" + firstName + " " + lastName +
               ", h-index=" + calculateHIndex() +
               ", papers=" + papers.size() +
               ", projects=" + projects.size() + "}";
    }
}
