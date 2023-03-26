package com.test.demo.service.impl;

import com.test.demo.entity.Publisher;
import com.test.demo.exception.NotFoundException;
import com.test.demo.repository.PublisherRepository;
import com.test.demo.service.PublisherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PublisherServiceImpl implements PublisherService {
    final PublisherRepository publisherRepository;
    public PublisherServiceImpl(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll ();
    }
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public Publisher findPublisherById(Long id){
        return  publisherRepository.findById (id)
                .orElseThrow (()-> new NotFoundException (String.format ("Publisher not found with ID %d", id)));
    }
    @Override
    public void createPublisher(Publisher publisher){
        publisherRepository.save (publisher);
    }
    @Override
    public void updatePublisher(Publisher publisher){
        publisherRepository.save (publisher);
    }
    @Override
    public void deletePublisher(Long id) {
        var publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Publisher not found  with ID %d", id)));

        publisherRepository.deleteById(publisher.getId());
    }

}
