package com.codeclan.example.FilesAndFolders.components;


import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.models.User;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.example.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User user1 = new User("Mickey");
        userRepository.save(user1);

        User user2 = new User("Donald");
        userRepository.save(user2);

        Folder folder1 = new Folder("Photos", user2);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("TextFiles", user1);
        folderRepository.save(folder2);

        File file1 = new File("Bahamas", ".jpg", 500, folder1);
        fileRepository.save(file1);

        File file2 = new File("CV", ".doc", 50, folder2);
        fileRepository.save(file2);

        user1.addFolder(folder1);
        user2.addFolder(folder2);

        folder1.addFile(file1);
        folder2.addFile(file2);


    }
}
