// Matching Functional Requirement   
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
                                        }
                                    }
                                }
                            }
                            totPercent =  ((double) totalScore/(double)130)*100;
                            totPercent = Math.round(totPercent);
                            int t = (int) totPercent;
                            if (matchedskills.length() > 0 ) 
				    matchedskills = matchedskills.substring(0,matchedskills.length()-1);
                            if (matchedcomps.length() > 0 ) 
				    matchedcomps = matchedcomps.substring(0,matchedcomps.length()-1);
                            if (matchedskillsvalues.length() > 0 ) 
				    matchedskillsvalues = matchedskillsvalues.substring(0,matchedskillsvalues.length()-1);
                            if (matchedcompsvalues.length() > 0 ) 
				    matchedcompsvalues = matchedcompsvalues.substring(0,matchedcompsvalues.length()-1);
                            
			    mp.add(new MatchedPersons(candList.get(i).getCanid(), totalScore, (int) totPercent,matchedskills,matchedcomps,matchedskillsvalues,matchedcompsvalues));
                            System.out.println(candList.get(i).getCanid()+"  "+ totalScore +"   "  +  totPercent + "   " + t + "  " + matchedskills +"    comp   "+ matchedcomps +" s values"+matchedskillsvalues+" c values "+matchedcompsvalues  );
                        }
                    }
                }
            }
        }
        return mp;
	}
	
		
// Addtion Functional Requirement for candidates
private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Jobs max = Collections.max(jobsData, Comparator.comparing(s -> s.getJobID()));
        jTextFieldJobID1.setText(Integer.toString(max.getJobID() + 1));

        Jobs newJob = new Jobs();
        newJob.setJobID(Integer.parseInt(jTextFieldJobID1.getText()));
        newJob.setJobCat(getComboValue(jobsCatData, jComboBoxJobCat1.getSelectedItem().toString()));
        newJob.setJobSubCat(getComboValue(jobsSubCatData, jComboBoxJobSubCat1.getSelectedItem().toString()));
        newJob.setJobTitle(jTextFieldJobTitle1.getText());
        newJob.setStatus(1);
        newJob.setMinSalary(Integer.parseInt(jTextFieldMinSalary1.getText()));
        newJob.setMaxSalary(Integer.parseInt(jTextFieldMaxSalary1.getText()));
        newJob.setReallocation(jCheckBoxReallocation1.isSelected());
        newJob.setTravel(jCheckBoxTravel1.isSelected());
        newJob.setDriving(jCheckBoxDriving1.isSelected());
        newJob.setInterview(Integer.parseInt(jSpinnerinterview1.getValue().toString()));
        newJob.setMajor1(getComboValue(majorsData, jComboBoxMajor6.getSelectedItem().toString()));
        newJob.setMajor2(getComboValue(majorsData, jComboBoxMajor7.getSelectedItem().toString()));
        newJob.setMajor3(getComboValue(majorsData, jComboBoxMajor8.getSelectedItem().toString()));
        newJob.setMajor4(getComboValue(majorsData, jComboBoxMajor9.getSelectedItem().toString()));
        newJob.setMajor5(getComboValue(majorsData, jComboBoxMajor10.getSelectedItem().toString()));
        newJob.setSkillCat1(getComboValue(skillCatData, jComboSkillsCat6.getSelectedItem().toString()));
        newJob.setSkillCat2(getComboValue(skillCatData, jComboSkillsCat7.getSelectedItem().toString()));
        newJob.setSkillCat3(getComboValue(skillCatData, jComboSkillsCat8.getSelectedItem().toString()));
        newJob.setSkillCat4(getComboValue(skillCatData, jComboSkillsCat9.getSelectedItem().toString()));
        newJob.setSkillCat5(getComboValue(skillCatData, jComboSkillsCat10.getSelectedItem().toString()));
        newJob.setSkill1(getComboValue(skillData, jComboSkills6.getSelectedItem().toString()));
        newJob.setSkill2(getComboValue(skillData, jComboSkills7.getSelectedItem().toString()));
        newJob.setSkill3(getComboValue(skillData, jComboSkills8.getSelectedItem().toString()));
        newJob.setSkill4(getComboValue(skillData, jComboSkills9.getSelectedItem().toString()));
        newJob.setSkill5(getComboValue(skillData, jComboSkills10.getSelectedItem().toString()));
        newJob.setCompCat1(getComboValue(compCatData, jComboBoxCompCat6.getSelectedItem().toString()));
        newJob.setCompCat2(getComboValue(compCatData, jComboBoxCompCat7.getSelectedItem().toString()));
        newJob.setCompCat3(getComboValue(compCatData, jComboBoxCompCat8.getSelectedItem().toString()));
        newJob.setCompCat4(getComboValue(compCatData, jComboBoxCompCat9.getSelectedItem().toString()));
        newJob.setCompCat5(getComboValue(compCatData, jComboBoxCompCat10.getSelectedItem().toString()));
        newJob.setComp1(getComboValue(compData, jComboBoxComp6.getSelectedItem().toString()));
        newJob.setComp2(getComboValue(compData, jComboBoxComp7.getSelectedItem().toString()));
        newJob.setComp3(getComboValue(compData, jComboBoxComp8.getSelectedItem().toString()));
        newJob.setComp4(getComboValue(compData, jComboBoxComp9.getSelectedItem().toString()));
        newJob.setComp5(getComboValue(compData, jComboBoxComp10.getSelectedItem().toString()));
        newJob.setSkillValue1(Integer.parseInt(jSpinnerSkillValue6.getValue().toString()));
        newJob.setSkillValue2(Integer.parseInt(jSpinnerSkillValue7.getValue().toString()));
        newJob.setSkillValue3(Integer.parseInt(jSpinnerSkillValue8.getValue().toString()));
        newJob.setSkillValue4(Integer.parseInt(jSpinnerSkillValue9.getValue().toString()));
        newJob.setSkillValue5(Integer.parseInt(jSpinnerSkillValue10.getValue().toString()));
        newJob.setCompValue1(Integer.parseInt(jSpinnerSkillValue6.getValue().toString()));
        newJob.setCompValue2(Integer.parseInt(jSpinnerSkillValue7.getValue().toString()));
        newJob.setCompValue3(Integer.parseInt(jSpinnerSkillValue8.getValue().toString()));
        newJob.setCompValue4(Integer.parseInt(jSpinnerSkillValue9.getValue().toString()));
        newJob.setCompValue5(Integer.parseInt(jSpinnerSkillValue10.getValue().toString()));        
        jobsData.add(newJob);
        index += 1;
    }
	
// Deletion Functional Requirement for candidates

            public void actionPerformed(ActionEvent e) {
                if(!candidatesData.isEmpty())
                    if( candidatesData.size() >= 2 ){
                        candidatesDataChanged++;
                        if( canindex == 0 ){
                            jButtonNextCanActionPerformed(jButtonNextCanEvent);
                            removedElementsOfCandidatesData.add(candidatesData.remove(canindex-1));
                            removedElementsIndecesOfCandidatesData.add(canindex-1);
                            jButtonPrevCanActionPerformed(jButtonPrevCanEvent);
                        }else
                            if( canindex == candidatesData.size()-1 ){
                                removedElementsOfCandidatesData.add(candidatesData.remove(canindex));
                                removedElementsIndecesOfCandidatesData.add(canindex);
                                jButtonPrevCanActionPerformed(jButtonPrevCanEvent);
                            }
                            else{
                                removedElementsOfCandidatesData.add(candidatesData.remove(canindex));
                                removedElementsIndecesOfCandidatesData.add(canindex);                                            
                                jButtonPrevCanActionPerformed(jButtonPrevCanEvent);
                            }
                    }
                    else{
                        candidatesDataChanged++;
                        removedElementsOfCandidatesData.add(candidatesData.remove(canindex));
                        removedElementsIndecesOfCandidatesData.add(canindex);
                        candidatesData.clear();
                        clearUnprocessedCandidatesComponents();                        
                    }
                }

	
// Save process Functional Requirements for candidates

    private void SaveCandidatesToCSV() {
        File file = new File("C:/AJCSS/candidates.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            // Clear file content to avoid duplication issue.
            PrintWriter pWriter = new PrintWriter(file);
            pWriter.write("");
            
            for (int i = 0; i < candidatesData.size(); i++) {
                bw.write(candidatesData.get(i).getCanid() + ",");
                bw.write(candidatesData.get(i).getCanname() + ",");
                bw.write(candidatesData.get(i).getCanbirth() + ",");
                bw.write(candidatesData.get(i).getCaneducation() + ",");
                bw.write(candidatesData.get(i).getCanmajor() + ",");
                bw.write(candidatesData.get(i).getCangrade() + ",");
                bw.write(candidatesData.get(i).getCangpa() + ",");
                bw.write(candidatesData.get(i).getCompany() + ",");
                bw.write(candidatesData.get(i).getPosition() + ",");
                bw.write(candidatesData.get(i).getCanyearsexp() + ",");
                bw.write(candidatesData.get(i).getCaninterviewscore() + ",");
                bw.write(candidatesData.get(i).getCanemail() + ",");
                bw.write(candidatesData.get(i).getCanphone() + ",");
                bw.write(candidatesData.get(i).getCanSalary() + ",");
                bw.write(candidatesData.get(i).getCangender() + ",");
                bw.write(candidatesData.get(i).getCanreallocation() + ",");
                bw.write(candidatesData.get(i).getCantravel() + ",");
                bw.write(candidatesData.get(i).getCandriving() + ",");
                bw.write(candidatesData.get(i).getCanaddress() + ",");
                bw.write(candidatesData.get(i).getCancity() + ",");
                bw.write(candidatesData.get(i).getCancountry() + ",");
                bw.write(candidatesData.get(i).getCanskills1cat() + ",");
                bw.write(candidatesData.get(i).getCanskills1() + ",");
                bw.write(candidatesData.get(i).getCanskills1value() + ",");
                bw.write(candidatesData.get(i).getCanskills2cat() + ",");
                bw.write(candidatesData.get(i).getCanskills2() + ",");
                bw.write(candidatesData.get(i).getCanskills2value() + ",");
                bw.write(candidatesData.get(i).getCanskills3cat() + ",");
                bw.write(candidatesData.get(i).getCanskills3() + ",");
                bw.write(candidatesData.get(i).getCanskills3value() + ",");
                bw.write(candidatesData.get(i).getCanskills4cat() + ",");
                bw.write(candidatesData.get(i).getCanskills4() + ",");
                bw.write(candidatesData.get(i).getCanskills4value() + ",");
                bw.write(candidatesData.get(i).getCanskills5cat() + ",");
                bw.write(candidatesData.get(i).getCanskills5() + ",");
                bw.write(candidatesData.get(i).getCanskills5value() + ",");
                bw.write(candidatesData.get(i).getCancomptency1cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency1() + ",");
                bw.write(candidatesData.get(i).getCancomptency1value() + ",");
                bw.write(candidatesData.get(i).getCancomptency2cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency2() + ",");
                bw.write(candidatesData.get(i).getCancomptency2value() + ",");
                bw.write(candidatesData.get(i).getCancomptency3cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency3() + ",");
                bw.write(candidatesData.get(i).getCancomptency3value() + ",");
                bw.write(candidatesData.get(i).getCancomptency4cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency4() + ",");
                bw.write(candidatesData.get(i).getCancomptency4value() + ",");
                bw.write(candidatesData.get(i).getCancomptency5cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency5() + ",");
                bw.write(candidatesData.get(i).getCancomptency5value() + ",");
                bw.write(candidatesData.get(i).getCanjobID() + ",");
                bw.write(candidatesData.get(i).getCanprocessed() + "\n");
            }
            bw.close();
            fw.close();
            pWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(AJCSS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// All job functional requirements has similar code implmentation, you can check out the full source code on GitHub.
