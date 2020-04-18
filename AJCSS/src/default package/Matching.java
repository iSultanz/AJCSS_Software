import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Matching {

    private ArrayList<Candidate> candList;
    private Jobs job;

    public Matching(Jobs job, ArrayList<Candidate> candList) {
        this.job = job;
        this.candList = candList;
    }

    public ArrayList<MatchedPersons> match() {
        ArrayList<Skill> jobSkills = new ArrayList<>();
        ArrayList<Skill> candSkills = new ArrayList<>();
        ArrayList<Competency> jobComp = new ArrayList<>();
        ArrayList<Competency> candComp = new ArrayList<>();
        ArrayList<MatchedPersons> mp = new ArrayList<>();
        for (int i = 0; i < candList.size(); i++) { 
            int totalScore = 0;
            double totPercent = 0;
            String matchedskills = "";
            String matchedcomps="";
            String matchedskillsvalues = "";
            String matchedcompsvalues="";
            candSkills.clear();
            jobSkills.clear();
            jobComp.clear();
            candComp.clear();
            if (candList.get(i).getCanprocessed() == 1) {
                if (job.getEducation() == candList.get(i).getCaneducation()) {
                    totalScore = totalScore + 10;
                    if (job.getGender() == candList.get(i).getCangender()) {
                         totalScore = totalScore + 10;   
                        if (candList.get(i).getCanmajor() == job.getMajor1()
                         || candList.get(i).getCanmajor() == job.getMajor2()
                         || candList.get(i).getCanmajor() == job.getMajor3()
                         || candList.get(i).getCanmajor() == job.getMajor4()
                         || candList.get(i).getCanmajor() == job.getMajor5()) {
                            totalScore = totalScore + 10;
                            if (SkillNotExist(candSkills,candList.get(i).getCanskills1())){
                            candSkills.add(new Skill(candList.get(i).getCanskills1(), candList.get(i).getCanskills1value()));}
                            if (SkillNotExist(candSkills,candList.get(i).getCanskills2())){
                            candSkills.add(new Skill(candList.get(i).getCanskills2(), candList.get(i).getCanskills2value()));}
                            if (SkillNotExist(candSkills,candList.get(i).getCanskills3())){
                            candSkills.add(new Skill(candList.get(i).getCanskills3(), candList.get(i).getCanskills3value()));}
                            if (SkillNotExist(candSkills,candList.get(i).getCanskills4())){
                            candSkills.add(new Skill(candList.get(i).getCanskills4(), candList.get(i).getCanskills4value()));}
                            if (SkillNotExist(candSkills,candList.get(i).getCanskills5())){
                            candSkills.add(new Skill(candList.get(i).getCanskills5(), candList.get(i).getCanskills5value()));}
                            if (SkillNotExist(jobSkills,job.getSkill1())){
                            jobSkills.add(new Skill(job.getSkill1(), job.getSkillValue1()));}
                            if (SkillNotExist(jobSkills,job.getSkill2())){
                            jobSkills.add(new Skill(job.getSkill2(), job.getSkillValue2()));}
                            if (SkillNotExist(jobSkills,job.getSkill3())){
                            jobSkills.add(new Skill(job.getSkill3(), job.getSkillValue3()));}
                            if (SkillNotExist(jobSkills,job.getSkill4())){
                            jobSkills.add(new Skill(job.getSkill4(), job.getSkillValue4()));}
                            if (SkillNotExist(jobSkills,job.getSkill5())){
                            jobSkills.add(new Skill(job.getSkill5(), job.getSkillValue5()));}
                            if (CompNotExist(candComp,candList.get(i).getCancomptency1())){
                            candComp.add(new Competency(candList.get(i).getCancomptency1(), candList.get(i).getCancomptency1value()));}
                            if (CompNotExist(candComp,candList.get(i).getCancomptency2())){
                            candComp.add(new Competency(candList.get(i).getCancomptency2(), candList.get(i).getCancomptency2value()));}
                            if (CompNotExist(candComp,candList.get(i).getCancomptency3())){
                            candComp.add(new Competency(candList.get(i).getCancomptency3(), candList.get(i).getCancomptency3value()));}
                            if (CompNotExist(candComp,candList.get(i).getCancomptency4())){
                            candComp.add(new Competency(candList.get(i).getCancomptency4(), candList.get(i).getCancomptency4value()));}
                            if (CompNotExist(candComp,candList.get(i).getCancomptency5())){
                            candComp.add(new Competency(candList.get(i).getCancomptency5(), candList.get(i).getCancomptency5value()));}
                             if (CompNotExist(jobComp,job.getComp1())){
                            jobComp.add(new Competency(job.getComp1(), job.getCompValue1()));}
                             if (CompNotExist(jobComp,job.getComp2())){
                            jobComp.add(new Competency(job.getComp2(), job.getCompValue2()));}
                             if (CompNotExist(jobComp,job.getComp3())){
                            jobComp.add(new Competency(job.getComp3(), job.getCompValue3()));}
                             if (CompNotExist(jobComp,job.getComp4())){
                            jobComp.add(new Competency(job.getComp4(), job.getCompValue4()));}
                             if (CompNotExist(jobComp,job.getComp5())){
                            jobComp.add(new Competency(job.getComp5(), job.getCompValue5()));}
                                                    
                            for (int j = 0; j < jobSkills.size(); j++) {
                                for (int k = 0; k < candSkills.size(); k++) {
                                    if (jobSkills.get(j).getSkill() == candSkills.get(k).getSkill()) {
                                    
                                        if (jobSkills.get(j).getValue() <= candSkills.get(k).getValue()) {
                                            matchedskills = matchedskills + candSkills.get(k).getSkill()+",";
                                            matchedskillsvalues = matchedskillsvalues + candSkills.get(k).getValue()+",";
                                            totalScore = totalScore + candSkills.get(k).getValue();
                                            
                                         //   System.out.println(candList.get(i).getCanid()+"skill "+ candSkills.get(k).getValue()+"  "+ totalScore + );
                                        }
                                    }
                                }
                            }
                            for (int j = 0; j < jobComp.size(); j++) {
                                for (int k = 0; k < candComp.size(); k++) {
                                    if (jobComp.get(j).getCompetency()== candComp.get(k).getCompetency()) {
                                        if (jobComp.get(j).getValue() <= candComp.get(k).getValue()) {
                                            matchedcomps = matchedcomps + candComp.get(k).getCompetency()+",";
                                            matchedcompsvalues = matchedcompsvalues + candComp.get(k).getValue()+",";
                                            totalScore = totalScore + candComp.get(k).getValue();
                                         //   System.out.println(candList.get(i).getCanid()+"comp "+ candComp.get(k).getValue()+"  "+ totalScore);
                                        }
                                    }
                                }
                            }
                            totPercent =  ((double) totalScore/(double)130*100);
                            totPercent = Math.round(totPercent);
                            int t = (int) totPercent;
                            if (matchedskills.length() > 0 ) matchedskills = matchedskills.substring(0,matchedskills.length()-1);
                            if (matchedcomps.length() > 0 ) matchedcomps = matchedcomps.substring(0,matchedcomps.length()-1);
                            if (matchedskillsvalues.length() > 0 ) matchedskillsvalues = matchedskillsvalues.substring(0,matchedskillsvalues.length()-1);
                            if (matchedcompsvalues.length() > 0 ) matchedcompsvalues = matchedcompsvalues.substring(0,matchedcompsvalues.length()-1);
                            mp.add(new MatchedPersons(candList.get(i).getCanid(), totalScore, (int) totPercent,matchedskills,matchedcomps,matchedskillsvalues,matchedcompsvalues));
                            System.out.println(candList.get(i).getCanid()+"  "+ totalScore +"   "  +  totPercent + "   " + t + "  " + matchedskills +"    comp   "+ matchedcomps +" s values"+matchedskillsvalues+" c values "+matchedcompsvalues  );
                        }
                    }
                }
            }
        }
        return mp;
    }
public boolean SkillNotExist(ArrayList<Skill> arr, int item){
        for(int i=0;i<arr.size();i++){
            if (arr.get(i).getSkill() == item)
                return false;
        }
    return true;
}
public boolean CompNotExist(ArrayList<Competency> arr, int item){
        for(int i=0;i<arr.size();i++){
            if (arr.get(i).getCompetency() == item)
                return false;
        }
    return true;
}
    /**
     * @return the candList
     */
    public ArrayList<Candidate> getCandList() {
        return candList;
    }


    public void setCandList(ArrayList<Candidate> candList) {
        this.candList = candList;
    }

    /**
     * @return the job
     */
    public Jobs getJob() {
        return job;
    }


    public void setJob(Jobs job) {
        this.job = job;
    }
    public class Skill {

        private int skill;
        private int value;

        public Skill(int skill, int value) {
            this.skill = skill;
            this.value = value;
        }

        /**
         * @return the skill
         */
        public int getSkill() {
            return skill;
        }


        public void setSkill(int skill) {
            this.skill = skill;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

 
        public void setValue(int value) {
            this.value = value;
        }
    }
    public class SkillScore {
        private int canID;
        private int skill;
        private int score;

        public SkillScore(int canID,int skill, int score) {
            this.canID = canID;
            this.skill = skill;
            this.score = score;
        }

        public int getSkillScoreCanID() {
            return canID;
        }


        public void setSkillScoreCanID(int canID) {
            this.canID = canID;
        }
        /**
         * @return the skill
         */
        public int getSkillScore() {
            return skill;
        }


        public void setSkillScore(int skill) {
            this.skill = skill;
        }

        /**
         * @return the value
         */
        public int getSkillScoreValue() {
            return score;
        }


        public void setSkillScoreValue(int score) {
            this.score = score;
        }
    }

    public class Competency {

        private int competency;
        private int value;

        public Competency(int competency, int value) {
            this.competency = competency;
            this.value = value;
        }

        /**
         * @return the competency
         */
        public int getCompetency() {
            return competency;
        }


        public void setCompetency(int competency) {
            this.competency = competency;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public class MatchedPersons {

        private int candID;
        private int totalScore;
        private int totPercent;
        private String MatchedSkills;
        private String MatchedComps;
        private String MatchedSkillsValues;
        private String MatchedCompsValues;

        public MatchedPersons(int candID, int totalScore, int totPercent, String MatchedSkills, String MatchedComps, String MatchedSkillsValues , String MatchedCompsValues) {
            this.candID = candID;
            this.totalScore = totalScore;
            this.totPercent = totPercent;
            this.MatchedSkills =  MatchedSkills;
            this.MatchedComps = MatchedComps;
            this.MatchedSkills =  MatchedSkills;
            this.MatchedComps = MatchedComps;
            this.MatchedSkillsValues = MatchedSkillsValues;
            this.MatchedCompsValues = MatchedCompsValues;
        }

        /**
         * @return the candID
         */
        public int getCandID() {
            return candID;
        }


        public void setCandID(int candID) {
            this.candID = candID;
        }

        /**
         * @return the totalScore
         */
        public int getTotalScore() {
            return totalScore;
        }


        public void setTotalScore(int totalScore) {
            this.totalScore = totalScore;
        }
        
        public int  getTotPercent() {
            return totPercent;
        }


        public void setTotPercent(int totPercent) {
            this.totPercent = totPercent;
        }
        public String  getMatchedSkills() {
            return MatchedSkills;
        }


        public void setTotPercent(String MatchedSkills) {
            this.MatchedSkills = MatchedSkills;
        }
       public String  getMatchedComps() {
            return MatchedComps;
        }

        /**
         */
        public void setMatchedComps(String MatchedComps) {
            this.MatchedComps = MatchedComps;
        } 
        public String  getMatchedCompsValues() {
            return MatchedCompsValues;
        }

        public void setMatchedCompsValues(String MatchedCompsValues) {
            this.MatchedCompsValues = MatchedCompsValues;
        } 
        public String  getMatchedSkillsValues() {
            return MatchedSkillsValues;
        }

        public void setMatchedSkillsValues(String MatchedSkillsValues) {
            this.MatchedSkillsValues = MatchedSkillsValues;
        } 
        
    }
}