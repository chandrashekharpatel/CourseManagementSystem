package com.course.management.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.management.model.Topics;
import com.course.management.repository.TopicRepository;

@Service
public class TopicService {
	private final String uploadDir = "D:/React-Application/ImageStorage";
	@Autowired
	private TopicRepository topicRepository;
       public void save(Topics topics) {
    	   topicRepository.save(topics);
       }
       public void saveAll(List<Topics> topics) {
           topicRepository.saveAll(topics);
       }
       public void update(Topics topic) {
    	   topicRepository.save(topic);
       }
       public void delete(int id) {
    	   topicRepository.deleteById(id);
       }
       public Topics getTopicsById(int id) {
    	   return topicRepository.findById(id).get();
       }
       public List<Topics> getAllTopics(){
    	   List<Topics> newList=new ArrayList<>();
    	   topicRepository.findAll().forEach(l->newList.add(l));
    	   return newList;
       }
       
//       public String saveFile(MultipartFile file) throws IOException {
//           String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//           File targetFile = new File("D:\\React-Application\\ImageStorage" + fileName);
//           file.transferTo(targetFile);
//           return targetFile.getAbsolutePath();
//       }
//       
//       public void saveTopics(int courseId, int lessionId, String title, String summary,
//               String completionTime, int active, int sequence, String body,
//               String imageUrl, String videoUrl, String document) {
//               topicRepository.saveTopics(courseId, lessionId, title,summary,completionTime,                      active, sequence, body, imageUrl, videoUrl, document);
//           }
       
       public Topics saveTopicsData(Topics topics) {
    	   Topics topic=topicRepository.save(topics);
    	   return topic;
       }
       
       public String saveFiles(MultipartFile file) throws IOException {
           String fileName = StringUtils.cleanPath(UUID.randomUUID().toString() + "-" + file.getOriginalFilename());
           Path targetLocation = Paths.get(uploadDir, fileName);
           Files.createDirectories(targetLocation.getParent());
           Files.copy(file.getInputStream(), targetLocation);
           return targetLocation.toString();
       }
       
}
