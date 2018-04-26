package com.poc.batch.SpringBootBatchPoc.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.poc.batch.SpringBootBatchPoc.dao.PpmProjectInfoDao;
import com.poc.batch.SpringBootBatchPoc.model.PpmProjectInfo;
import com.poc.batch.SpringBootBatchPoc.model.ProjectData;

public class Processor implements ItemProcessor<ProjectData, ProjectData> {

	private static final Logger log = LoggerFactory.getLogger(Processor.class);
	
	private final PpmProjectInfoDao ppmProjectInfoDao;

	public Processor(PpmProjectInfoDao ppmProjectInfoDao) {
		this.ppmProjectInfoDao = ppmProjectInfoDao;
	}
	
	
	@Override
	public ProjectData process(final ProjectData projectData) throws Exception {
		PpmProjectInfo ppmProjectInfo= new PpmProjectInfo(Integer.parseInt(projectData.getBatchId()), projectData.getStatus(), projectData.getProjectType(),
				projectData.getProjectNumber(),"", projectData.getProjectDescription(), projectData.getProjectCategory(),
				projectData.getPlatform(), projectData.getProjectGate(), projectData.getProjectStartDate(),projectData.getProjectEndDate());
		ppmProjectInfo = ppmProjectInfoDao.insert(ppmProjectInfo);
		String errorMessage;
		final ProjectData transformedProjectData = null;
		try {
			// Pojo vaidation
			/*if(Integer.parseInt(projectData.getProjectNumber()) || projectData.getProjectNumber().length()) {
				
			}*/
			
		}catch(Exception e) {
			
		}
		
		
		
		/*final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();

		final Person transformedPerson = new Person(firstName, lastName, person.getEmail(), person.getAge(), person.getInsertFlag());

		log.info("Converting (" + person + ") into (" + transformedPerson + ")");*/

		return transformedProjectData;
	}

}