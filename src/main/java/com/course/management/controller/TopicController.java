package com.course.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.util.StringUtils;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.course.management.model.Topics;
import com.course.management.service.TopicService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class TopicController {
    @Autowired
    private TopicService topicService;
    public static String uploadDirectory=System.getProperty("user.dir") + "/src/main/webapp/images";
//    @PostMapping("/createTopics")
//    public ResponseEntity<String> createTopic(
//            @RequestParam("courseId") int courseId,
//            @RequestParam("lessionId") int lessionId,
//            @RequestParam("title") String title,
//            @RequestParam("summary") String summary,
//            @RequestParam("completionTime") String completionTime,
//            @RequestParam("active") int active,
//            @RequestParam("sequence") int sequence,
//            @RequestParam("body") String body,
//            @RequestParam("videoUrl") MultipartFile videoUrls,
//            @RequestParam("imageUrl") MultipartFile imageUrls,
//            @RequestParam("document") MultipartFile documents
//    ) {
//        try {
//            String imageUrl = topicService.saveFile(imageUrls);
//            String videoUrl = topicService.saveFile(videoUrls);
//            String documentUrl = topicService.saveFile(documents);
//            topicService.saveTopics( courseId, lessionId, title, summary, completionTime, active, sequence, body, imageUrl, videoUrl, documentUrl);
//            return ResponseEntity.ok("Topic created successfully.");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating topic: " + e.getMessage());
//        }
//    }
        @PostMapping("/createTopic")
        public int save(@RequestBody Topics topic) {
        	topicService.save(topic);
        	return topic.getId();       
    }


    @PutMapping("/updateTopics")
    private Topics update(@RequestBody Topics topics) {
    	topicService.update(topics);
    	return topics;
    }
    @DeleteMapping("/deleteTopics/{id}")
    private void delete(@PathVariable("id") int id) {
    	topicService.delete(id);
    }
    @GetMapping("/topics/{id}")
    private Topics findById(@PathVariable("id") int id) {
    	 return topicService.getTopicsById(id);
    }
    @GetMapping("/topics")
    private  List<Topics> getAllTopics(){
    	return topicService.getAllTopics();
    }

@GetMapping("/topicss")
public List<Topics> getAllTopicss() {
    List<Topics> topics = topicService.getAllTopics();
    for (Topics topic : topics) {
        String imageUrl = topic.getImageUrl();
        System.out.println("Check :: 88 Controller :: "+imageUrl);
        // Assuming imageUrl contains the relative path to the image file
        // Construct the complete image URL using the server URL
        topic.setImageUrl("http://localhost:9080/images/" + imageUrl);
    }
    return topics;
}
    
//    @GetMapping("/topics")
//    public List<Topics> getAllTopics() {
//        List<Topics> topics = topicService.getAllTopics();
//        for (Topics topic : topics) {
//            String imageUrl = topic.getImageUrl();
//            // Construct the complete image URL including the file path
//            topic.setImageUrl("http://localhost:9080/ImageStorage/" + imageUrl);
//        }
//        return topics;
//    }

//    @PostMapping("/saveTopics")
//    public Topics saveTopicsData(@ModelAttribute Topics topics , @RequestParam("image") MultipartFile file) throws IOException {
//    	 String origionalFileName=file.getOriginalFilename();
//    	 Path fileNameAndPath=Paths.get(origionalFileName, uploadDirectory);
//    	 Files.write(fileNameAndPath, file.getBytes());
//    	 topics.setImageUrl(origionalFileName);
////    	 topics.setDocument(origionalFileName);
////    	 topics.setVideoUrl(origionalFileName);
//    	Topics topic=topicService.saveTopicsData(topics);
//    	return topic;
//    }
    @PostMapping("/saveTopics")
    public Topics saveTopicsData(@ModelAttribute Topics topics,
                                 @RequestParam("image") MultipartFile imageFile,
                                 @RequestParam("video") MultipartFile videoFile,
                                 @RequestParam("documents") MultipartFile documentFile
                                 )  throws IOException {
    	
        // Save image file
        if (!imageFile.isEmpty()) {
            String imageName = StringUtils.cleanPath(imageFile.getOriginalFilename());
            Path imagePath = Paths.get(uploadDirectory, imageName);
            Files.write(imagePath, imageFile.getBytes());
            topics.setImageUrl(imageName);
        }

        // Save video file
        if (!videoFile.isEmpty()) {
            String videoName = StringUtils.cleanPath(videoFile.getOriginalFilename());
            Path videoPath = Paths.get(uploadDirectory, videoName);
            Files.write(videoPath, videoFile.getBytes());
            topics.setVideoUrl(videoName);
        }

        // Save document file
        if (!documentFile.isEmpty()) {
            String documentName = StringUtils.cleanPath(documentFile.getOriginalFilename());
            Path documentPath = Paths.get(uploadDirectory, documentName);
            Files.write(documentPath, documentFile.getBytes());
            topics.setDocument(documentName);
        }
        return topicService.saveTopicsData(topics);

}
    @PostMapping("/saveTopic")
    public Topics saveTopics(@ModelAttribute Topics topics,
                                 @RequestParam("image") MultipartFile imageFile,
                                 @RequestParam("video") MultipartFile videoFile,
                                 @RequestParam("documents") MultipartFile documentFile
                                 
                                 ) throws IOException {
        // Process and save image, video, and document files
        String imageUrl = topicService.saveFiles(imageFile);
        String videoUrl = topicService.saveFiles(videoFile);
        String documentUrl =topicService.saveFiles(documentFile);
        
        // Set the URLs to the respective fields in the Topics entity
        topics.setImageUrl(imageUrl);
        topics.setVideoUrl(videoUrl);
        topics.setDocument(documentUrl);
        
        // Save the Topics entity
        return topicService.saveTopicsData(topics);
    }
    
}
